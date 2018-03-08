package com.apft.weixin.common;

import com.apft.weixin.utils.Configure;



public class WXCommon {
	
    public static String trade_type = "NATIVE";//原生支付方式及扫码支付
    public static String APPID = Configure.getInstance().getValue("appid");//公众账号ID
    public static String APPSECRET=  Configure.getInstance().getValue("appsecret");//
 /*   public static String MCHID= Configure.getInstance().getValue("partner"); //微信支付分配的商户号
    public static String KEY= Configure.getInstance().getValue("partnerkey");
    //微信电脑PC端扫描支付回调通知地址  接收微信支付异步通知回调地址，通知url必须为直接可访问的url，不能携带参数。
    public static String notify_url= Configure.getInstance().getValue("notify_url");*/
    
    
    
    
}
