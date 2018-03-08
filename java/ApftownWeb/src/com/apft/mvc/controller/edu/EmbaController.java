package com.apft.mvc.controller.edu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("emba")
public class EmbaController {

	
	
	
	/**
	 * 报名须知
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="notice")
	public ModelAndView embaNotice(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView("/edu/embaNotice");
		return mv;
	}
	
	/**
	 * 课程体系
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="cursz")
	public ModelAndView embaCursz(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView("/edu/embaCursz");
		return mv;
	}
	
	/**
	 * 师资力量
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="teach")
	public ModelAndView embaTeach(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView("/edu/embaTeach");
		return mv;
	}
	
	/**
	 * 项目介绍
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="proi")
	public ModelAndView embaProi(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView("/edu/embaProi");
		return mv;
	}
	/**
	 * 进入emaba
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="Into")
	public ModelAndView embaInto(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView("/edu/embaInto");
		return mv;
	}
}
