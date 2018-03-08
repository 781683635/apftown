package com.apft.pay.alipay.config;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：1.0
 *日期：2016-06-06
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	//合作身份者ID，签约账号，以2088开头由16位纯数字组成的字符串，查看地址：https://openhome.alipay.com/platform/keyManage.htm?keyType=partner
	public static String partner = "2088611135866221";

	//商户的私钥,需要PKCS8格式，RSA公私钥生成：https://doc.open.alipay.com/doc2/detail.htm?spm=a219a.7629140.0.0.nBDxfy&treeId=58&articleId=103242&docType=1
	public static String private_key = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAKCt6Yu9OuH9I6Kl\n" +
			"lZbOXyb+XeUN+CH6nQu3Ha1iiEq61ta9usA1U4LTQLqvu+kBHQMuOv1amNth0mTi\n" +
			"aAFbDWFrd7cz7XRrro9neqSl0puLzUqwcVvMv8HNxcglydqYZWJhDtAIWrwMZubO\n" +
			"VVR0hVV84M9+fQuYFmtLBTnTX/CdAgMBAAECgYA253ZYU47dTdxxZVdaMqZ88oov\n" +
			"DLjvE226ZRX0+yhLMNDci/RWXWJt37XMlOQG2GSLg66Qh/aXcDOuWVbkr7JAPxSE\n" +
			"uy7YSX3obEzAcgt/5HF1ZqllraUxUIj5vGMHTLSQa7iMV/hEU5B0u5rDIzoZHh0x\n" +
			"CK5QHESUEobV/ziiGQJBAM16rqNtPFXkte7a4C29L8FceBWPo1LTaoNW1jGApGZW\n" +
			"jESFi9Hr1X1wDrPtVYJzvXtO4OGG1OVh1B3t7+7Clg8CQQDIL20e2jcHkLcVHBbh\n" +
			"zdY+KLyQPb3Knt6HtCBUB1LHFRCvFCMfoa0ySlw6seeCx3G7CIiZQ/CR3awDyh5/\n" +
			"ddqTAkADc7UtX69szfvUeG7dtdjwiaomypP210Bp1nKgwEWCxp9yoz+3FhwvEEve\n" +
			"7/TIzUL4qFmU0FwRQnR60D2AqFo3AkBSfBg+ajPajiqiLBzRlfr9SdPIq2gUoTmY\n" +
			"OQRJG2tkVK23Nljyo6+11SYDmWKHZJ7cLjv6yx/JOsmyFgpTAsC5AkBzCqMmrRhZ\n" +
			"hyDI0DQOms3PO65NmAaE2KW7rfFO3g9rYYPjfHHHjoUjxAqF3rkgAb6TnX/Q3p/2\n" +
			"JKDaIg55vxNw";

	
	//支付宝的公钥，查看地址：https://openhome.alipay.com/platform/keyManage.htm?keyType=partner
	public static String alipay_public_key  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";
	
	// 签名方式
	public static String sign_type = "RSA";
	
	// 调试用，创建TXT日志文件夹路径，见AlipayCore.java类中的logResult(String sWord)打印方法。
	public static String log_path ="C://";
		
	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";

	// 接收通知的接口名
	public static String service = "mobile.securitypay.pay";

//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
}

