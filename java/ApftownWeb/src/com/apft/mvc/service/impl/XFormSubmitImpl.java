package com.apft.mvc.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.apft.mvc.dao.CommDao;
import com.apft.mvc.service.XFormSubmit;




@Service
public class XFormSubmitImpl implements XFormSubmit{
	
	public static final String DB_NULL = "@nULL@";
	public static final String DB_SUID = "@sUid@";
	public static final String DB_TIME = "@tIMe@";

	static final char DB_CMD_CH = '#';
	static final char DB_PRO_CH = '.';
	
	public String saveOrUpdatgeFormListMap(CommDao dao, Map<String, String> mapPara, String uid) {
		String id = null;
		
		int ret = 0, cur_ret;
		List<Map<String,Object>> lstMapForm = getFormListMap(mapPara, uid);
		
//		logFormListMap(lstMapForm);
		
//		dao.setAutoCommit(false);
		
		
		for(int i=0;i<lstMapForm.size();i++){
			Map<String,Object> map = lstMapForm.get(i);
			
			String tblName = (String)map.get("table");
//			Map mapTbl = (Map)map.get("data");
			Map<String,Object> mapTbl = (Map<String, Object>) map.get("data");

	    	String [] UniqueKeys = (String [])map.get(DB_CMD_CH + "un");
	    	if (UniqueKeys != null){
		    	Object [] oA = map2array(mapTbl);

		    	cur_ret = dao.saveUniqueKeys(tblName, oA);
		    	if (cur_ret > 0){
		    		if(id == null)
		    			id = (String)mapTbl.get("id");
		    		ret += cur_ret;
		    	}
		    		
	    	}else{
	    		
/*	    		System.out.println("------------------- " + tblName + "#"+i+" BEGIN ------------------------- ");
		    	for (Map.Entry<String, Object> entry : mapTbl.entrySet()) {
		            System.out.println(entry.getKey() + " = " + entry.getValue());
		        }
		        System.out.println("------------------- " + tblName + " END ------------------------- \r\n\r\n");
*/
		        Object [] oA = map2array(mapTbl);
		        cur_ret = dao.saveOrUpdate(tblName, oA);
		        if (cur_ret > 0){
		    		if(id == null)
		    			id = (String)mapTbl.get("id");
		    		ret += cur_ret;
		    	}
	    	}
			
		}
		return id;
	}	
	
