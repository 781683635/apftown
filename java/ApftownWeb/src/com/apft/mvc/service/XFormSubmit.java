package com.apft.mvc.service;

import java.util.List;
import java.util.Map;

import com.apft.mvc.dao.CommDao;

/***
 * @nULL@
 * 
 * @author Administrator
 *
 */
public interface XFormSubmit {

	public String saveOrUpdatgeFormListMap(CommDao dao, Map<String, String> mapPara, String uid);
	
	public List<Map<String,Object>> getFormListMap(Map<String, String> mapPara, String uid);

	public void logFormListMap(List<Map<String,Object>> lstMapForm);
}
