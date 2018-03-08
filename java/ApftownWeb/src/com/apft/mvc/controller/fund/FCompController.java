package com.apft.mvc.controller.fund;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.apft.mvc.dao.CommDao;
import com.apft.mvc.service.ResService;
import com.apft.utils.SiteOEM;

@Controller
@RequestMapping("user")
public class FCompController {
	@Autowired
	CommDao commDao;
	@Autowired
	ResService resService;
	
	@RequestMapping(value="fCInfo")
	public ModelAndView fCInfo(HttpServletRequest request,HttpServletResponse response){
		request=resService.upFundInfo(null,request);
		ModelAndView mv = new ModelAndView((SiteOEM.getSOEM().isMobile()?"m/":"")+"/fund/fCInfo");
		return mv;
	}
	
	@RequestMapping(value="fDownLoad")
	public ModelAndView fDownLoad(HttpServletRequest request,HttpServletResponse response){
		request=resService.upFundInfo(null,request);
		ModelAndView mv = new ModelAndView((SiteOEM.getSOEM().isMobile()?"m/":"")+"/fund/fDownLoad");
		return mv;
	}
}
