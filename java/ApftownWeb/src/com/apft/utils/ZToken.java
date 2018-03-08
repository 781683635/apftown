package com.apft.utils;

import java.net.URLDecoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jodd.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apft.mvc.dao.CommDao;
import com.apft.mvc.model.TbUserEntity;




@Component
public class ZToken {
	
	public static final String ZTOKEN_USER_KEY = "kyq.mc";
	
	public static final String ZTOKEN_WX_USER_KEY = "wx.mc";
	public static final String SPLIDER = "`";
	public static final long MAX_LIFE_TIME = 1296000000L;// 15天

	
	@Autowired
	private CommDao dao;
	
	
	/**删除token*/
//	public void deleteToken(String userId){
//		TbUserTokenEntity user = dao.findUniqueByProperty(TbUserTokenEntity.class, "userId", userId);
//		dao.delete(user);
//	}
	
	
	/**保存或者更新token方法*/
//	public void saveOrUpdateToken(String userId){
//		String tokenCode = encodeToken(userId,);
//		TbUserTokenEntity token = dao.findUniqueByProperty(TbUserTokenEntity.class, "userId", userId);
//		token.setData(tokenCode);
//		
//		dao.saveOrUpdate(token);
//	}
	
	private  long getMask(long kk) {
		return kk ^ 0x20150618 ^ ((~(kk >> 3)) & 0xfebcabcd);
	}

	
	public String encodeToken(String strUID, String strIMEI) {
		long current_time = System.currentTimeMillis();
		long kk = current_time;
		kk = getMask(kk);
		String md5 = "";
		
		String strData = strUID + SPLIDER + kk + SPLIDER;
		if (strIMEI != null && strIMEI.length()>0){
			strData += strIMEI + SPLIDER;
		}
		
		
		md5 = CRC16.getCRC16(strData);//MD5(strUID + SPLIDER + strUserAgent + SPLIDER + kk + SPLIDER);
		String code = strUID  + SPLIDER + current_time + SPLIDER + md5;
		String code_base64_encode = Base64.encodeToString(code.getBytes());
		return code_base64_encode;
	}

	
	public String decodeToken(String strToken) {
		String str = null;
		try {
			if (strToken.indexOf('%')>=0){
				strToken = URLDecoder.decode(strToken, "utf-8");
			}
			str = new String(Base64.decode(strToken.getBytes()));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			String[] codeArr = str.split(SPLIDER);
			
			if (codeArr.length==3 || codeArr.length==4){
				// 第一位是用户id
				String userId = codeArr[0];
				// 第2位是current_time的时间
				long actTime = Long.parseLong(codeArr[1]);
				long kk = getMask(actTime);
				// 第3位是md5

				
				String md5 = codeArr.length==3?codeArr[2]:codeArr[3];
				String strData = userId + SPLIDER + kk + SPLIDER;
				if (codeArr.length==4){
					strData += codeArr[3] + SPLIDER;
				}
				
				String md5_new = CRC16.getCRC16(strData);
				if (md5.equals(md5_new)) {
					// 对比时间
					if ((actTime + MAX_LIFE_TIME) > System.currentTimeMillis()) {
						return userId;
					} else {
						// token过期
						// 从数据库中删除token(根据userId去删除)
//						dao.deleteEntityById(TbUserTokenEntity.class, userId);
					}
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public TbUserEntity signToken(String tokenCode){
		//验证token 
		if (tokenCode != null){
			ZToken token = new ZToken();
			String userId = token.decodeToken(tokenCode);
			if(userId != null){
				TbUserEntity cuser = (TbUserEntity) dao.queryForObject("select * from tb_user where id='"+userId+"'",  TbUserEntity.class, -1);
				return cuser;
			}
		}
		return null;
	}	
	
	/***
	 * 
	 * @Description: 获取 token 信息 TbUserEntity 信息
	 *
	 * @Method: signToken
	 * @param request
	 * @param response
	 * @param cookName
	 * @return
	 */
	public TbUserEntity signUserToken(HttpServletRequest request,HttpServletResponse response){
		//验证token 
		String tokenCode = request.getParameter("tk");
		if (tokenCode == null){
			Cookie []cookies = request.getCookies();
			if (cookies != null){
				for(Cookie c : cookies){
					if(c.getName().equals(ZTOKEN_USER_KEY)){
						tokenCode = c.getValue();
						break;
					}
				}
				
			}
		}
		if (tokenCode != null){
			ZToken token = new ZToken();
			String objId = token.decodeToken(tokenCode);
			if(objId != null){
				TbUserEntity tbUser = (TbUserEntity)dao.queryForObject("select * from tb_user where id='"+objId+"'",TbUserEntity.class, -1);
					
				if (tbUser != null){
					
					writeToken(request,response, ZTOKEN_USER_KEY, tbUser.getId());
					
					//查询该用户的红点提醒
					//Map<String, Object> tipsTotal = userTdService.tips(userId);
					//request.getSession().setAttribute("tipsTotal", tipsTotal);
					
					
					return tbUser;
				}
			}
		}
		return null;
	}
	
	
	
	
	/***
	 * 
	 * @Description: 写入cookie，存入session
	 *
	 * @Method: writeToken
	 * @param request
	 * @param response
	 * @param cookName
	 * @param strId		tb_user.id|tb_weixin_gzuserinfo.id
	 * @return
	 */
	public String writeToken(HttpServletRequest request,HttpServletResponse response, String cookName, String strId){
		//重新生成token
		String tokenValCode = encodeToken(strId, null);
		//写入cookie
		Cookie cookie = new Cookie(cookName,tokenValCode);
		cookie.setPath("/");
		cookie.setMaxAge(1*24*60*60);
		response.addCookie(cookie);
		SessionUtil.getSession().setAttribute(cookName, tokenValCode);	
		return tokenValCode;
	}
	
	
	/**
	 * 
	 * @Description: 删除 session.cookName,cookie.name 
	 *
	 * @Method: removeToken
	 * @param request
	 * @param response
	 * @param cookName		cookie.name
	 * @param sessionId
	 */
	public void removeToken(HttpServletRequest request, HttpServletResponse response, String cookName, String sessionId){
		//写入cookie
		Cookie cookie = new Cookie(cookName,null);
		cookie.setPath("/");
		cookie.setMaxAge(-1);
		cookie.setValue(null);
		response.addCookie(cookie);
	}
	
	
	public String getSignType(HttpServletRequest request, HttpServletResponse response, String signID){
		if(signID != null){
			String tokenValCode = null;
			Cookie []cookies = request.getCookies();
			if (cookies != null){
				for(Cookie c : cookies){
					String tokenKeyCode = decodeToken(c.getName());
					if(tokenKeyCode != null && tokenKeyCode.equals(signID)){
						tokenValCode = c.getValue();
						break;
					}
				}
				if(tokenValCode != null)
					return decodeToken(tokenValCode);
			}
		}
		return null;
	}
	
	
	public String writeSignType(HttpServletRequest request, HttpServletResponse response, String signID, int type){
		Cookie []cookies = request.getCookies();
		for(Cookie c : cookies){
			String tokenKeyCode = decodeToken(c.getName());
			if(tokenKeyCode != null && tokenKeyCode.equals(signID)){
				c.setMaxAge(0);
				c.setValue(null);
				response.addCookie(c);
			}
		}
		//重写ID
		String tokenKeyCode = encodeToken(signID, null);
		String tokenValCode = encodeToken(String.valueOf(type), null);
		//写入cookie
		Cookie cookie = new Cookie(tokenKeyCode,tokenValCode);
		cookie.setPath("/");
		cookie.setMaxAge(2592000);
		response.addCookie(cookie);
		SessionUtil.getSession().setAttribute(tokenKeyCode, tokenValCode);
		return tokenValCode;
	}
	
	

}
