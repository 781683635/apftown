package com.apft.mvc.controller.comm;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.apft.mvc.service.BaseService;

@Controller
public class BaseController {
	
	@Autowired
	BaseService baseService;
	
	
	public Map<String, Object> getLg(){
		return baseService.getLg();
	}
	
}
