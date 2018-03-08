package com.apft.mvc.service;

import java.util.List;
import java.util.Map;

import com.apft.mvc.model.TbChinaAreaEntity;


public interface CommService {
	
	
	public List<Map<String, Object>> proplst(String cat, int res_prop);
	
	/***
	 * 
	 * @Description: 地区的三级联动
	 *
	 * @Method: chinaArea
	 * @param parentid
	 * @return
	 */
	public List<TbChinaAreaEntity> chinaArea(String parentid);
	
	
	
}
