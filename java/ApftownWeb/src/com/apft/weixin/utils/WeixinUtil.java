package com.apft.weixin.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.apft.weixin.pojo.AccessToken;
import com.apft.weixin.pojo.SNSUserInfo;
import com.apft.weixin.pojo.WeixinOauth2Token;



/**
 * 公众平台通用接口工具类
 * 
 */
public class WeixinUtil {
	private static Logger log = LoggerFactory.getLogger(WeixinUtil.class);

	
	
	// 获取access_token的接口地址（GET） 限200（次/天）
	public final static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

	//oauth2.0 用户授权地址
	public final static String oauth_url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
	//oauth2.0 获取用户信息地址
	public final static String oauth_acess_token_url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
	//以用户open_id换取userinfo地址
	public final static String sns_userinfo_url = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID";
	//获取acess_token地址
	public final static String get_acess_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	
	/**
     * 发起https请求并获取结果
     * 
     * @param requestUrl 请求地址
     * @param requestMethod 请求方式（GET、POST）
     * @param outputStr 提交的数据
     * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
     */
    public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr) {
        JSONObject jsonObject = null;
        StringBuffer buffer = new StringBuffer();
        try {
                // 创建SSLContext对象，并使用我们指定的信任管理器初始化
                TrustManager[] tm = { new MyX509TrustManager() };
                SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
                sslContext.init(null, tm, new java.security.SecureRandom());
                // 从上述SSLContext对象中得到SSLSocketFactory对象
                SSLSocketFactory ssf = sslContext.getSocketFactory();

                URL url = new URL(requestUrl);
                HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
                httpUrlConn.setSSLSocketFactory(ssf);

                httpUrlConn.setDoOutput(true);
                httpUrlConn.setDoInput(true);
                httpUrlConn.setUseCaches(false);
                // 设置请求方式（GET/POST）
                httpUrlConn.setRequestMethod(requestMethod);

                if ("GET".equalsIgnoreCase(requestMethod))
                        httpUrlConn.connect();

                // 当有数据需要提交时
                if (null != outputStr) {
                        OutputStream outputStream = httpUrlConn.getOutputStream();
                        // 注意编码格式，防止中文乱码
                        outputStream.write(outputStr.getBytes("UTF-8"));
                        outputStream.close();
                }

                // 将返回的输入流转换成字符串
                InputStream inputStream = httpUrlConn.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String str = null;
                while ((str = bufferedReader.readLine()) != null) {
                        buffer.append(str);
                }
                bufferedReader.close();
                inputStreamReader.close();
                // 释放资源
                inputStream.close();
                inputStream = null;
                httpUrlConn.disconnect();
                jsonObject = JSONObject.fromObject(buffer.toString());
                //jsonObject = JSONObject.fromObject(buffer.toString());
        } catch (ConnectException ce) {
        	//LogUtil.info("Weixin server connection timed out.");
        } catch (Exception e) {
        	//LogUtil.info("https request error:{}"+e.getMessage());
        }
        return jsonObject;
    }
    /**
	 * 获取网页授权凭证
	 * 
	 * @param appId 公众账号的唯一标识
	 * @param appSecret 公众账号的密钥
	 * @param code
	 * @return WeixinAouth2Token
	 */
	public static WeixinOauth2Token getOauth2AccessToken(String appId, String appSecret, String code) {
		WeixinOauth2Token wat = null;
		// 拼接请求地址
		String requestUrl = oauth_acess_token_url.replace("APPID", appId).replace("SECRET", appSecret).replace("CODE", code);
		// 获取网页授权凭证
		JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
		if (null != jsonObject) {
			try {
				wat = new WeixinOauth2Token();
				wat.setAccessToken(jsonObject.getString("access_token"));
				wat.setExpiresIn(jsonObject.getInt("expires_in"));
				wat.setRefreshToken(jsonObject.getString("refresh_token"));
				wat.setOpenId(jsonObject.getString("openid"));
				wat.setScope(jsonObject.getString("scope"));
			} catch (Exception e) {
				wat = null;
				int errorCode = jsonObject.getInt("errcode");
				String errorMsg = jsonObject.getString("errmsg");
				String errmsg = "获取网页授权凭证失败 errcode:{'"+errorCode+"'} errmsg:{'"+errorMsg+"'}";
			}
		}
		return wat;
	}
	/**
	 * 通过网页授权获取用户信息
	 * 
	 * @param accessToken 网页授权接口调用凭证
	 * @param openId 用户标识
	 * @return SNSUserInfo
	 */
	@SuppressWarnings( { "deprecation", "unchecked" })
	public static SNSUserInfo getSNSUserInfo(String accessToken, String openId) {
		SNSUserInfo snsUserInfo = null;
		String requestUrl = sns_userinfo_url.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
		// 通过网页授权获取用户信息
				JSONObject jsonObject = httpRequest(requestUrl, "GET", null);

				if (null != jsonObject) {
					try {
						snsUserInfo = new SNSUserInfo();
						// 用户的标识
						snsUserInfo.setOpenId(jsonObject.getString("openid"));
						// 昵称
						snsUserInfo.setNickname(jsonObject.getString("nickname"));
						// 性别（1是男性，2是女性，0是未知）
						snsUserInfo.setSex(jsonObject.getInt("sex"));
						// 用户所在国家
						snsUserInfo.setCountry(jsonObject.getString("country"));
						// 用户所在省份
						snsUserInfo.setProvince(jsonObject.getString("province"));
						// 用户所在城市
						snsUserInfo.setCity(jsonObject.getString("city"));
						// 用户头像
						snsUserInfo.setHeadImgUrl(jsonObject.getString("headimgurl"));
						// 用户特权信息
						snsUserInfo.setPrivilegeList(JSONArray.toList(jsonObject.getJSONArray("privilege"), List.class));
					} catch (Exception e) {
						snsUserInfo = null;
						int errorCode = jsonObject.getInt("errcode");
						String errorMsg = jsonObject.getString("errmsg");
						String errmsg = "获取网页授权凭证失败 errcode:{'"+errorCode+"'} errmsg:{'"+errorMsg+"'}";
					}
				}
				return snsUserInfo;
		
		
	}
	  /**
     * 获取接口访问凭证
     * 
     * @param appid 凭证
     * @param appsecret 密钥
     * @return
     */
    public static String getAccess_token(String appid, String appsecret) {
            
    	//凭证获取(GET)
        String requestUrl = get_acess_token_url.replace("APPID", appid).replace("APPSECRET", appsecret);
        // 发起GET请求获取凭证
        JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
                String access_token = null;
        if (null != jsonObject) {
            try {
                access_token = jsonObject.getString("access_token");
            } catch (JSONException e) {
                // 获取token失败
            	String errmsg = "获取token失败 errcode:{} errmsg:{}"+jsonObject.getInt("errcode")+jsonObject.getString("errmsg");
            }
        }
        return access_token;
    }
    /**
     * 调用微信JS接口的临时票据
     * 
     * @param access_token 接口访问凭证
     * @return
     */
    public static String getJsApiTicket(String access_token) {
        String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
        String requestUrl = url.replace("ACCESS_TOKEN", access_token);
        // 发起GET请求获取凭证
        JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
        String ticket = null;
        if (null != jsonObject) {
            try {
                ticket = jsonObject.getString("ticket");
            } catch (JSONException e) {
                // 获取token失败
            	String errmsg = "获取token失败 errcode:{} errmsg:{}"+jsonObject.getInt("errcode")+jsonObject.getString("errmsg");
            }
        }
        return ticket;
    }
    /**
	 * 获取接口访问凭证
	 * 
	 * @param appid 凭证
	 * @param appsecret 密钥
	 * @return
	 */
	public static AccessToken getToken(String appid, String appsecret) {
		AccessToken token = null;
		String requestUrl = get_acess_token_url.replace("APPID", appid).replace("APPSECRET", appsecret);
		// 发起GET请求获取凭证
		JSONObject jsonObject = httpRequest(requestUrl, "GET", null);

		if (null != jsonObject) {
			try {
				token = new AccessToken();
				token.setToken(jsonObject.getString("access_token"));
				token.setExpiresIn(jsonObject.getInt("expires_in"));
			} catch (JSONException e) {
				token = null;
				// 获取token失败
				String errmsg = "获取token失败 errcode:{} errmsg:{}"+jsonObject.getInt("errcode")+jsonObject.getString("errmsg");
			}
		}
		return token;
	}
}