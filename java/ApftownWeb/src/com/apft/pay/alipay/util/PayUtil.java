package com.apft.pay.alipay.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;







public class PayUtil {
	
		// 商户PID
		public static final String PARTNER = "2088611135866221";
		// 商户收款账号
		public static final String SELLER = "qlfg@qlfg.com";
		// 商户私钥，pkcs8格式
		public static final String RSA_PRIVATE = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAKCt6Yu9OuH9I6Kl\n" +
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

				
				
				
				//"MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAKCt6Yu9OuH9I6KllZbOXyb+XeUN+CH6nQu3Ha1iiEq61ta9usA1U4LTQLqvu+kBHQMuOv1amNth0mTiaAFbDWFrd7cz7XRrro9neqSl0puLzUqwcVvMv8HNxcglydqYZWJhDtAIWrwMZubOVVR0hVV84M9+fQuYFmtLBTnTX/CdAgMBAAECgYA253ZYU47dTdxxZVdaMqZ88oovDLjvE226ZRX0+yhLMNDci/RWXWJt37XMlOQG2GSLg66Qh/aXcDOuWVbkr7JAPxSEuy7YSX3obEzAcgt/5HF1ZqllraUxUIj5vGMHTLSQa7iMV/hEU5B0u5rDIzoZHh0xCK5QHESUEobV/ziiGQJBAM16rqNtPFXkte7a4C29L8FceBWPo1LTaoNW1jGApGZWjESFi9Hr1X1wDrPtVYJzvXtO4OGG1OVh1B3t7+7Clg8CQQDIL20e2jcHkLcVHBbhzdY+KLyQPb3Knt6HtCBUB1LHFRCvFCMfoa0ySlw6seeCx3G7CIiZQ/CR3awDyh5/ddqTAkADc7UtX69szfvUeG7dtdjwiaomypP210Bp1nKgwEWCxp9yoz+3FhwvEEve7/TIzUL4qFmU0FwRQnR60D2AqFo3AkBSfBg+ajPajiqiLBzRlfr9SdPIq2gUoTmYOQRJG2tkVK23Nljyo6+11SYDmWKHZJ7cLjv6yx/JOsmyFgpTAsC5AkBzCqMmrRhZhyDI0DQOms3PO65NmAaE2KW7rfFO3g9rYYPjfHHHjoUjxAqF3rkgAb6TnX/Q3p/2JKDaIg55vxNw";
		// 支付宝公钥
		public static final String RSA_PUBLIC = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCgremLvTrh/SOipZWWzl8m/l3lDfgh+p0Ltx2tYohKutbWvbrANVOC00C6r7vpAR0DLjr9WpjbYdJk4mgBWw1ha3e3M+10a66PZ3qkpdKbi81KsHFbzL/BzcXIJcnamGViYQ7QCFq8DGbmzlVUdIVVfODPfn0LmBZrSwU501/wnQIDAQAB";
		private static final int SDK_PAY_FLAG = 1;
		
		
	/**
	 * 返回客户端签名后的订单信息
	 * 
	 */		
	public String pay(String  productName,String productInfo,String price, String strSerialNo) {
		String orderInfo = getOrderInfo(productName, productInfo, price, strSerialNo);

		/**
		 * 特别注意，这里的签名逻辑需要放在服务端，切勿将私钥泄露在代码中！
		 */
		String sign = sign(orderInfo);
		try {
			/**
			 * 仅需对sign 做URL编码
			 */
			sign = URLEncoder.encode(sign, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		/**
		 * 完整的符合支付宝参数规范的订单信息
		 */
		final String payInfo = orderInfo + "&sign=\"" + sign + "\"&" + getSignType();

	/*	Runnable payRunnable = new Runnable() {

			@Override
			public void run() {
				
				// 调用支付接口，获取支付结果
				String result = alipay.pay(payInfo, true);

				Message msg = new Message();
				msg.what = SDK_PAY_FLAG;
				msg.obj = result;
				mHandler.sendMessage(msg);
			}
		};

		// 必须异步调用
		Thread payThread = new Thread(payRunnable);
		payThread.start();*/
		return payInfo;
		
	}
	
	
	/**
	 * create the order info. 创建订单信息
	 * 
	 */
	private String getOrderInfo(String subject, String body, String price, String strSerialNo) {
		
		String url = "www.apftown.com";

		

		// 签约合作者身份ID
		String orderInfo = "partner=" + "\"" + PARTNER + "\"";

		// 签约卖家支付宝账号
		orderInfo += "&seller_id=" + "\"" + SELLER + "\"";

		// 商户网站唯一订单号
		orderInfo += "&out_trade_no=" + "\"" + strSerialNo + "\"";

		// 商品名称
		orderInfo += "&subject=" + "\"" + subject + "\"";

		// 商品详情
		orderInfo += "&body=" + "\"" + body + "\"";

		// 商品金额
		orderInfo += "&total_fee=" + "\"" + price + "\"";

		// 服务器异步通知页面路径http://notify.msp.hk/notify.htm  http://bg.miningcircle.com:8080/MiningCircle/appproxy.do?dataValidation
		orderInfo += "&notify_url=" + "\"" + "http://"+url+"/mpay/alipaynotify.do" + "\"";

		// 服务接口名称， 固定值
		orderInfo += "&service=\"mobile.securitypay.pay\"";

		// 支付类型， 固定值
		orderInfo += "&payment_type=\"1\"";

		// 参数编码， 固定值
		orderInfo += "&_input_charset=\"utf-8\"";

		// 设置未付款交易的超时时间
		// 默认30分钟，一旦超时，该笔交易就会自动被关闭。
		// 取值范围：1m～15d。
		// m-分钟，h-小时，d-天，1c-当天（无论交易何时创建，都在0点关闭）。
		// 该参数数值不接受小数点，如1.5h，可转换为90m。
		orderInfo += "&it_b_pay=\"30m\"";

		// extern_token为经过快登授权获取到的alipay_open_id,带上此参数用户将使用授权的账户进行支付
		// orderInfo += "&extern_token=" + "\"" + extern_token + "\"";

		// 支付宝处理完请求后，当前页面跳转到商户指定页面的路径，可空
		orderInfo += "&return_url=\"http://"+url+"/mpay/alipayreturn.do\"";

		// 调用银行卡支付，需配置此参数，参与签名， 固定值 （需要签约《无线银行卡快捷支付》才能使用）
		// orderInfo += "&paymethod=\"expressGateway\"";

		return orderInfo;
	}
	
	
	/**
	 * get the out_trade_no for an order. 生成商户订单号，该值在商户端应保持唯一（可自定义格式规范）
	 * 
	 */
	private String getOutTradeNo() {
		SimpleDateFormat format = new SimpleDateFormat("MMddHHmmss", Locale.getDefault());
		Date date = new Date();
		String key = format.format(date);

		Random r = new Random();
		key = key + r.nextInt();
		key = key.substring(0, 15);
		return key;
	}
	/**
	 * sign the order info. 对订单信息进行签名
	 * 
	 * @param content
	 *            待签名订单信息
	 */
	private String sign(String content) {
		return SignUtils.sign(content, RSA_PRIVATE);
	}

	/**
	 * get the sign type we use. 获取签名方式
	 * 
	 */
	private String getSignType() {
		return "sign_type=\"RSA\"";
	}

	
	

}