	public void logFormListMap(List<Map<String,Object>> lstMapForm){
		
		for(int i=0;i<lstMapForm.size();i++){
			Map<String,Object> map = lstMapForm.get(i);
			
			String tblName = (String)map.get("table");
//			Map mapTbl = (Map)map.get("data");
			Map<String,Object> mapTbl = (Map<String, Object>) map.get("data");
			
			
	    	
	        
//	    	Object [] oA = map2array(mapTbl);
//	        dao.saveOrUpdate(tblName, oA);
		}
		
		
	}
	
	
	public List<Map<String, Object>> getFormListMap(Map<String, String> mapPara, String uid) {
		// TODO Auto-generated method stub

		String strPrefix = "tb_";

		//存放所有 table {table_name:{#n:{table_column_name:table_column_value}}}
		Map<String,Map<String, Map<String, Object>>> mapTbls1 = new HashMap<String,Map<String, Map<String, Object>>>();
		//存放所有table_name 的别名
		Map<String, String> mapTblsAlias = new HashMap<String, String>();//table 别名
		
		Map<String, Object> mapWhere = new HashMap<String, Object>();
		

		String kNo = DB_CMD_CH+"no";
		String vNo = mapPara.get(kNo);
		if (null != vNo){
			//mapTblsAlias
    		//do sort
    		String [] strTbls = getSplitArray(vNo, ",");
    		List<String> lstOrderTbls = new ArrayList<String>();
    		if (null != strTbls){
    			for(int i=0; i<strTbls.length; i++){
    				String [] tblNameAlias = getSplitArray(strTbls[i], " ");
    				if (tblNameAlias.length > 1){
    					lstOrderTbls.add(tblNameAlias[1]);
    					mapTblsAlias.put(tblNameAlias[0], tblNameAlias[1]);
//    					mapTblsAlias.put(tblNameAlias[1], tblNameAlias[0]);
    				}else
    					lstOrderTbls.add(strTbls[i]);
    			}
    		}
			mapWhere.put(kNo, lstOrderTbls);
		}
		



		
		
		
		Iterator<Entry<String, String>> entries = mapPara.entrySet().iterator();

	    while (entries.hasNext()) {
	    	Map.Entry<String, String> entry = (Map.Entry<String, String>) entries.next();
	    	
	    	String name = (String) entry.getKey();
	        Object valueObj = entry.getValue();

	        String value = "";
	        if(null == valueObj){
	            value = "";
	        }else if(valueObj instanceof String[]){
	            String[] values = (String[])valueObj;
	            for(int i=0;i<values.length;i++){
	                value = values[i] + ",";
	            }
	            value = value.substring(0, value.length()-1);
	        }else{
	            value = valueObj.toString();
	            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	            value = value.replace(DB_TIME, df.format(new Date()));
	            if (null != uid)
	            	value = value.replace(DB_SUID, uid);
	        }
	        
	        if (name.charAt(0)==DB_CMD_CH){	//cmd
	        	if (name.equals(DB_CMD_CH+"pf")){ //e.g: "tb_"
	        		if (value != null)
	        			strPrefix = value;
	        	}else if (name.equals(DB_CMD_CH + "un")){ //e.g: "res_attrib=res_id+label,res_card=res_id+name"
	        		//Unique Key
	        		String [] strItem = getSplitArray(value, ",");
	        		if (null != strItem){
		        		for(int i=0; i<strItem.length; i++){
		        			String [] strKV = getSplitArray(strItem[i], "=");
		        			if (null != strKV && strKV.length==2){
		        				String [] strUniqueKeys = getSplitArray(strKV[1], "\\+");
		        				if (null != strUniqueKeys){
			        				Map<String, Object> mapTbl = getTblMap(strKV[0], mapTbls1, mapTblsAlias);
			        				if (null == mapTbl){
			        					mapTbl = new HashMap<String, Object>();
			        					
			        					setTblMap(strKV[0], mapTbl, mapTbls1, mapTblsAlias);
			        					//mapTbls1.put(strK[0], mapTbl);
			        				}
			        				mapTbl.put(DB_CMD_CH + "un", strUniqueKeys);
		        				}
		        			}
		        		}
	        			
	        		}
	        	}else if (name.equals(DB_CMD_CH + "fl")){ //e.g: "ra.value=notnull,,,"
	        		//fl:filter value
	        		String [] strItem = getSplitArray(value, ",");
	        		if (null != strItem){
		        		for(int i=0; i<strItem.length; i++){
		        			String [] strKV = getSplitArray(strItem[i], "=");
		        			if (null != strKV && strKV.length==2){
		        				String [] strTblCols = getSplitArray(strKV[0], DB_PRO_CH+"");
		        				if (null != strTblCols && strTblCols.length==2){
			        				Map<String, Object> mapTbl = getTblMap(strTblCols[0], mapTbls1, mapTblsAlias);
			        				if (null == mapTbl){
			        					mapTbl = new HashMap<String, Object>();
			        					
			        					setTblMap(strTblCols[0], mapTbl, mapTbls1, mapTblsAlias);
			        					//mapTbls1.put(strK[0], mapTbl);
			        				}
			        				
			        				String k = DB_CMD_CH + "fl";
			        				
			        				Map<String,List> mapFl = (Map<String,List>)mapTbl.get(k);
			        				if (mapFl == null){
			        					mapFl = new HashMap<String,List>();
				        				mapTbl.put(k, mapFl);
			        				}
			        				
			        				List<String> lstFl = (List<String>)mapFl.get(mapFl);
			        				if (lstFl == null)
			        					lstFl = new ArrayList<String>();
			        				lstFl.add(strTblCols[1]);
			        				mapFl.put(strKV[1],lstFl);
			        					
		        				}
		        			}
		        		}
	        			
	        		}
	        	}else if (name.equals(DB_CMD_CH + "fk")){ //e.g: "tb_res_attrible.res_id=tb_res.id"
	        		//foreign key
	        		String [] strItem = getSplitArray(value, ",");
	        		if (null != strItem){
		        		for(int i=0; i<strItem.length; i++){
		        			String [] strKV = getSplitArray(strItem[i], "=");
		        			if (null != strKV && strKV.length==2){
		        				String [] strK = getSplitArray(strKV[0], DB_PRO_CH+"");
		        				String [] strV = getSplitArray(strKV[1], DB_PRO_CH+"");
		        				if (null != strK && strK.length==2 && null != strV && strV.length==2){
		        				
		        					strV[1] = DB_CMD_CH + strV[1]; //set "tb_res_attrible.res_id=tb_res.id"==>"tb_res_attrible.res_id=tb_res.#id"
		        					
			        				Map<String, Object> mapTbl = getTblMap(strK[0], mapTbls1, mapTblsAlias);
			        				if (null == mapTbl){
			        					mapTbl = new HashMap<String, Object>();
			        					
			        					setTblMap(strK[0], mapTbl, mapTbls1, mapTblsAlias);
			        					//mapTbls1.put(strK[0], mapTbl);
			        				}
			        				mapTbl.put(strK[1], strV);
		        				}
		        			}
		        		}
	        			
	        		}
	        		
	        	}
	        	
	        	
	        }else{//table.column
		        String [] names = getSplitArray(name,DB_PRO_CH+"");
		        if (null != names && names.length==2){

		        	Map<String,Object> mapTbl = getTblMap(names[0], mapTbls1, mapTblsAlias);//getTblMap(names[0], mapTbls1, mapTblsAlias);
		        	if (null == mapTbl){
		        		mapTbl = new HashMap<String,Object>();
//		        		mapTbls1.put(names[0], mapTbl);
		        		
		        		setTblMap(
		        				names[0] //表明，tb_res_attrible[#1]
		        				, mapTbl //tb_res_attrible的字段 kv
		        				, mapTbls1 //存放所有 table {table_name:{#n:{table_column_name:table_column_value}}}
		        				, mapTblsAlias //存放所有table_name 的别名
		        				);
		        	}
	        		mapTbl.put(names[1], value);
		        }
	        	
	        }
	        
	    }
	    
	    //处理表顺序
	    List<String> lstOrderTbls = (List<String>)mapWhere.get(DB_CMD_CH+"no");
	    if (null == lstOrderTbls)
	    	lstOrderTbls = new ArrayList<String>();
	    
	    for (Map.Entry<String, Map<String,Map<String,Object>>> entry : mapTbls1.entrySet()) {
	    	String tblName = entry.getKey();
	    	int i=0;
	    	for(; i<lstOrderTbls.size(); i++){
	    		if (tblName.equals(lstOrderTbls.get(i)))
	    			break;
	    	}
	    	if (i>=lstOrderTbls.size())
	    		lstOrderTbls.add(tblName);
	    	
	    	
	    	
	    }
	    
	    //生成SQL
		List<Map<String,Object>> lstMapRet = new ArrayList<Map<String,Object>>();
	    for(int i=0; i<lstOrderTbls.size(); i++){
	    	String tblName = lstOrderTbls.get(i);
	    	
	    	
	    	//////////////////////////// start
	    	List<String> lstFl = null;
	    	Map<String, Object> mapTblFl = getTblMap(tblName, mapTbls1, mapTblsAlias);
	    	if (null != mapTblFl){
	    		Map<String,Object>mapFl = (Map<String,Object>)mapTblFl.get(DB_CMD_CH + "fl");
		    	if (mapFl != null){
		    		lstFl = (List<String>)mapFl.get("notnull");
		    	
		    		mapTblFl.remove(DB_CMD_CH + "fl");
		    	}
	    	}
	    	////////////////////////////////////// end
	    	
	    	
	    	
	    	Map<String,Map<String,Object>> mapTblRecs = mapTbls1.get(tblName);//getTblMap(tblName, mapTbls1, mapTblsAlias);
	    	
	    	Map<String,Object> mapTblNotNo = mapTblRecs.get(""); //记录没有编号的记录(缺省第一条记录)
   	
	    	
			Iterator<Map.Entry<String, Map<String,Object>>> it = mapTblRecs.entrySet().iterator();//扫描其它记录  
	        while(it.hasNext()){
	            Map.Entry<String, Map<String,Object>> entry=it.next();  
	            
	            Map<String,Object> mapTbl = entry.getValue();

	    		String strTmp = (String)mapTbl.get("id");
	    		if (strTmp == null || strTmp.length()==0)
	    			mapTbl.put("id", genUUID());
	    		
	            if(mapTblNotNo.equals(mapTbl))
	            	continue;
	    		
	            String recordNo = entry.getKey();//记录编号
//	    		if (recordNo.length()<=0) continue;

	    		strTmp = tblName;
	    		if (recordNo.length()>0)
	    			strTmp += DB_CMD_CH+recordNo;
	    		
	    		//先处理其它带#no的 mapTbl 是否有外检
	    		if (setTblFK(strTmp, mapTbl, mapTblNotNo, mapTbls1, mapTblsAlias) == false || checkUniquekeys(mapTbl) == false){
	    			it.remove();
	    		}else{
		    		//notnull
		    		if (null != lstFl){
			    		for(String k: lstFl){
			    			Object o = mapTbl.get(k);
			    			if (null == o || ((String)o).equals(""))
			    				it.remove();
			    		}
		    		}
	    		}
	    		
	    		

	    		
	        }
	        //再处理不带#no的记录 是否有外检
	        if (setTblFK(tblName, mapTblNotNo, mapTblNotNo, mapTbls1, mapTblsAlias) == false || checkUniquekeys(mapTblNotNo) == false){
	        	mapTblRecs.remove("");
    		}else{
	    		//notnull
	    		if (null != lstFl){
		    		for(String k: lstFl){
		    			Object o = mapTblNotNo.get(k);
		    			if (null == o || ((String)o).equals(""))
		    				mapTblRecs.remove("");
		    		}
	    		}
    		}
	    	
	        

	        
           
            for (Map.Entry<String, Map<String,Object>> entryRec : mapTblRecs.entrySet()) {
	    		
	    		Map<String,Object> mapTbl = entryRec.getValue();
	    		String key = entryRec.getKey();
	    				    	
		    	String realTblName = getMapKey(mapTblsAlias, tblName);
		    	
		    	if (null !=strPrefix)
		    		realTblName = strPrefix+realTblName;
		    	
          
	            Map<String,Object> mapTblRet = new HashMap<String,Object>();
	            
	            mapTblRet.put("table", realTblName);
	            mapTblRet.put("data", mapTbl);
	            
	            String [] UniqueKeys = (String [])mapTbl.get(DB_CMD_CH + "un");
	            if (UniqueKeys != null){
	            	mapTblRet.put(DB_CMD_CH + "un", UniqueKeys);
	            	mapTbl.remove(DB_CMD_CH + "un");
	            }
	            

	            
	            
	            
	            

	            lstMapRet.add(mapTblRet);

	    	}	    	
            
	    }
	    
	    return lstMapRet;
	}

	
	
	
	public static Object [] map2array(Map<String,Object> map){
		List<Object> lstRet = new ArrayList<Object>();
		Iterator<Entry<String, Object>> entries = map.entrySet().iterator();

	    while (entries.hasNext()) {
	    	Map.Entry<String,Object> entry = (Map.Entry<String,Object>) entries.next();
	    	String name = (String) entry.getKey();
	        Object valueObj = entry.getValue();
	        
	        lstRet.add(name);
	        lstRet.add(valueObj);
	    }
	    return lstRet.toArray();
	}
	


	
	
