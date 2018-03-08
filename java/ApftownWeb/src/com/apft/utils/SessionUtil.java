package com.apft.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.apft.mvc.model.TbUserEntity;



public class SessionUtil {
	
	
	public static final String KEY_USER = "UserEntity";
	

	/**
	 * SpringMvc下获取request
	 * 
	 * @return
	 */
	public static HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		return request;

	}
	
	/**
	 * SpringMvc下获取session 
	 * 
	 * @return
	 */
	public static HttpSession getSession() {
		return getSession(true);
	}
	
	public static HttpSession getSession(boolean bool) {
		HttpSession session=null;
		if(bool){
			session = getRequest().getSession();
		}else{
			session = getRequest().getSession(false);
		}
		
		return session;

	}
	
	/**
	 * 清除sessionz中的值
	 * 
	 * @return
	 */
	public static void removeSession(String key) {
		
		getSession().removeAttribute(key);
	}
	
	/**
	 * 
	 * 
	 * @return
	 */
	public static void addSession(String key,Object obj) {
		
		SessionUtil.getSession(true).setAttribute(key, obj);
	}
	
	
	public static TbUserEntity getSessionUser(){
		return (TbUserEntity)getSession().getAttribute(KEY_USER);
	}

	public static void setSessionUser(TbUserEntity userEntity){
		getSession().setAttribute(KEY_USER,userEntity);
	}
}
