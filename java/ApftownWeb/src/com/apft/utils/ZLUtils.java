package com.apft.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;

import com.apft.mvc.dao.DBManager;


public class ZLUtils {

	
	private static Object lock              = new Object();
	private static ZLUtils hInstance     = null;

	public static ZLUtils getInstance() {
		synchronized(lock) {
			if(null == hInstance) {
				hInstance = new ZLUtils();
			}
		}
		return (hInstance);
	}	

	
	static private String _WebRootBasePath;
	static public String getWebRootBasePath(){
		if (_WebRootBasePath == null){
			URL u = ZLUtils.class.getResource("/");
			String strBaseRootPath = u.getFile();//    /E:/work/webs/mcweb/WebRoot/WEB-INF/classes/
			int idx = strBaseRootPath.indexOf("classes/");
			if (idx > 0){
				strBaseRootPath = strBaseRootPath.substring(0, idx);
			}
			
			_WebRootBasePath = strBaseRootPath;
		}
		return _WebRootBasePath;
		
	}	
	
	
	/***
	 * 
	 * @param strUID
	 * @param strMsg
	 * @param MsgMask bit0站内消息(0x1:00001)，bit1短信(0x2:0010)，bit2邮件(0x3:0011)，bit3电话通知(0x4:0100)，bit4微信通知(0x5:0101)
	 */
	public void notifyUserMsg(String strUID, String strTitle, String strMsg, int MsgMask, Object...param){
		
		StringBuffer sql = new StringBuffer("INSERT INTO tb_user_msg (id, cat, user_id, msg_title, msg_content) ");
		sql.append("VALUES (f_zluuid(),"+MsgMask+", '"+strUID+"', '"+strTitle+"', '"+strMsg+"')");
		DBManager.getInstance().getSQLDao().update(sql.toString());
		/*if ( (MsgMask&1)== 1){//0x1 站内信
		
		}
		
		if ( (MsgMask&2)== 2){//0x2短信
			
		}		

		if ( (MsgMask&4)== 2){//0x4邮件
			
		}	*/
		
		
		
	}

	
	public static String getPaySerialNo(String strName){
		String ddate = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
	    long random = Math.round(Math.random() * 1000000) ; //生成随机数 
		return strName + "-" + ddate + "-" + random;
	}
	//生成协议编码
	public static String getProtocolNo(String strName){
		String ddate = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
	    long random = Math.round(Math.random() * 1000000) ; //生成随机数 
		return  strName+ddate + "-" + random;
	}
	
	
	
	/**
	 * 产生一个32位的UUID
	 * 
	 * @return
	 */
	public static String UUIDgenerate() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	
	
	/**
	 * 
	 * @Description: 微信头像
	 *
	 * @Method: httpDownFile
	 * @param strURL
	 * @param strFileName
	 * @return
	 * @throws IOException
	 */
	public static boolean httpDownFile(String strURL, String strFileName)throws IOException{
		boolean ret = false;
		HttpClient client = new HttpClient();
		HttpMethod method = new GetMethod(strURL); // &jsName=skif
		client.executeMethod(method);
		if (method.getStatusCode() == 200) {
			byte [] strResult = method.getResponseBody();
//			File fl = new File(strFileName);
			FileOutputStream fos = new FileOutputStream(strFileName);
			fos.write(strResult, 0, strResult.length);
			fos.close();
			ret = true;
		}
		method.releaseConnection();
		return ret;	
	}
	
	/***
	 * 
	 * @Description: 获取 IP 地址
	 *
	 * @Method: getIpAddr
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}