	public static String [] getSplitArray(String src, String split){
		if (split.equals("."))
			split = "\\.";
		String [] ret = null;
		ret = src.split(split);
		if (null != ret)
			for(int i=0; i<ret.length; i++){
				ret[i] = ret[i].trim();
			}
		return ret;
	}
	
	
	
	private String getMapKey(Map<String, String> mapTblsAlias, String val ){
//    	String strTmp = mapTblsAlias.get(tblName);
		Iterator<Entry<String, String>> entries = mapTblsAlias.entrySet().iterator();

	    while (entries.hasNext()) {
	    	Map.Entry<String, String> entry = (Map.Entry<String, String>) entries.next();

	    	String v = entry.getValue();
	    	if (val.equals(v))
	    		return entry.getKey();
	    }
	    return val;	
	}
	
	
	private String [] getTblRec(String key){
		
    	String tblMulName [] = getSplitArray(key, DB_CMD_CH+"");
    	
    	String tblName = tblMulName[0];
    	String tblNameRec;
    	if (tblMulName.length == 2){
    		tblNameRec = tblMulName[1];
    	}else{
    		tblNameRec = "";
    	}
    	String [] ret = {tblName, tblNameRec};
    	return ret;
	}
	
	
/*	
	private Map<String, Object>getTblMap(String key, Map<String,Map<String, Object>> mapTbls, Map<String, String> mapTblsAlias){
		Map<String, Object> mRet = mapTbls.get(key);
		if (null == mRet)
			mRet = mapTbls.get(mapTblsAlias.get(key));
		return mRet;
	}
*/
	private Map<String, Object>getTblMap(String key,  Map<String,Map<String, Map<String, Object>>> mapTbls, Map<String, String> mapTblsAlias){

		String [] tblRec = getTblRec(key);
		
		Map<String, Map<String, Object>> mTbl = mapTbls.get(tblRec[0]);
		if (null == mTbl)
			mTbl = mapTbls.get(mapTblsAlias.get(tblRec[0]));
		
		if (null != mTbl){
			return mTbl.get(tblRec[1]);
		}
		return null;
	}

	
	private void setTblMap(
			  String tblName //表明，tb_res_attrible[#1]
			, Map<String, Object> mapTbl //tb_res_attrible的字段 kv
			, Map<String,Map<String, Map<String, Object>>> mapTbls //存放所有 table {table_name:{#n:{table_column_name:table_column_value}}}
			, Map<String, String> mapTblsAlias //存放所有table_name 的别名
			)
	{
	
		
		String [] tblRec = getTblRec(tblName);
		
		String aliasName = mapTblsAlias.get(tblRec[0]);
		if (aliasName != null)
			tblRec[0] = aliasName;
		
		Map<String, Map<String, Object>> mapTblRecs = mapTbls.get(tblRec[0]);//取表
		if (null == mapTblRecs){
			mapTblRecs = new HashMap<String, Map<String, Object>>();
			mapTbls.put(tblRec[0], mapTblRecs);
			
			mapTblRecs.put(tblRec[1], mapTbl);
		}else{
			 Map<String, Object> findMapTbl = mapTblRecs.get(tblRec[1]);
			 if (null == findMapTbl)
				 mapTblRecs.put(tblRec[1], mapTbl);
		}
		
		
//		mRet.put(key, value);
		return;
	}

	
	/***
	 * 
	 * map.put("#fk", "ra.res_id=res.id,rc.res_id=r.id,res_ex.res_id=r.id");//fk:外键
	 * @param tblName
	 * @param mapTblNotNo 没有标号的记录，带有外键描述信息，但是其他记录里没有这个，所以这个方式需要带外键记录
	 */
	private boolean setTblFK(
			  String tblName // ra#1 = tb_res_attrible#1
			, Map<String, Object> mapTbl
			, Map<String, Object> mapTblNotNo
			, Map<String,Map<String, Map<String, Object>>> mapTbls
			, Map<String, String> mapTblsAlias
			){
		boolean ret = false;
		
		for (Map.Entry<String, Object> entry : mapTblNotNo.entrySet()) {
	    	
			String k = (String)entry.getKey();
			
			if (k.startsWith("#"))
				continue;
			
			Object v = entry.getValue();
			if (v instanceof String []){
				String [] strV = (String[])v;

				Map<String,Object> mapTblPrimary = getTblMap(strV[0], mapTbls, mapTblsAlias);//mapTbls1.get(strV[0]);
				if (null != mapTblPrimary){
		    		String strFKV = (String)mapTblPrimary.get(strV[1].substring(1));
		    		
//		    		if (null == strFKV || strFKV.length()==0){
//		    			strFKV = genUUID();
//		    			mapTblPrimary.put(strV[1].substring(1), strFKV);
//		    		}
		    		
		    		if (mapTbl.equals(mapTblNotNo))
		    			entry.setValue(strFKV);
		    		else
		    			mapTbl.put(k, strFKV);
		    		ret = true;
				}
				
			}else{
				if (!k.equalsIgnoreCase("id"))
					ret = true;
				if (v instanceof String && v.equals(DB_NULL)){
					entry.setValue(null);
				}
			}
		}
		
		return ret;
	}


