package com.apft.weixin.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apft.core.AjaxJson;
import com.apft.weixin.common.WXCommon;
import com.apft.weixin.utils.PastUtil;

@Controller
@RequestMapping("/weChatPay/")
public class WeChatController {
/*	@Autowired
	private IDao dao;

	public static final String WX_PAY_FAIL_URL = "wxPayFailCallURL";
	public static final String WX_PAY_OK_URL = "wxPayOKCallURL";

	static Random g_random = new Random();

	static String getParameter(HttpServletRequest request, String key,
			String defaultValue) {
		String strTmp = request.getParameter(key);
		if (strTmp != null) {
			return strTmp;
		}
		return defaultValue;
	}

	static int getParameter(HttpServletRequest request, String key,
			int defaultValue) {
		String strTmp = request.getParameter(key);
		if (strTmp != null) {
			defaultValue = Integer.parseInt(strTmp);
		}
		return defaultValue;
	}

	*//**
	 * 获取当前时间
	 * *//*
	public static String getNowString() {
		Date d = new Date(System.currentTimeMillis());// new Date(time);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd-HHmmss");
		return formatter.format(d);
	}

	*//**
	 * 从request中获得参数Map，并返回可读的Map
	 *//*
	@SuppressWarnings("unchecked")
	public Map getParameterMap(HttpServletRequest request) {
		// 参数Map
		Map properties = request.getParameterMap();
		// 返回值Map
		Map returnMap = new HashMap();
		Iterator entries = properties.entrySet().iterator();
		Map.Entry entry;
		String name = "";
		String value = "";
		while (entries.hasNext()) {
			entry = (Map.Entry) entries.next();
			name = (String) entry.getKey();
			Object valueObj = entry.getValue();
			if (null == valueObj) {
				value = "";
			} else if (valueObj instanceof String[]) {
				String[] values = (String[]) valueObj;
				for (int i = 0; i < values.length; i++) {
					value = values[i] + ",";
				}
				value = value.substring(0, value.length() - 1);
			} else {
				value = valueObj.toString();
			}
			returnMap.put(name, value);
		}
		return returnMap;
	}

	// ************************************start*********************************************

	*//**
	 * 微信电脑PC端扫描支付 统一下单接口 微信二维码支付
	 * 
	 * @param params
	 * @return
	 *//*
	public String wxPay(HttpServletRequest request, Map<String, Object> params) {
		try {
			// String basePath =
			// request.getScheme()+"://"+request.getServerName()+request.getContextPath();
			String currTime = PayCommonUtil.getCurrTime();
			String strTime = currTime.substring(8, currTime.length());
			String strRandom = PayCommonUtil.buildRandom(4) + "";
			// 生成随机字符串
			String nonce_str = strTime + strRandom;
			SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
			packageParams.put("appid", WXCommon.APPID);
			packageParams.put("mch_id", WXCommon.MCHID);
			packageParams.put("nonce_str", nonce_str);
			packageParams.put("body", "" + params.get("body"));
			packageParams.put("out_trade_no", "" + params.get("out_trade_no"));
			packageParams.put("total_fee",
					Integer.parseInt("" + params.get("price")));
			packageParams.put("spbill_create_ip", request.getRemoteAddr());
			packageParams.put("notify_url", WXCommon.notify_url);
			packageParams.put("trade_type", WXCommon.trade_type);
			packageParams.put("product_id", "" + params.get("product_id"));
			String sign = PayCommonUtil.createSign("UTF-8", packageParams,
					WXCommon.KEY);
			packageParams.put("sign", sign);// 加密
			String requestXML = PayCommonUtil.getRequestXml(packageParams);
			long startTime = System.currentTimeMillis();
			String resXml = HttpClientUtil.sendPost(
					"https://api.mch.weixin.qq.com/pay/unifiedorder",
					requestXML);
			long endTime = System.currentTimeMillis();
			Integer execute_time = (int) ((endTime - startTime) / 1000);
			Map map = XMLUtil.doXMLParse(resXml);
			// 微信二维码短链接
			String urlCode = "";
			if (map.get("return_code").toString().equals("SUCCESS")
					&& map.get("result_code").toString().equals("SUCCESS")) {
				urlCode = (String) map.get("code_url");
			} else {
				System.out.println("微信下单失败！》》》WeChatController---");
			}
			// 微信返回的支付地址
			return urlCode;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	*//**
	 * 微信电脑PC端扫描支付回调
	 * *//*
	@RequestMapping(value = "weChatPayByPCUrlBack")
	public ModelAndView weChatPayByPCUrlBack(HttpServletRequest request,
			HttpServletResponse reponse) {
		// 读取参数
		try {
			InputStream inputStream;
			StringBuffer sb = new StringBuffer();
			inputStream = request.getInputStream();
			String s;
			BufferedReader in = new BufferedReader(new InputStreamReader(
					inputStream, "UTF-8"));
			while ((s = in.readLine()) != null) {
				sb.append(s);
			}
			in.close();
			inputStream.close();

			// 解析xml成map
			Map<String, String> m = new HashMap<String, String>();
			m = XMLUtil.doXMLParse(sb.toString());

			// 过滤空 设置 TreeMap
			SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
			Iterator it = m.keySet().iterator();
			while (it.hasNext()) {
				String parameter = (String) it.next();
				String parameterValue = m.get(parameter);
				String v = "";
				if (null != parameterValue) {
					v = parameterValue.trim();
				}
				packageParams.put(parameter, v);
			}
			// 账号信息
			String key = WXCommon.KEY; // key
			// 判断签名是否正确
			if (PayCommonUtil.isTenpaySign("UTF-8", packageParams, key)) {
				// ------------------------------
				// 处理业务开始
				// ------------------------------
				String resXml = "";
				if ("SUCCESS".equals((String) packageParams.get("result_code"))) {
					// 这里是支付成功
					String out_trade_no = (String) packageParams
							.get("out_trade_no");
					String total_fee = (String) packageParams.get("total_fee");
					// out_trade_no =
					// out_trade_no.substring(0,out_trade_no.length()-3);
					List<Object> lstPara = new ArrayList<Object>();
					lstPara.add(out_trade_no);
					lstPara.add(Double.parseDouble(total_fee) / 100);
					lstPara.add("ok");
					lstPara.add(1);
					lstPara.add("ret");
					List<Object> lstRet = dao.callProc("pc_payment_response",
							lstPara, 1);
					// 通知微信.异步确认成功.必写.不然会一直通知后台.八次之后就认为交易失败了.
					resXml = "SUCCESS";

				} else {
					System.out.println("支付失败,错误信息："
							+ packageParams.get("err_code"));
					resXml = "err";
				}
				// ------------------------------
				// 处理业务完毕 给微信发送 停止回调
				// ------------------------------
				BufferedOutputStream out = new BufferedOutputStream(
						reponse.getOutputStream());
				out.write(resXml.getBytes());
				out.flush();
				out.close();

			} else {
				System.out.println("通知签名验证失败");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	*//**
	 * 主动查询微信交易 返回参数列表： 未支付返回参数 return_code ：SUCCESS return_msg ：OK appid
	 * ：wx1df68f9643ab0e00 mch_id ：1337790301 nonce_str ：iQy3cI7yL7Kw9nIU sign
	 * ：CF9CB68A7FE3612151613B5AF2898B71 result_code ：SUCCESS out_trade_no
	 * ：1479270209294 trade_state ：NOTPAY trade_state_desc ：订单未支付 已支付返回参数：
	 * return_code ：SUCCESS return_msg ：OK appid ：wx1df68f9643ab0e00 mch_id
	 * ：1337790301 nonce_str ：qoMX3Jype5dcyZ6q sign
	 * ：F5260B0CB97BCE6D5FBC63A096149BC5 result_code ：SUCCESS openid
	 * ：o-TcRs5GHUfeqW-GZ89aP2-yksBA is_subscribe ：Y trade_type ：NATIVE
	 * bank_type ：CFT total_fee ：1 fee_type ：CNY transaction_id
	 * ：4002932001201611169903641764 out_trade_no ：1479278530245 attach ：
	 * time_end ：20161116144313 trade_state ：SUCCESS cash_fee ：1
	 * 
	 * 
	 * 
	 * 
	 * *//*
	// @RequestMapping(value = "weChatPayByPCChack")
	public Map<String, Object> weChatPayByPCChack(HttpServletRequest request,
			String out_trade_no) {
		try {
			String currTime = PayCommonUtil.getCurrTime();
			String strTime = currTime.substring(8, currTime.length());
			String strRandom = PayCommonUtil.buildRandom(4) + "";
			// 生成随机字符串
			String nonce_str = strTime + strRandom;
			SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
			packageParams.put("appid", WXCommon.APPID);
			packageParams.put("mch_id", WXCommon.MCHID);
			packageParams.put("nonce_str", nonce_str);
			packageParams.put("out_trade_no", out_trade_no);
			String sign = PayCommonUtil.createSign("UTF-8", packageParams,
					WXCommon.KEY);
			packageParams.put("sign", sign);// 加密
			String requestXML = PayCommonUtil.getRequestXml(packageParams);
			String resXml = HttpClientUtil.sendPost(
					"https://api.mch.weixin.qq.com/pay/orderquery", requestXML);
			// 解析xml、
			Map map = new HashMap<String, Object>();
			Document doc = (Document) DocumentHelper.parseText(resXml);
			Element books = doc.getRootElement();
			Iterator Elements = books.elementIterator();
			while (Elements.hasNext()) {
				Element user = (Element) Elements.next();
				map.put(user.getName(), user.getText());
			}
			// 返回参数
			if (map.get("return_code").toString().equals("SUCCESS")
					&& map.get("result_code").toString().equals("SUCCESS")) {

				return map;

			} else {
				System.out.println("订单检测失败！》》》WeChatController---332");
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// ********************************************end**************************************

	// ********************************************start**************************************
	*//**
	 * 微信H5支付
	 * *//*
	@RequestMapping(value = "weChatPayByH5")
	public void weChatPayByH5(HttpServletRequest request,
			HttpServletResponse response) {
		TbUserEntity tbUser = RequestSessionUtil.getSessionUser();
		if (null == tbUser) {

			ZToken tk = ApplicationContextUtil.getContext().getBean(
					ZToken.class);
			tbUser = tk.signToken(request, response);
		}

		if (tbUser != null) {
			String out_trade_no = request.getParameter("out_trade_no");// 订单号
			String total_fee = request.getParameter("price");
			String product_id = request.getParameter("product_id");// 产品ID
			String body = "MiningCircle";// 产品描述
			String userId = tbUser.getId();

			Double amount = Double.parseDouble(total_fee) * 100;
			int price = amount.intValue();
			total_fee = Integer.toString(price);

			if (body == null || body.length() == 0) {
				body = "h5";
			}
			if (userId == null || userId.length() == 0) {
				userId = "utest";
			}
			String backUri = Configure.getInstance().getValue("domain_name");
			// nginx+tomcat:8080 组合，微信支付有只能是80端口，所以这三行代码注释掉
			backUri += request.getContextPath()
					+ "/weChatPay/topayByH5.do?total_fee=" + total_fee
					+ "&out_trade_no=" + out_trade_no;
			if (product_id.length() > 0) {
				backUri += "&product_id=" + product_id;
			}
			if (body.length() > 0) {
				backUri += "&body=" + body;
			}
			if (userId.length() > 0) {
				backUri += "&user_id=" + userId;
			}
			backUri = URLEncoder.encode(backUri);
			// 授权后要跳转的链接所需的参数一般有会员号，金额，订单号之类，
			// 最好自己带上一个加密字符串将金额加上一个自定义的key用MD5签名或者自己写的签名,
			// scope 参数视各自需求而定，这里用scope=snsapi_base
			// 不弹出授权页面直接授权目的只获取统一支付接口的openid
			String ua = request.getHeader("USER-AGENT");
			String url = "";
			if (ua.contains("android") || ua.contains("Android")) {
				url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="
						+ Configure.getInstance().getValue("appid")
						+ "&redirect_uri="
						+ backUri
						+ "&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
			} else {
				url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="
						+ Configure.getInstance().getValue("appid")
						+ "&redirect_uri="
						+ backUri
						+ "&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
			}
			try {
				response.sendRedirect(url);
			} catch (IOException e) {
			}
		} else {
		}
	}

	*//**
	 * 微信支付
	 * *//*
	@RequestMapping(value = "topayByH5")
	public ModelAndView topayByH5(HttpServletRequest request,
			HttpServletResponse response) {
		// 网页授权后获取传递的参数
		String strWXPayOK_URL = (String) request.getSession().getAttribute(
				WX_PAY_OK_URL);
		// 判断支付成功同步回调地址
		if (StringUtil.isNull(strWXPayOK_URL)) {

			String userId = request.getParameter("user_id");

			ZToken tk = ApplicationContextUtil.getContext().getBean(
					ZToken.class);
			String tokenCode = tk.encodeToken(userId, null);

			strWXPayOK_URL = Configure.getInstance().getValue("domain_name")
					+ request.getContextPath() + "/user/mg.do?myorderls&tk="
					+ tokenCode;
			strWXPayOK_URL = URLEncoder.encode(strWXPayOK_URL);
		}
		// 获取微信传递的code
		String code = request.getParameter("code");
		// 商户相关资料
		String appid = WXCommon.APPID;
		String appsecret = WXCommon.APPSECRET;
		String partner = WXCommon.MCHID;
		String partnerkey = WXCommon.KEY;
		String openId = "";
		HttpResponse temp = null;
		String URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="
				+ appid + "&secret=" + appsecret + "&code=" + code
				+ "&grant_type=authorization_code";
		temp = HttpConnect.getInstance().doGetStr(URL);
		String tempValue = "";
		try {
			if (temp == null) {
				response.sendRedirect("error.jsp?msg=weixin%20oauth2%20access%20token%20is%20error");
			} else {
				tempValue = temp.getStringResult();
				JSONObject jsonObj = JSONObject.fromObject(tempValue);
				if (jsonObj.containsKey("errcode")) {
					response.sendRedirect("/weChatpay/error.jsp");
				}
				if (jsonObj.get("openid") != null)
					openId = jsonObj.getString("openid");
				else {
					response.sendRedirect("error.jsp?msg=weixin%20openid为空");
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// 获取openId后调用统一支付接口https://api.mch.weixin.qq.com/pay/unifiedorder
		// 商户站在微信支付中唯一的订单号
		String out_trade_no = request.getParameter("out_trade_no");
		// 金额转化为分为单位
		int total_fee = getParameter(request, "total_fee", 0);
		// 商户站内用户标示
		String userId = getParameter(request, "user_id", null);
		// 产品id
		String product_id = request.getParameter("product_id");
		// 产品描述
		String body = request.getParameter("body");
		// 获取当前时间
		String currTime = TenpayUtil.getCurrTime();
		// 8位日期
		String strTime = currTime.substring(8, currTime.length());
		// 四位随机数
		String strRandom = TenpayUtil.buildRandom(4) + "";
		// 10位序列号,可以自行调整。
		String strReq = strTime + strRandom;
		// 随机数
		String nonce_str = strReq;
		// 附加数据
		String attach = userId;
		// 订单生成的机器 IP
		String spbill_create_ip = request.getRemoteAddr();
		// 这里notify_url是 支付完成后微信发给该链接信息，可以判断会员是否支付成功，改变订单状态等。
		// String basePath = "http://miningcircle.com";
		// String notify_url = "";
		// String basePath = "http://test.goldenlend.com/MiningCircle";
		String notify_url = WXCommon.notify_url;
		// nginx+tomcat:8080 组合，微信支付有只能是80端口，所以这三行代码注释掉
		String openid = openId;
		SortedMap<String, String> packageParams = new TreeMap<String, String>();
		packageParams.put("appid", appid);
		packageParams.put("mch_id", partner);
		packageParams.put("nonce_str", nonce_str);
		packageParams.put("body", body);
		packageParams.put("attach", attach);
		packageParams.put("out_trade_no", out_trade_no);
		// 这里写的金额为1 分到时修改
		packageParams.put("total_fee", Integer.toString(total_fee));
		packageParams.put("spbill_create_ip", spbill_create_ip);
		packageParams.put("notify_url", notify_url);
		packageParams.put("trade_type", "JSAPI");
		packageParams.put("openid", openid);
		RequestHandler reqHandler = new RequestHandler(request, response);
		reqHandler.init(appid, appsecret, partnerkey);
		String sign = reqHandler.createSign("UTF-8", packageParams, partnerkey);
		String xml = "<xml>" + "<appid>" + appid + "</appid>" + "<mch_id>"
				+ partner + "</mch_id>" + "<nonce_str>" + nonce_str
				+ "</nonce_str>" + "<sign>" + sign + "</sign>"
				+ "<body><![CDATA[" + body + "]]></body>" + "<attach>" + attach
				+ "</attach>" + "<out_trade_no>" + out_trade_no
				+ "</out_trade_no>" + "<total_fee>" + total_fee
				+ "</total_fee>" + "<spbill_create_ip>" + spbill_create_ip
				+ "</spbill_create_ip>" + "<notify_url>" + notify_url
				+ "</notify_url>" + "<trade_type>" + "JSAPI" + "</trade_type>"
				+ "<openid>" + openid + "</openid>" + "</xml>";
		String createOrderURL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
		String prepay_id = "";
		int tryTimes = 3;
		try {
			while (tryTimes-- > 0) {
				prepay_id = new GetWxOrderno().getPayNo(createOrderURL, xml);
				if (prepay_id.length() > 0)
					break;
			}
			if (prepay_id.equals("")) {
				request.setAttribute("ErrorMsg", "统一支付接口获取预支付订单出错");
				response.sendRedirect("/weChatpay/error.jsp");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		SortedMap<String, String> finalpackage = new TreeMap<String, String>();
		finalpackage.put("appId", appid);
		finalpackage.put("timeStamp", Sha1Util.getTimeStamp());
		finalpackage.put("nonceStr", nonce_str);
		finalpackage.put("package", "prepay_id=" + prepay_id);
		finalpackage.put("signType", "MD5");
		String finalsign = reqHandler.createSign("UTF-8", finalpackage,
				partnerkey);

		try {
			body = URLEncoder.encode(body, "utf-8");
			strWXPayOK_URL += "%26pay%3d1%26no%3d" + out_trade_no + "%26m%3d"
					+ total_fee;

			String urL = "weChatPay/pay.jsp?appid=" + appid + "&timeStamp="
					+ finalpackage.get("timeStamp") + "&nonceStr="
					+ finalpackage.get("nonceStr") + "&package="
					+ finalpackage.get("package") + "&sign=" + finalsign
					+ "&desc=" + body + "&showwxpaytitle=1&wxPayOKCallURL="
					+ strWXPayOK_URL;
			ModelAndView m = new ModelAndView(urL);
			return m;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	*//**
	 * 微信电脑H5端扫描支付回调 参数：is_subscribe Y---成功支付；N--支付失败；
	 * *//*
	@RequestMapping(value = "weChatPayByH5Back")
	public Map<String, Object> weChatPayByH5Back(HttpServletRequest request,
			HttpServletResponse reponse) {
		// 读取参数
		try {
			InputStream inputStream;
			StringBuffer sb = new StringBuffer();
			inputStream = request.getInputStream();
			String s;
			BufferedReader in = new BufferedReader(new InputStreamReader(
					inputStream, "UTF-8"));
			while ((s = in.readLine()) != null) {
				sb.append(s);
			}
			in.close();
			inputStream.close();

			// 解析xml成map
			Map<String, String> m = new HashMap<String, String>();
			m = XMLUtil.doXMLParse(sb.toString());

			// 过滤空 设置 TreeMap
			SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
			Iterator it = m.keySet().iterator();
			while (it.hasNext()) {
				String parameter = (String) it.next();
				String parameterValue = m.get(parameter);

				String v = "";
				if (null != parameterValue) {
					v = parameterValue.trim();
				}
				packageParams.put(parameter, v);
			}

			// 账号信息
			String key = WXCommon.KEY; // key
			Map<String, Object> params = new HashMap<String, Object>();
			// 判断签名是否正确
			if (PayCommonUtil.isTenpaySign("UTF-8", packageParams, key)) {
				// ------------------------------
				// 处理业务开始
				// ------------------------------
				String resXml = "";
				if ("SUCCESS".equals((String) packageParams.get("result_code"))) {
					// 这里是支付成功
					// is_subscribe Y---成功支付；N--支付失败
					params.put("is_subscribe",
							(String) packageParams.get("is_subscribe"));
					params.put("out_trade_no",
							(String) packageParams.get("out_trade_no"));
					// 通知微信.异步确认成功.必写.不然会一直通知后台.八次之后就认为交易失败了.
					resXml = "SUCCESS";

				} else {
					System.out.println("支付失败,错误信息："
							+ packageParams.get("err_code"));

				}
				// ------------------------------
				// 处理业务完毕 给微信发送 停止回调
				// ------------------------------
				BufferedOutputStream out = new BufferedOutputStream(
						reponse.getOutputStream());
				out.write(resXml.getBytes());
				out.flush();
				out.close();
				if (params.size() > 0
						&& "Y".equals((String) params.get("is_subscribe"))) {
					return params;
				} else {
					params.put("is_subscribe", "N");
					return params;
				}

			} else {
				System.out.println("通知签名验证失败");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	// ********************************************end**************************************
	
	 * 模板消息发送
	 * 
	 * //微信消息模板类WxTemplate temp = new WxTemplate();
	 * 
	 * //URL置空，则在发送后，点击模板消息会进入一个空白页面（ios），或无法点击（android）
	 * temp.setUrl("http://weixin.qq.com/download");
	 * 
	 * //用户openIdtemp.setOpenId(openId);
	 * 
	 * //标题颜色temp.setTopcolor("#000000");
	 * 
	 * //模板消息id 对应微信公众平台的模板Id
	 * temp.setTemplate_id("m146hO1LOZae8uv-dpmxCwYjil0FZejkH4_VErS8bf0");
	 * 
	 * //详细内容 key-----对应微信的键 value---内容 color---颜色temp.put("first", "您的订单信息已更新",
	 * "#000000");temp.put("keyword1", "Givenchy Pandora Box", "#000000");
	 * temp.put("keyword2", "20160227141222012123", "#000000");
	 * temp.put("keyword3", "**666666", "#000000");temp.put("keyword4",
	 * "2016-11-14", "#000000");temp.put("remark", "***备注说明***", "#000000");
	 * 
	 * //发送 SendWXMsg(openId,temp);
	 
	@RequestMapping(value = "SendWXMsg")
	public static void SendWXMsg(WxTemplate temp) {
		// AccessToken token = WeixinUtil.getToken(WXCommon.APPID,
		// WXCommon.APPSECRET);
		AccessToken token = WeixinUtil.getToken("wx48be2415e44ee087",
				"d3638037b95b85b9bcb02ebf3b9c9f0d");
		String access_token = token.getToken();
		String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="
				+ access_token;
		String jsonString = JSONObject.fromObject(temp).toString();
		JSONObject jsonObject = WeixinUtil.httpRequest(url, "POST", jsonString);
		int result = 0;
		if (null != jsonObject) {
			if (0 != jsonObject.getInt("errcode")) {
				result = jsonObject.getInt("errcode");
			}
		}
	}

	*//**
	 * 测试微信平台
	 * *//*

	@RequestMapping(value = "VerifyWeChatrequest")
	public void Ceshi(HttpServletRequest request, HttpServletResponse response) {
		String TOKEN = "miningcircle";
		// 微信加密签名
		String signature = request.getParameter("signature");
		// 随机字符串
		String echostr = request.getParameter("echostr");
		// 时间戳
		String timestamp = request.getParameter("timestamp");
		// 随机数
		String nonce = request.getParameter("nonce");

		String[] str = { TOKEN, timestamp, nonce };
		Arrays.sort(str); // 字典序排序
		String bigStr = str[0] + str[1] + str[2];
		// SHA1加密
		String digest = new com.qlfg.weixin.utils.SHA1().getDigestOfString(
				bigStr.getBytes()).toLowerCase();

		// 确认请求来至微信
		if (digest.equals(signature)) {
			try {

				response.getWriter().print(echostr);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		
		 * //String [] tempContent = strContent.split("``"); //String openId =
		 * "oohQWwAw6EYFAchgwMOPe1dfjm4w"; String openId =
		 * "oohQWwOB_GgsPou8yG27ZLKQlqZk"; WxTemplate temp = new WxTemplate();
		 * temp.setUrl("http://www.baidu.com"); temp.setTouser(openId);
		 * temp.setTopcolor("#000000");
		 * temp.setTemplate_id("R0H2abeD35iu9qHRAoOT56dqbOknDjr7mbYkqaHDpvc");
		 * temp.put("first", "哈哈哈哈", "#000000"); temp.put("keyword1",
		 * "Givenchy Pandora Box", "#000000"); temp.put("keyword2",
		 * "20160227141222012123", "#000000"); temp.put("keyword3", "**666666",
		 * "#000000"); temp.put("keyword4", "2016-11-14", "#000000");
		 * temp.put("remark", "***--百度一下***", "#000000"); SendWXMsg(temp);
		 * double f =122.3; int d = (int) ((f*100)/1);
		 
		// String total_fee = (int)Double.parseDouble("0.20")*100+""+"";

	}
	*//***
	 * 测试
	 *//*
	private String wx_test_APPID = "wx5e8a1068ac69cf3e";
	private String wx_test_APPSECRET = "57f225ab42e598acf50f8574dc48c52c";

	*//***
	 * miningcircle  微信公众号
	 *//*
	public final static String wx_APPID = "wxfa9264a8598626f3";
	public final static String wx_APPSECRET = "10abec4956c95710f84ef8018547a0e9";

	*//**
	 * 
	 * @Description: 微信授权
	 * 
	 * @Title: authorize
	 * @param request
	 * @param response
	 *//*
	@RequestMapping(value = "authorize")
	public void authorize(HttpServletRequest request,
			HttpServletResponse response) {

		String backUri = request.getScheme() + "://" + request.getServerName()
				+ request.getContextPath();
		backUri += "/weChatPay/oauth2Authorize.do";
		backUri = URLEncoder.encode(backUri);

		String requestUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?"
				+ "appid="
				+ (WXCommon.APPID)
				+ "&redirect_uri="
				+ backUri
				+ "&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect";

		try {
			response.sendRedirect(requestUrl);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	*//***
	 * 
	 * @Description: 微信授权成功，存入数据库
	 * 
	 * @Title: oauth2Authorize
	 * @param request
	 * @param response
	 *//*
	@RequestMapping(value = "oauth2Authorize")
	public void oauth2Authorize(HttpServletRequest request,
			HttpServletResponse response) {

		// 用户同意授权后，能获取到code
		String code = request.getParameter("code");
		// 用户同意授权
		if (!"authdeny".equals(code)) {
			try {
				// 获取网页授权access_token
				WeixinOauth2Token weixinOauth2Token = WeixinUtil
						.getOauth2AccessToken( WXCommon.APPID, WXCommon.APPSECRET, code);
				// 网页授权接口访问凭证
				String accessToken = weixinOauth2Token.getAccessToken();
				// 用户标识
				String openId = weixinOauth2Token.getOpenId();
	
				// 获取用户信息
				SNSUserInfo snsUserInfo = WeixinUtil.getSNSUserInfo(accessToken,
						openId);
				
	
				// 查询用户是否第一次授权
				TbWeixinGzuserinfoEntity wxUserEntity = null;
				try {
					wxUserEntity = (TbWeixinGzuserinfoEntity) dao.queryForEntity(
							"select * from tb_weixin_gzuserinfo where openid='"
									+ openId + "'", TbWeixinGzuserinfoEntity.class,
									IDao.CACHE_NO_TIME);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	
				if (wxUserEntity.getId() != null) {
	
					wxUserEntity
							.setNickname(filterEmoji(snsUserInfo.getNickname()));
					wxUserEntity.setSex(snsUserInfo.getSex());
					wxUserEntity.setCity(snsUserInfo.getCity());
					wxUserEntity.setCountry(snsUserInfo.getCountry());
					wxUserEntity.setHeadimgurl(snsUserInfo.getHeadImgUrl());
	
					dao.update("update tb_weixin_gzuserinfo set " + " nickname='"
							+ wxUserEntity.getNickname() + "' " + " ,sex='"
							+ wxUserEntity.getSex() + "' " + " ,city='"
							+ wxUserEntity.getCity() + "' " + " ,country='"
							+ wxUserEntity.getCountry() + "' " + " ,headimgurl='"
							+ wxUserEntity.getHeadimgurl() + "' "
							+ " where openid='" + openId + "'");
					// 用户第二次授权
					request.getSession().setAttribute("wxUserEntity", wxUserEntity);
	
				} else {
					*//**
					 * 这里用户是第一次请求本页面，首先要获取用户的微信用户信息， 通过手机号判断用户是否已经在矿业圈注册
					 *//*
	
					request.getSession().setAttribute("wxUserEntity", saveWXUser(snsUserInfo, accessToken));
				}
	
				String url = "/mreg.do?at=wx";
	
				TbUserEntity tbUser = RequestSessionUtil.getSessionUser();
				if (null != tbUser) {
					AjaxJson j = wxBindingUser(request, tbUser.getId(), openId);
					int msg = Integer.parseInt(j.getMsg());
					if (msg > 1)
						url = "/index.do";
				}
			
				response.sendRedirect(url);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			// 。。。。。授权失败，返回一个错误页面
		}

	}

	*//***
	 * 
	 * @Description: 微信 openid 绑定 tb_user.id
	 * 
	 * @Method: wxBindingUser
	 * @param request
	 * @param userid
	 * @param openid
	 * @return
	 *//*
	@RequestMapping(value = "wxBindingUser")
	@ResponseBody
	public AjaxJson wxBindingUser(HttpServletRequest request, String userid,
			String openid) {
		AjaxJson j = new AjaxJson();
		j.setSuccess(false);
		j.setMsg("0");

		TbWeixinGzuserinfoEntity wxUserEntity = null;
		try {
			wxUserEntity = (TbWeixinGzuserinfoEntity) dao.queryForEntity(
					"select * from tb_weixin_gzuserinfo where openid='"
							+ openid + "'", TbWeixinGzuserinfoEntity.class, IDao.CACHE_NO_TIME);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (wxUserEntity != null) {
			if (StringUtil.isNull(wxUserEntity.getUserid())) {
				int upret = dao .update("update tb_weixin_gzuserinfo set user_id='" + userid + "' where openid='" + openid + "'");
				j.setMsg(String.valueOf(upret));
				j.setSuccess(true);
			} else {
				if (!wxUserEntity.getUserid().equals(userid)) {
					j.setMsg("-10");// 微信已绑定其它账号
				}else{
					j.setMsg("10");
					j.setSuccess(true);
				}
			}
		}
		return j;
	}

	*//***
	 * 
	 * @Description: 把微信信息存入数据库表 tb_weixin_gzuserinfo
	 * 
	 * @Method: saveWXUser
	 * @param snsUserInfo
	 * @param accessToken
	 * @return
	 *//*
	private TbWeixinGzuserinfoEntity saveWXUser(SNSUserInfo snsUserInfo,
			String accessToken) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String id = UUIDGenerator.generate();
		String insetTime = sdf.format(new Date());

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("openid", snsUserInfo.getOpenId());
		param.put("nickname", filterEmoji(snsUserInfo.getNickname()));
		param.put("sex", snsUserInfo.getSex());
		param.put("city", snsUserInfo.getCity());
		param.put("country", snsUserInfo.getCountry());
		param.put("headimgurl", snsUserInfo.getHeadImgUrl());
		param.put("insert_time", insetTime);

		TbWeixinGzuserinfoEntity weixinUserinfo = new TbWeixinGzuserinfoEntity();
		weixinUserinfo.setId(id);
		weixinUserinfo.setOpenid(snsUserInfo.getOpenId());
		weixinUserinfo.setNickname(filterEmoji(snsUserInfo.getNickname()));
		weixinUserinfo.setSex(snsUserInfo.getSex());
		weixinUserinfo.setCity(snsUserInfo.getCity());
		weixinUserinfo.setCountry(snsUserInfo.getCountry());
		weixinUserinfo.setHeadimgurl(snsUserInfo.getHeadImgUrl());

		// TODO: 把微信的图片保存到我们自己的服务器上
		dao.insert("tb_weixin_gzuserinfo", param);

		return weixinUserinfo;
	}

	*//**
	 * 
	 * @Description: 过滤微信名称是特殊符号
	 * 
	 * @Method: filterEmoji
	 * @param source
	 * @return
	 *//*
	public static String filterEmoji(String source) {
		if (StringUtil.isNull(source)) {
			return source;
		} else {
			return source.replaceAll("[^\\u0000-\\uFFFF]", "\uFFFD");
		}
	}
	*/
	
	
	
	
	@RequestMapping(value = "share")
	@ResponseBody
	public AjaxJson share(HttpServletRequest request,HttpServletResponse reponse){
		AjaxJson j = new AjaxJson();
        String url = request.getParameter("url");
        Map<String, String> ret = PastUtil.getParam(url, WXCommon.APPID, WXCommon.APPSECRET);
        
        j.setObj(ret);
		return j;	
	}
}
