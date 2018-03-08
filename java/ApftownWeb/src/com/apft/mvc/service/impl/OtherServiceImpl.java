package com.apft.mvc.service.impl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.apft.core.DBCache;
import com.apft.mvc.model.TbUserEntity;
import com.apft.mvc.service.OtherService;
import com.apft.utils.LogUtils;
import com.apft.utils.SessionUtil;
import com.apft.utils.SiteOEM;
import com.apft.utils.StringUtil;
import com.apft.utils.ZLConfigure;
import com.apft.utils.ZLUtils;



@Service
public class OtherServiceImpl implements OtherService{

	
	/**
	 * 记录用户行为日志
	 * @param request
	 */
	@Override
	public void userAct(HttpServletRequest request, HttpServletResponse response, String actType, String rid){
		SiteOEM s_oem = SiteOEM.getSOEM(); if (null == s_oem) return;
		
		
		Map<String, String> paraMap = request.getParameterMap();
		
		String url = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + request.getServletPath() + "?" + (request.getQueryString()); 
		
		if(StringUtil.isNull(actType))
			actType = request.getServletPath();
		if(actType.indexOf("&") > -1)
			actType = actType.substring(0, actType.indexOf("&"));
		if(actType.indexOf("=") > -1)
			actType = actType.substring(0, actType.indexOf("="));
		
		actType = actType.replace("null", "").substring(1);
		
		String ip = ZLUtils.getIpAddr(request);
		String userAgent = request.getHeader("User-Agent");
		if(null != userAgent && userAgent.length() > 1000)
			userAgent = userAgent.substring(0, 1000);
		LogUtils.logInfo(userAgent);	
		String os;
		if(StringUtil.isNull(s_oem._UAP))
			os = "pc";
		else
			os = "app-"+s_oem._UAP;
		
		TbUserEntity tbUser = SessionUtil.getSessionUser();
		String uid = "";
		if(null != tbUser)
			uid = tbUser.getId();
			

		Map<String, Object> urlMap = ZLConfigure.getInstance().urlMap;
		if(urlMap.containsKey(actType)){

			String mapValue = urlMap.get(actType).toString();
			if(mapValue.contains(",")){
				String [] canval = mapValue.split(",");
				for (int i = 0; i < canval.length; i++) {
					if(!StringUtil.isNull(canval[i]) && paraMap.containsKey(canval[i])){
						Object val = paraMap.get(canval[i]);
						if(StringUtil.isNotEmpty(val)){
							String vvv[] = (String[])val;
							rid = vvv[0];
						}
					}
				}
			}else{
				if(!StringUtil.isNull(mapValue) && paraMap.containsKey(mapValue)){
					Object val = paraMap.get(mapValue);
					if(StringUtil.isNotEmpty(val)){
						String vvv[] = (String[])val;
						rid = vvv[0];
					}
				}
			}
			
			String key = request.getSession().getId()+url;
			if (DBCache.getInstance().get(key)==null){
				recordUserAct(uid, ip, actType, userAgent, url, null, os, request.getSession().getId(), rid);
				
				DBCache.getInstance().set(key, "actType");
			}
		}
	}
	/***
	 * 
	 * @param uid
	 * @param ip
	 * @param type
	 * @param act_data		user-agent
	 * @param act_data2		url
	 * @param act_data3		resid
	 * @param os			app|pc
	 * @param sessionid		sessionid
	 */
	public void recordUserAct(String uid, String ip, String type, String act_data, String act_data2,String act_data3
			,String os, String sessionid, String rid){
/*
		String addSQL = "INSERT INTO tb_user_act_log(id, user_id, ip, act_type, act_data, act_data2, act_data3, act_result, " +
							"os, sessionid, rid)" +
						" VALUE('"+UUIDGenerator.generate()+"', '"+uid+"', '"+ip+"', '"+type+"', '"+act_data+"', '"+act_data2+"', '"+act_data3+"', 0, " +
							"'"+os+"', '"+sessionid+"', '"+rid+"')";
		//dao.update(addSQL);
		*/
		
		act_data = act_data.replace('|', '+');
		
		String str = "id`=`"+ZLUtils.UUIDgenerate() +"|user_id`=`"+ uid+"|ip`=`"+ip+"|act_type`=`"+type+"|act_data`=`"+act_data+"|act_data2`=`"+act_data2+"|act_data3`=`"+act_data3+"|os`=`"+os+"|rid`=`"+rid;
		LogUtils.logInfo(str);
		
	}

	
	
	
}
