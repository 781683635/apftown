package com.apft.mvc.controller.news;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.apft.mvc.dao.CommDao;
import com.apft.utils.SiteOEM;

@Controller
public class NewBaiduController {

	@Autowired
	CommDao commdao;
	
	@RequestMapping(value="NewsbaiduOne")
	public ModelAndView NewsbaiduOne(HttpServletRequest request,HttpServletResponse response){
		/*	String user_reg_mobile=request.getParameter("user_reg_mobile");*/
			ModelAndView mv = new ModelAndView((SiteOEM.getSOEM().isMobile()?"m/":"")+"/news/Newsbaidu/NewsbaiduOne");
			return mv;
	}
	@RequestMapping(value="NewsbaiduTwo")
	public ModelAndView NewsbaiduTwo(HttpServletRequest request,HttpServletResponse response){
		/*	String user_reg_mobile=request.getParameter("user_reg_mobile");*/
			ModelAndView mv = new ModelAndView((SiteOEM.getSOEM().isMobile()?"m/":"")+"/news/Newsbaidu/NewsbaiduTwo");
			return mv;
	}
	@RequestMapping(value="NewsbaiduThree")
	public ModelAndView NewsbaiduThree(HttpServletRequest request,HttpServletResponse response){
		/*	String user_reg_mobile=request.getParameter("user_reg_mobile");*/
			ModelAndView mv = new ModelAndView((SiteOEM.getSOEM().isMobile()?"m/":"")+"/news/Newsbaidu/NewsbaiduThree");
			return mv;
	}
	@RequestMapping(value="NewsbaiduFour")
	public ModelAndView NewsbaiduFour(HttpServletRequest request,HttpServletResponse response){
		/*	String user_reg_mobile=request.getParameter("user_reg_mobile");*/
			ModelAndView mv = new ModelAndView((SiteOEM.getSOEM().isMobile()?"m/":"")+"/news/Newsbaidu/NewsbaiduFour");
			return mv;
	}
	@RequestMapping(value="NewsbaiduFive")
	public ModelAndView NewsbaiduFive(HttpServletRequest request,HttpServletResponse response){
		/*	String user_reg_mobile=request.getParameter("user_reg_mobile");*/
			ModelAndView mv = new ModelAndView((SiteOEM.getSOEM().isMobile()?"m/":"")+"/news/Newsbaidu/NewsbaiduFive");
			return mv;
	}
	@RequestMapping(value="NewsbaiduSix")
	public ModelAndView NewsbaiduSix(HttpServletRequest request,HttpServletResponse response){
		/*	String user_reg_mobile=request.getParameter("user_reg_mobile");*/
			ModelAndView mv = new ModelAndView((SiteOEM.getSOEM().isMobile()?"m/":"")+"/news/Newsbaidu/NewsbaiduSix");
			return mv;
	}
	@RequestMapping(value="NewsbaiduSeven")
	public ModelAndView NewsbaiduSeven(HttpServletRequest request,HttpServletResponse response){
		/*	String user_reg_mobile=request.getParameter("user_reg_mobile");*/
			ModelAndView mv = new ModelAndView((SiteOEM.getSOEM().isMobile()?"m/":"")+"/news/Newsbaidu/NewsbaiduSeven");
			return mv;
	}
	@RequestMapping(value="NewsbaiduEight")
	public ModelAndView NewsbaiduEight(HttpServletRequest request,HttpServletResponse response){
		/*	String user_reg_mobile=request.getParameter("user_reg_mobile");*/
			ModelAndView mv = new ModelAndView((SiteOEM.getSOEM().isMobile()?"m/":"")+"/news/Newsbaidu/NewsbaiduEight");
			return mv;
	}
}
