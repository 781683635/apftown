package com.apft.utils;

import org.apache.log4j.Logger;

public class LogUtils {
	private static Logger _log= Logger.getLogger("mylogger2");
//	private static Log logger2 = LogFactory.getLog("mylogger2");
	
	public static void logInfo(String str){
		_log.info(str);
	}
	
	public static void logError(String str){
		_log.error(str);
	}
	
	public static void logWarn(String str){
		_log.warn(str);
	}
	
	public static void logFatal(String str){
		_log.fatal(str);
	}

	public static void logDebug(String str){
		_log.debug(str);
	}	
}
