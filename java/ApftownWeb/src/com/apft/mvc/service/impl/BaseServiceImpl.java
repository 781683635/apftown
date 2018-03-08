package com.apft.mvc.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.apft.mvc.service.BaseService;
import com.apft.utils.SiteOEM;

@Resource
public class BaseServiceImpl implements BaseService{

	@Override
	public Map<String, Object> getLg(){
		Map<String, Object> map = new HashMap<String, Object>();
		if(SiteOEM.getSOEM().isLgEn()){
			map.put("reslg", "1");
			map.put("reslang", "2");
		}else{
			map.put("reslg", "0");
			map.put("reslang", "1");
		}
		return map;
	}
}