	boolean checkUniquekeys(Map<String, Object> mapTbl){
		//处理#un : Unique key
		String [] UniqueKeys = (String [])mapTbl.get(DB_CMD_CH + "un");
		if (null != UniqueKeys){
			for(int i=0;i<UniqueKeys.length;i++){
				if (mapTbl.get(UniqueKeys[i])== null)
					return false;
			}
//			mapTbl.remove(DB_CMD_CH + "un");
		}
		return true;
	}
	
	
	public static String genUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
	

	

	/********************************************************************************************************/

	public void test2(){
		Map<String,String> map = new HashMap<String,String>();

		/*map.put("#no", "res r,res_card rc,res_attrib ra");//no:处理序号
		map.put("#fk", "ra.res_id=r.id,rc.res_id=r.id");//fk:外键
		map.put("#un", "ra=res_id+label,rc=res_id+name");//un:Unique key
		map.put("#fl", "ra.value=notnull");//fl:filter value

		map.put("r.id", "id_test_001");
		map.put("r.title", "001 title");


		map.put("ra.label", "att_#_001 label");
		map.put("ra.value", "bbbb");
		
		map.put("ra#1.label", "att_#1_001 label");
		
		map.put("ra#2.label", "att_#1_001 label");
		map.put("ra#2.value", "aaaa");

		map.put("rc.name", "rc#_name.valueaaa");
		map.put("rc.name", "rc#_content.valueaaaa");
		
		map.put("rc#1.name", "rc#_namebbbbb");*/
		
		map.put("#no", "audit_company ac,audit_company_card acc,audit_company_attrib aa");//no:处理序号
		map.put("#fk", "acc.company_id=ac.id,aa.company_id=ac.id");//fk:外键
		map.put("#un", "aa=company_id+label,acc=company_id+name");//un:Unique key
		map.put("#fl", "aa.value=notnull,acc.content=notnull");//fl:filter value

		map.put("ac.id", "id_test_001");
		map.put("ac.title", "001 title");


		map.put("aa.label", "att_#_001 label");
		map.put("aa.value", "bbbb");
		
		map.put("aa#1.label", "att_#1_001 label");
		
		map.put("aa#2.label", "att_#1_001 label");
		map.put("aa#2.value", "aaaa");

		map.put("acc.name", "rc#_name.valueaaa");
		map.put("acc.content", "rc#_content.valueaaaa");
		
		map.put("acc#1.name", "rc#_namebbbbb");
		

		List<Map<String,Object>> lstMapForm = getFormListMap(map, null);
		
		logFormListMap(lstMapForm);
	}
	
