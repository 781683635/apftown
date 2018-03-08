package com.apft.mvc.controller.other;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.apft.mvc.dao.CommDao;
import com.apft.mvc.service.ResService;
import com.apft.utils.SiteOEM;

@Controller
public class AboutUsController {

	@Autowired
	CommDao commDao;
	@Autowired
	ResService resService;
	
	@RequestMapping(value="aboutUs")
	public ModelAndView regCode(HttpServletRequest request,HttpServletResponse response){
		/*	String user_reg_mobile=request.getParameter("user_reg_mobile");*/
			ModelAndView mv = new ModelAndView((SiteOEM.getSOEM().isMobile()?"m/":"")+"/about/aboutUs");
			return mv;
		}
}
