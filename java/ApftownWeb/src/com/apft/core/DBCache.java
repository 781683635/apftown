package com.apft.core;

/*
 * Project : DBCache
 * Version : 1.0
 * @author : stkking@qq.com
 * Date : 2016/03/25
 * */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.apft.mvc.dao.DBManager;


/***
 * 
 * DBCacheOjbect : MYSQL select 查询数据库缓存对象
 * 
 *
 */
class DBCacheOjbect{
	//public static final int DEFAULT_CACHE_TIME = 180000; // 3 minute

	public static final int DEFAULT_CACHE_TIME = 15000; // 15 miao

	private long _updateTime;
	private int _minUpdateTime;
	private Object _data;
	
	public DBCacheOjbect(Object data){
		update(data, DEFAULT_CACHE_TIME);
	}
	
	public DBCacheOjbect(Object data, int timeMillis){
		if (timeMillis<=0)
			timeMillis = DEFAULT_CACHE_TIME;
		update(data, timeMillis);
	}
	
	public void update(Object data, int timeMillis){
		_updateTime = System.currentTimeMillis();
		_minUpdateTime = timeMillis;
		_data = data;
	}
	
	boolean isInvalid(){
		if (System.currentTimeMillis() - _updateTime > _minUpdateTime)
			return true;
		return false;
	}
	
	
	public Object get(){
		return _data;
	}
	
} 


/*
 * Project : DBCache
 * Version : 1.0
 * @author : stkking@qq.com
 * Date : 2016/03/25
 * */

public class DBCache {
	
	private static final int DEFAULT_TIME = 60000; 
	
	private static DBCache _hInstance = null;
	private static Object _lock = new Object();
	
	private static ReadWriteLock _mapLock = new ReentrantReadWriteLock();
	private static Lock _mapLockRead = _mapLock.readLock();  
	private Lock _mapLockWrite = _mapLock.writeLock();  
	
	private  Map<String,DBCacheOjbect> _mapCnt = new HashMap<String,DBCacheOjbect>();
	
	private  Map<String,DBCacheOjbect> _map = new HashMap<String,DBCacheOjbect>();
//	private  Map<String,DBCacheOjbect> _map = new ConcurrentHashMap<String,DBCacheOjbect>();
	
	private DBCache(){
		OnTimerThread thread = new OnTimerThread();
		thread.start();
	}
	
	
	public void updateDB(){
		List<String> lstSQL = new ArrayList<String>();
		_mapLockWrite.lock();
		Iterator<Entry<String, DBCacheOjbect>> it = _mapCnt.entrySet().iterator(); 
		while(it.hasNext()){
			Entry<String, DBCacheOjbect> entry=it.next();
			DBCacheOjbect dbObj = entry.getValue(); 
			if (dbObj.isInvalid()){
				it.remove(); //OK 

				String datas [] = (String [])dbObj.get();
				String strSQL = "UPDATE "+datas[0]+" SET "+datas[1]+'='+datas[1]+'+'+datas[3] + " WHERE id='"+datas[2]+"'";
				datas[2]="0";
				
				lstSQL.add(strSQL);
			}	
		} 
		_mapLockWrite.unlock();

		if (lstSQL.size() > 0)
			DBManager.getInstance().getSQLDao().batchUpdate(lstSQL.toArray(new String[lstSQL.size()]));
	}
	
	
	
	static public DBCache getInstance(){
//		synchronized(_lock) {
//			if (_hInstance==null){
//				_hInstance = new DBCache();
//			}
//		}

		_mapLockRead.lock();
		if (_hInstance==null){
			_hInstance = new DBCache();
		}
		_mapLockRead.unlock();
		return _hInstance;
	}
	
	
	class OnTimerThread extends Thread{
        @Override
        public void run() {
        	while(true){
        		try {
					Thread.sleep(DEFAULT_TIME);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		getInstance().updateDB();
        	}
        }
    }
	
	
	/***
	 * 
	 * @param tblNameIdCol : "tb_res.{id}.view_times"
	 * @return
	 */
	public int getCount(String tblName, String colName, String id){
		try{
			DBCacheOjbect dbObj = _mapCnt.get(tblName + id + colName);
			if (dbObj != null){
				String [] datas = (String [])dbObj.get();
				return Integer.parseInt(datas[3]);
			}
		}catch(Exception e){}
		return 0;
	}
	
	public int addCount(String tblName, String colName, String id){
		
		String key = tblName + id + colName;
		String [] datas;
		try{
			DBCacheOjbect dbObj = _mapCnt.get(key);
			if (dbObj != null){
				datas = (String [])dbObj.get();
				datas[3] = Integer.toString( (Integer.parseInt(datas[3]) + 1) );
				return Integer.parseInt(datas[3]);
			}
		}catch(Exception e){}
		datas = new String[4];
		datas[0] = tblName;
		datas[1] = colName;
		datas[2] = id;
		datas[3] = "1";
		
		DBCacheOjbect dbObj = new DBCacheOjbect(datas, DEFAULT_TIME);//600000
		_mapCnt.put(key, dbObj);
		return 1;
	}

	
	public boolean getActTime(String resid, String type, String sessionId){
		DBCacheOjbect dbObj = _map.get(resid + type + sessionId);
		if (null != dbObj)
			return !(dbObj.isInvalid());
		else
			set(resid + type + sessionId, null, 15*600000);
		return true;
	}
	
	

	
	/*
	 * 
	 * */
	public Object get(String key){
		DBCacheOjbect dbObj;
		_mapLockRead.lock();
		dbObj = _map.get(key);
		_mapLockRead.unlock();

		if (dbObj != null){
			if (!dbObj.isInvalid())
				return dbObj.get();
		}
		return null;
	}
	
	/***
	 * 
	 * @param key
	 * @param data
	 * 默认 15000 = 3分钟
	 */
	public void set(String key, Object data){
		set(key, data, DBCacheOjbect.DEFAULT_CACHE_TIME);
	}
	
	/***
	 * 
	 * @param key
	 * @param data
	 * @param defaultTime 	毫秒
	 */
	public void set(String key, Object data, int defaultTime){
		DBCacheOjbect dbObj = new DBCacheOjbect(data, defaultTime);
		
		_mapLockWrite.lock();
		_map.put(key,dbObj);
		_mapLockWrite.unlock();
	}
	
	
	/*
	 * 定时释放内存，最好每天凌晨执行一次
	 * */
	public void free(){
		_mapLockWrite.lock();
		Iterator<Entry<String, DBCacheOjbect>> it = _map.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String, DBCacheOjbect> entry = it.next();
			if (entry.getValue().isInvalid()){
				it.remove();    
			}
//			String key = entry.getKey();
		}		
		_mapLockWrite.unlock();
	}
}
