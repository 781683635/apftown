package com.apft.mvc.controller.home;



import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.apft.core.AjaxJson;
import com.apft.mvc.controller.comm.BaseController;
import com.apft.mvc.service.ResService;
import com.apft.utils.SiteOEM;




@Controller
public class IndexController extends BaseController{
	
	
	
	@Autowired
	private ResService resService; 
	
	
	@RequestMapping(value = "index")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response){
		SiteOEM s_oem = SiteOEM.getSOEM(); if (null == s_oem) s_oem = new SiteOEM(request, response);
		s_oem.setParameter(request);
		
		
		ModelAndView mv = new ModelAndView((SiteOEM.getSOEM().isMobile()?"m/":"")+"index");
		List<Map<String, Object>> listMap = resService.queryIndex("200000",0,-1,0,0);
		mv.addObject("listMap", listMap);
		
		List<Map<String, Object>> leftlist = resService.queryIndex("200000", 0, 0,0,0);
		mv.addObject("leftlist", leftlist);
		
		return mv;
	}
	
	
/*	*//**
	 * 手机版or电脑版
	 * @param request
	 * @return
	 *//*
	@RequestMapping(value = "SZ")
	@ResponseBody
	public AjaxJson chanageSZ(HttpServletRequest request){
		AjaxJson json = new AjaxJson();
		String strSz = request.getParameter("SZ");
		if("s".equals(strSz)){
			SiteOEM.getSOEM().setMobileOrPC(true);
		}else if("l".equals(strSz))
			SiteOEM.getSOEM().setMobileOrPC(false);
		json.setSuccess(true);
		return json;
	}*/
	@RequestMapping(value = "SZ")
	@ResponseBody
	public AjaxJson chanageSZ(HttpServletRequest request,HttpServletResponse response){
		AjaxJson json = new AjaxJson();
		
		String strSz = request.getParameter("SZ");
		//手机版
		if("s".equals(strSz)){	
			SiteOEM.getSOEM().setMobileOrPC(true);
		//电脑版
		}else if("l".equals(strSz))
			SiteOEM.getSOEM().setMobileOrPC(false);
		json.setSuccess(true);
		return json;
	}
}
