package com.apft.mvc.dao;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apft.core.DBCache;
import com.apft.utils.MYSQLEncoder;
import com.apft.utils.ZLUtils;





@Service
@Transactional
public class CommDao{

	public final static short CACHE_NO_TIME = 0;//最小缓存值
	public final static short CACHE_MIN_TIME = 1;//最小缓存值
	public final static short CACHE_MAX_TIME = 2;//最小缓存值
	
	@Resource
	private JdbcTemplate jdbcTemplate;

	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	
	
	
	
	public int[] updateBatch(String []sql){
		return jdbcTemplate.batchUpdate(sql);

	}
	
	
	public int update(String sql){
		return jdbcTemplate.update(sql);
	}
	
	
	public int delete(String sql) {
		return jdbcTemplate.update(sql);
	}
	
	
	public List<Object> queryForList(String sql, Class T, int cacheTime) {
		if (cacheTime<0){
			return jdbcTemplate.queryForList(sql, T);
		}else {
			List<Object> resList = (List<Object>)DBCache.getInstance().get(sql);
			
				
			if (null == resList){
				resList = jdbcTemplate.queryForList(sql, T);
				if (cacheTime == 0)
					DBCache.getInstance().set(sql, resList);
				else
					DBCache.getInstance().set(sql, resList, cacheTime);
			}
			return resList;
		}
	}
	
	
	public Object queryForObject(String sql, Class T, int cacheTime) {
		
		try{
			RowMapper<Object> rm = (RowMapper<Object>) ParameterizedBeanPropertyRowMapper.newInstance(T);
			if (cacheTime<0){
				return jdbcTemplate.queryForObject(sql, rm);
			}else {
				Object resList = (Object)DBCache.getInstance().get(sql);
				
					
				if (null == resList){
					resList = jdbcTemplate.queryForObject(sql, rm);
					if (cacheTime == 0)
						DBCache.getInstance().set(sql, resList);
					else
						DBCache.getInstance().set(sql, resList, cacheTime);
				}
				return resList;
			}
		}catch(Exception e){
			
		}
		return null;
	}
	
	
	public static String convertColName(String colName){
		StringBuffer strBuf = new StringBuffer();
//		colName="aaa_bb_cc_" >> AaaBbCc
		char chArray[] = colName.toCharArray();
		boolean isUpper = true;
		for(char ch : chArray){

			
			if (ch=='_'){
				if (isUpper==false){
					isUpper = true;
					continue;
				}
			}
			if (isUpper && ch>='a' && ch<='z'){
				ch = (char)(ch - 0x20);
			}
			strBuf.append(ch);
			isUpper = false;
		}
		return strBuf.toString();
	}
	
	
	public static Map<String, Object> convertMap(Map<String, Object> mapRec){
		Map<String, Object> mapRecNew = new HashMap<String, Object>();
		for(String key:mapRec.keySet()){
			mapRecNew.put(convertColName(key), mapRec.get(key));
		}
		return mapRecNew;
	}
	
	public Object queryForEntity(String sql, Class<?> T, int cacheTime) throws Exception {

		Map<String, Object> mapRS=null;
		Object t = T.newInstance();
		try {
			if (cacheTime<0){
					mapRS=jdbcTemplate.queryForMap(sql);
					BeanUtils.copyProperties(t, mapRS);
			}else {
				mapRS = ( Map<String, Object>)DBCache.getInstance().get(sql);
				if (null == mapRS){
					mapRS=jdbcTemplate.queryForMap(sql);
					if (cacheTime == 0)
						DBCache.getInstance().set(sql, mapRS);
					else
						DBCache.getInstance().set(sql, mapRS, cacheTime);
				}
				BeanUtils.copyProperties(t, mapRS);
			}
		} catch (Exception e) {
			mapRS=null;
		}
		return t;
	}
	
