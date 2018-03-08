package com.apft.utils;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

 
/**
 * @author lu.li
 *
 */
public class ZLConfigure {
	
	public  Map<String,Object> urlMap = new HashMap<String,Object>();
	
	
	private static Object lock              = new Object();
	private static ZLConfigure hInstance     = null;
	private static ResourceBundle rb        = null;
	private static final String CONFIG_FILE = "zl_configure";
	
	static final long MAX_LOAD_FILE_TIME = 5*60*1000;//5 minutes
	
	
	private long _lastLoadConfigure = 0;
	
	
	private ZLConfigure() {
		loadConfigureFile();
	}
	
	
	
	private void loadConfigureFile(){
		long lNow = System.currentTimeMillis();
		
		
		if (lNow - _lastLoadConfigure > MAX_LOAD_FILE_TIME){
			try{
				rb = ResourceBundle.getBundle(CONFIG_FILE, Locale.getDefault());
				//rb = ResourceBundle.getBundle("/WEB-INF/"+CONFIG_FILE);
				_lastLoadConfigure = lNow;
				
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		
		try {
			Properties properties = new Properties();
			InputStream is = this.getClass().getResourceAsStream("/url_configure.properties");
			properties.load(is);
			Enumeration propertyNames = properties.propertyNames();
			while (propertyNames.hasMoreElements()) {
				String key = (String) propertyNames.nextElement();
				String value = properties.getProperty(key);
				urlMap.put(key, value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static ZLConfigure getInstance() {
		synchronized(lock) {
			if(null == hInstance) {
				hInstance = new ZLConfigure();
			}
		}
		return (hInstance);
	}
	
	
	
	
	
	
	
	public String getValue(String key) {
		try{
			return rb.getString(key);
		}catch(Exception e){}
		return "";
	}
	
	
	public String getProjectName(){
		String ret = getValue("project_name");
		if (null == ret)
			return "";
		return ret;
	}
	

	/*
	 * strOS= "android | ios | winphone | symbian ..."
	 * */
	public int getAppVer(String strOS){
		loadConfigureFile();
		
		String ret = getValue(strOS+"_ver");
		try{
			return Integer.parseInt(ret);
		}catch(Exception e){}
		return 0;
	}
	
	public static void main(String argv[]){
//		ResourceBundle bundle=PropertyResourceBundle.getBundle(CONFIG_FILE);
	
	}
	//ResourceBundle bundle=PropertyResourceBundle.getBundle("config");
}

