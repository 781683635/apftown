package com.apft.mvc.controller.reg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.apft.mvc.dao.CommDao;
import com.apft.mvc.model.TbUserEntity;
import com.apft.mvc.service.ResService;
import com.apft.utils.SessionUtil;
import com.apft.utils.SiteOEM;
import com.apft.utils.StringUtil;

@Controller
public class FLoginController {
	
	@Autowired
	CommDao commDao;
	@Autowired
	ResService resService;
	
/*
	@RequestMapping(value="regFlogin")
	public ModelAndView regFlogin(HttpServletRequest request,HttpServletResponse response){
		if (SessionUtil.getSessionUser() != null) {
			return new ModelAndView("loginFsuccess.do");
		}
		ModelAndView mv = new ModelAndView((SiteOEM.getSOEM().isMobile()?"m/":"")+"/reg/regFlogin");
		return mv;
	}*/
	
	@RequestMapping(value="loginFsuccess")
	public ModelAndView loginFsuccess(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView((SiteOEM.getSOEM().isMobile()?"m/":"")+"/reg/loginFsuccess");
		return mv;
	}
	@RequestMapping(value="forgetFpwd")
	public ModelAndView forgetFpwd(HttpServletRequest request,HttpServletResponse response){
		// 短信验证码
		String sms6 = StringUtil.getRandomString(6);
		request.getSession().setAttribute("randomSMS", sms6);
		ModelAndView mv = new ModelAndView((SiteOEM.getSOEM().isMobile()?"m/":"")+"/reg/forgetFpwd");
		return mv;
	}
	@RequestMapping(value="/FsetPwd")
	public ModelAndView FsetPwd(HttpServletRequest request,HttpServletResponse response){
		TbUserEntity tbUserRegister = (TbUserEntity) request.getSession().getAttribute("tbUserRegister");
		ModelAndView mv = new ModelAndView((SiteOEM.getSOEM().isMobile()?"m/":"")+"/reg/FsetPwd");
		mv.addObject("tbUserRegister", tbUserRegister);
		return mv;
	}
}
