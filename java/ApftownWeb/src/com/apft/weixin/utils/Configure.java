package com.apft.weixin.utils;

import java.util.Locale;
import java.util.ResourceBundle;

 
/**
 * @author lu.li
 *
 */
public class Configure {
	private static Object lock = new Object();
	private static Configure config  = null;
	private static ResourceBundle rb  = null;
	private static final String CONFIG_FILE = "wxconfig";
	
	private Configure() {
		rb = ResourceBundle.getBundle(CONFIG_FILE, Locale.getDefault());
	}
	
	public static Configure getInstance() {
		synchronized(lock) {
			if(null == config) {
				config = new Configure();
			}
		}
		return (config);
	}
	
	public String getValue(String key) {
		return (rb.getString(key));
	}
	
	public static void main(String argv[]){

	
	}
	//ResourceBundle bundle=PropertyResourceBundle.getBundle("config");
}
