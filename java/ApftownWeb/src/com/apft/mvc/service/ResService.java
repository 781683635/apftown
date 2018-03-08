package com.apft.mvc.service;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.apft.mvc.model.TbResEntity;

public interface ResService {
	/**
	 * 
	 * @param request
	 * @param catId
	 * @param pageNum
	 * @param pageSize
	 * @param code
	 * @param cacheTime
	 * @return
	 */
	public HttpServletRequest resList(HttpServletRequest request,String catId, Integer pageNum, Integer pageSize,int code, int cacheTime);
	
	
	public TbResEntity resInfo(HttpServletRequest request);
	public int updateres(HttpServletRequest request);
	
	/***
	 * 
	 * @param request
	 * @param pageNum
	 * @param pageSize
	 * @param catId
	 * @param code
	 * @param status
	 * @return
	 */
	public HttpServletRequest queryChildIndex(HttpServletRequest request,Integer pageNum,Integer pageSize,String catId,Integer code,Integer status);
	/***
	 * 
	 * @param catId
	 * @param cat
	 * @param bk
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<Map<String, Object>> queryIndex(String catId,Integer cat,Integer bk,Integer pageNum,Integer pageSize);
	public List<Map<String, Object>> queryIndex(HttpServletRequest request,String catId, Integer cat,Integer bk,Integer pageNum,Integer pageSize);
	
	public Map<String, Object> newInfo(String catId, Integer resNo);
	public List<Map<String,Object>> newMap(int code);
	/**
	 * 用户自己管理入园申请
	 * @param request
	 * @return
	 */
	public HttpServletRequest upFundInfo(String moblie,HttpServletRequest request);
	public int updateComp(HttpServletRequest request);
	/**
	 * 管理员管理入园申请
	 * @param request
	 * @return
	 */
	public HttpServletRequest upMInfo(HttpServletRequest request);
}