	public Map<String, Object> queryForMap(String sql, int cacheTime) {
		try{
			if (cacheTime<0){
				return jdbcTemplate.queryForMap(sql);
			}else {
				Map<String, Object> resList = ( Map<String, Object>)DBCache.getInstance().get(sql);
					
				if (null == resList){
					resList = jdbcTemplate.queryForMap(sql);
					if (cacheTime == 0)
						DBCache.getInstance().set(sql, resList);
					else
						DBCache.getInstance().set(sql, resList, cacheTime);
				}
				return resList;
			}
		}catch(Exception e){
			
		}
		return null;
		
	}
	
	
	public Integer queryForCount(String sql, int cacheTime){
		if (cacheTime<0){
			return jdbcTemplate.queryForInt(sql);
		}else {
			Integer resList = (Integer)DBCache.getInstance().get(sql);
			
				
			if (null == resList){
				resList = jdbcTemplate.queryForInt(sql);
				if (cacheTime == 0)
					DBCache.getInstance().set(sql, resList);
				else
					DBCache.getInstance().set(sql, resList, cacheTime);
			}
			return resList;
		}
	}
	
	public List queryForListEntity(String sql, Class<?> T, int cacheTime) throws Exception {
		
		List lstRet = new ArrayList();
		
		List<Map<String, Object>> lstRS=jdbcTemplate.queryForList(sql);
		
		for(Map<String, Object> mapRec: lstRS){
			Object t = T.newInstance();
			BeanUtils.copyProperties(t, mapRec);
			lstRet.add(t);
		}
		
		return lstRet;
	}
	public List<Map<String, Object>> queryForList(String sql, int cacheTime) {
		if (cacheTime<0){
			return jdbcTemplate.queryForList(sql);
		}else {
			List<Map<String, Object>> resList = (List<Map<String, Object>>)DBCache.getInstance().get(sql);
			
				
			if (null == resList){
				resList = jdbcTemplate.queryForList(sql);
				if (cacheTime == 0)
					DBCache.getInstance().set(sql, resList);
				else
					DBCache.getInstance().set(sql, resList, cacheTime);
			}
			return resList;
		}
	}
	
	
	public List<Map<String, Object>> PagingQueryForList(String sql, int pageNum, int pageSize, int cacheTime) {
		
		StringBuffer strSql=new StringBuffer(sql);
		//开始条数
		int start = (pageNum-1)*pageSize;
		//结束条数
		int end = pageSize;
	
		strSql.append(" LIMIT "+start+","+end);
		
	
		if (cacheTime<0){
			return jdbcTemplate.queryForList(strSql.toString());
		}else {
			List<Map<String, Object>> resList = (List<Map<String, Object>>)DBCache.getInstance().get(strSql.toString());
			
				
			if (null == resList){
				resList = jdbcTemplate.queryForList(strSql.toString());
				if (cacheTime == 0)
					DBCache.getInstance().set(sql, resList);
				else
					DBCache.getInstance().set(sql, resList, cacheTime);
			}
			return resList;
		}		
		
	}

	
	/***
	 * 
	 * @param tableName
	 * @param param
	 */
	public int saveNoExist(String tableName, String strWhere, Object...param){
		
		String sql = "select count(*) from "+tableName+" WHERE "+strWhere;
		int cnt = queryForCount(sql, -1);
		if (cnt>0){
			return update(tableName, strWhere, param);
		}
		return insert(tableName, param);
	}	
	
	
	/***
	 * 
	 * @param tableName
	 * @param param
	 */
	public int saveUniqueKeys(String tableName, Object...param){
		int idNum = -1;
		String id = null;
		
		List<Object>lstColName = new ArrayList<Object>();
		
		for(int i=0; i<param.length; i+=2){
			if("id".equals(param[i])){
				id = (String)param[i+1];
				idNum = i+1;
			}
			lstColName.add(param[i]);
			lstColName.add(param[i+1]);
		}
		
		if (id == null){
			id = ZLUtils.UUIDgenerate();
			if (idNum==-1){
				lstColName.add("id");
				lstColName.add(id);
			}else{
				lstColName.set(idNum, id);
			}
		}
		
		return insert(tableName, lstColName.toArray());
	}	
	
	
	/***
	 * 
	 * @param tableName
	 * @param param
	 */
	public int saveOrUpdateByWhere(String tableName, Object...param){
		String strWhere = null;
		for(int i=0; i<param.length; i+=2){
			if("WHERE".equals(param[i])){
				strWhere = (String)param[i+1];
				break;
			}
		}
		
		if (strWhere != null)
			return update(tableName, strWhere, param);
		else
			return insert(tableName, param);
	}	
	
	
	/***
	 * 
	 * @param tableName
	 * @param param
	 */
	public int saveOrUpdate(String tableName, Object...param){
		String id = null;
		
		List<Object>lstColName = new ArrayList<Object>();
		
		for(int i=0; i<param.length; i+=2){
			if("id".equals(param[i])){
				id = (String)param[i+1];
				String strWHERE = "id='"+id+"'";
				int ret = update(tableName, strWHERE, param);
				if (ret > 0)
					return ret;
			}
			lstColName.add(param[i]);
			lstColName.add(param[i+1]);
		}
		
		if (id == null){
			id = ZLUtils.UUIDgenerate();

			lstColName.add("id");
			lstColName.add(id);
		}
		
		return insert(tableName, lstColName.toArray());
	}	

	
	public int update(String tableName, String strWHERE, Object...param) {
		
		StringBuffer strSQLBuf =new StringBuffer("UPDATE ");
		strSQLBuf.append(tableName);
		strSQLBuf.append(" SET ");
		boolean isFirst = true;
		for(int i=0; i<param.length; i+=2){
			if("id".equals(param[i]) || "WHERE".equals(param[i]))
				continue;
			
//			if(param[i+1] == null)
//				continue;
				
			if (!isFirst){
				strSQLBuf.append(",");
			}else
				isFirst = false;

			strSQLBuf.append(param[i]);			
			
			if(param[i+1] == null){
				strSQLBuf.append("=null");
			}else{
				strSQLBuf.append("=\'");
				
				if(param[i+1] instanceof java.lang.String){
					String v = (String)param[i+1];
					v = MYSQLEncoder.encode(v);
					strSQLBuf.append(v);
				}else
					strSQLBuf.append(param[i+1]);
				
				strSQLBuf.append('\'');
			}

		}
		
		if (null != strWHERE && strWHERE.length()>0){
			strSQLBuf.append(" WHERE ");
			strSQLBuf.append(strWHERE);
		}
		return jdbcTemplate.update(strSQLBuf.toString());		
	}	
	
	
	public int insert(String tableName, Object...param) {
		
		StringBuffer strSQLBuf =new StringBuffer("REPLACE INTO ");

		StringBuffer sbValues = new StringBuffer(") VALUES (");
		

		
		strSQLBuf.append(tableName);
		strSQLBuf.append('(');
		boolean isFirst = true;
		for(int i=0; i<param.length; i+=2){
			if(param[i+1] == null)
				continue;
				
			if (!isFirst){
				strSQLBuf.append(",");
				sbValues.append(",");
			}else
				isFirst = false;


			
	        strSQLBuf.append(param[i]);			
			
			sbValues.append('\'');
			
//			modify by czl 2016
//			sbValues.append(param[i+1]);

			
			if(param[i+1] instanceof java.lang.String){
				String v = (String)param[i+1];
				v = MYSQLEncoder.encode(v);
				sbValues.append(v);
			}else
				sbValues.append(param[i+1]);
			
			
			sbValues.append('\'');

		}
		
		
		
		strSQLBuf.append(sbValues.toString());
		strSQLBuf.append(')');
		return jdbcTemplate.update(strSQLBuf.toString());		
	}	

	
	public int insert(String tableName, Map<String, Object> param) {
		
		StringBuffer sb=new StringBuffer();
		
		sb.append("REPLACE INTO "+tableName+" (");
		for(Object obj:param.keySet()){
			
			String key=(String) obj;
			
			sb.append(key+",");
		}
		StringBuffer tbOut=new StringBuffer();
		
		tbOut.append(sb.substring(0, sb.length()-1).toString());
		tbOut.append(") VALUES (");
		
		sb.delete(0,sb.length()); 
		for(Object obj:param.keySet()){
			
			String key=(String) obj;
			Object value = param.get(key);
			
			if(value instanceof java.lang.Integer){
				sb.append(value);
			}else if(value instanceof java.lang.Double){
				sb.append(value);
			}else if(value instanceof java.lang.Float){
				sb.append(value);
			}else{//if(value instanceof java.lang.String){
				
			
				sb.append('\'');

				if(value instanceof java.lang.String){
					String v = (String)value;
					v = MYSQLEncoder.encode(v);
					sb.append(v);
				}else
					sb.append(value);
				
				
				sb.append('\'');
			}
			sb.append(",");
		}
		tbOut.append(sb.substring(0, sb.length()-1).toString());
		tbOut.append(")");
		return jdbcTemplate.update(tbOut.toString());
	}
	
