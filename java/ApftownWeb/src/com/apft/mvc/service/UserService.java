package com.apft.mvc.service;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
	
	public HttpServletRequest queryAtten(HttpServletRequest request,Integer pageNum,Integer pageSize,String userId,Integer type);
	public HttpServletRequest queryMsg(HttpServletRequest request, Integer pageNum,Integer pageSize, String userId);
	public int updateMsg(HttpServletRequest request);
	public HttpServletRequest queryAtten(HttpServletRequest request,Integer pageNum,Integer pageSize,String userId,Integer type,String Code);

	/**
	 * 显示用户入园更新状态
	 * @param request
	 * @return
	 */
	public HttpServletRequest selUpstatus(HttpServletRequest request,String id);
	/**
	 * 报名信息管理
	 * @param request
	 * @param pageNum
	 * @param pageSize
	 * @param Code
	 * @return
	 */
	public HttpServletRequest queryDateList(HttpServletRequest request,Integer pageNum, Integer pageSize, String Code);
	/**
	 * 查询入园人员
	 * @param request
	 * @param pageNum
	 * @param pageSize
	 * @param Code 对应的code参数
	 * @return
	 */
	public HttpServletRequest querypintoPark(HttpServletRequest request,Integer pageNum,Integer pageSize);
}
