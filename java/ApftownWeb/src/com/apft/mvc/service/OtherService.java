package com.apft.mvc.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface OtherService {

	
	
	/***
	 * 记录用户行为日志
	 * @param actType	类型
	 * @param rid		tb_res.id
	 */
	public void userAct(HttpServletRequest request,HttpServletResponse response, String actType, String rid);
}