	/***
	 * 
	 * @Description: 通用调用存储过程
	 *	
	 * @Method: callProc	
	 * @param procName		存储过程的名称
	 * @param lstPara		存储过程的参数
	 * @param numPara		存储过程返回值的个数
	 * @return
	 */
	public List<Object> callProc(String procName,List<Object> lstPara, int numPara){
		
		List<Object> lstRet = new ArrayList<Object>();
		
		Connection conn = null;
		CallableStatement cs = null;
		try {
			
			StringBuffer strSQL = new StringBuffer("{CALL ");
			strSQL.append(procName);
			strSQL.append('(');
			
			for(int i=0;i<lstPara.size();i++){
				strSQL.append('?');
				if (i<lstPara.size()-1){
					strSQL.append(',');
				}
			}
			strSQL.append(")}");
			
			conn = jdbcTemplate.getDataSource().getConnection();
			cs = conn.prepareCall(strSQL.toString());  

			for(int i=0;i<lstPara.size();i++){
				Object o = lstPara.get(i);
				Boolean isOut = numPara>=(lstPara.size()-i);

				if(o instanceof java.lang.Integer){
					if (isOut)
						cs.registerOutParameter(i+1, Types.INTEGER);
					else
						cs.setInt(i+1, ((Integer)o).intValue());
				}else if(o instanceof java.lang.Double){
					if (isOut)
						cs.registerOutParameter(i+1, Types.DOUBLE);
					else
						cs.setDouble(i+1, ((Double)o).doubleValue());
				}else if(o instanceof java.lang.Float){
					if (isOut)
						cs.registerOutParameter(i+1, Types.FLOAT);
					else
						cs.setFloat(i+1, ((Float)o).floatValue());
				}else{//(o instanceof java.lang.String){
					if (isOut)
						cs.registerOutParameter(i+1, Types.VARCHAR);
					else
						cs.setString(i+1, (String)o);
					
				}
			}
			
			cs.execute();//执行这个存储过程  
			
			if (numPara<0){
				ResultSet rs=cs.getResultSet();
				ResultSetMetaData md = null;  
				
				if (rs != null)
					md = rs.getMetaData();  
				if(md != null){
					try{
						int columnCount = md.getColumnCount(); //Map rowData;
		                while(rs.next()){
		                	Map<String,Object> temp=new HashMap<String, Object>();
		                	for (int i = 1; i <= columnCount; i++) {  
		                		temp.put(md.getColumnName(i), rs.getObject(i));
		                	}
		                    lstRet.add(temp);
		                }
					}finally{
						if (rs != null){
							try { rs.close(); }catch(Exception e){ e.printStackTrace(); }
						}
					}
                	
	                
	            }
			}else{
				
				for(int i=lstPara.size()-numPara;i<lstPara.size();i++){
					
					Object outParaName = lstPara.get(i);
					if (null != outParaName){
						if(outParaName instanceof java.lang.String){
							lstRet.add(cs.getString(i+1));
						}else if(outParaName instanceof java.lang.Integer){
							lstRet.add(cs.getInt(i+1));
						}else if(outParaName instanceof java.lang.Double){
							lstRet.add(cs.getDouble(i+1));
						}else if(outParaName instanceof java.lang.Float){
							lstRet.add(cs.getFloat(i+1));
						}
					}
				}
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try { if (null != cs) cs.close(); } catch (Exception e) { e.printStackTrace();	}				
			try { if (null != conn) conn.close(); } catch (Exception e) { e.printStackTrace(); }
		}
		
		return lstRet;
	}
	
}