	public void test(){
		Map<String,String> map = new HashMap<String,String>();

//		map.put("#pf", "");//prefixes:前缀("tb_" default value )
		
		map.put("#un", "res_attrib=res_id+label,res_card=res_id+name");//un:Unique key
		
		map.put("#no", "res r,res_attrib ra,res_card rc");//no:处理序号
//		map.put("#no", "res");//no:处理序号

		map.put("#fk", "ra.res_id=res.id,rc.res_id=r.id");//fk:外键
//		map.put("#fk", "rc.res_id=r.id");//fk:外键

		map.put("r.id", "id_test_001");
		map.put("r.title", "001 title");

		
	//	map.put("re.col1", "col1 001 label");
	//	map.put("re.col2", "col2 001 label");
		
//		map.put("ra.id", "id_test_attr_001");
//		map.put("ra.res_id", "id_test_001");
		map.put("ra.k", "001 label");
		map.put("ra.v", "001 value");
		
		map.put("rc.k", "001 label");
		map.put("rc.v", "001 valuercrc");

//		map.put("rc.id", "id_test_attr_001");
//		map.put("rc.content", "id_test_attr_001.card.content");
		
//		doParameterMap(map);

	}
	
	
	public static void main(String []argv){
		
		
/*		
		Map<String,Map<String, Object>> mapTbls = new HashMap<String,Map<String, Object>>();
		
		Map<String, Object> mapTbl = new HashMap<String, Object>();
		mapTbl.put("a.1", "a.1.value");
		
		mapTbls.put("a", mapTbl);
		
		Map<String, Object> mapTbl2 = mapTbls.get("a");
		
		mapTbl2.put("a.2", "a.2.value");
		
		
		Map<String, Object> mapTbl3 = mapTbls.get("a");
*/	
		new XFormSubmitImpl().test2();
		
	}


	
}
