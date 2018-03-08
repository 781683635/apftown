package com.apft.utils.sms;

public class AFinanceUtils {
	
	public static String formatSMSCheckCode(String strCode){
		return "【亚太金融基金小镇】\n您的手机验证码是:"+strCode+",欢迎使用三亚亚太（基金）小镇 http://www.apftown.com 。TEL:400-088-1124。";
		
	}
	
	
	public static String formatSMSMsg(String strMsg){
		return formatSMSMsg(strMsg, 0);
	}

	public static String formatSMSMsg(String strMsg, int type){
		if (type==1)
			return "【亚太金融基金小镇】\n"+strMsg;
		else
			return "【亚太金融基金小镇】\n"+strMsg+"\nTEL:400-088-1124";
	}
}
