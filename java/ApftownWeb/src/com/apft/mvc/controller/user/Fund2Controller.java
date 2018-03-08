package com.apft.mvc.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.apft.utils.SiteOEM;


@Controller
@RequestMapping("user")
public class Fund2Controller {

	
	
	
	
	/**
	 *企业入驻 
	 */
	@RequestMapping(value="fInto")
	public ModelAndView fundInto(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView((SiteOEM.getSOEM().isMobile()?"m/":"")+"/fund/fundInto");
		return mv;
	}
	/**
	 *企业变更 
	 */
	@RequestMapping(value="fChange")
	public ModelAndView fundChange(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView((SiteOEM.getSOEM().isMobile()?"m/":"")+"/fund/fundChange");
		return mv;
	}
	/**
	 *外企迁入 
	 */
	@RequestMapping(value="fMove")
	public ModelAndView fundMove(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView((SiteOEM.getSOEM().isMobile()?"m/":"")+"/fund/fundMove");
		return mv;
	}
	/**
	 *纳税申报 
	 */
	@RequestMapping(value="fPay")
	public ModelAndView fundPay(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView((SiteOEM.getSOEM().isMobile()?"m/":"")+"/fund/fundPay");
		return mv;
	}
	
	/**
	 * 企业年检
	 */
	@RequestMapping(value="fAnnu")
	public ModelAndView fundAnnu(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView((SiteOEM.getSOEM().isMobile()?"m/":"")+"/fund/fundAnnu");
		return mv;
	}
	/**
	 * 企业备案
	 */
	@RequestMapping(value="fRec")
	public ModelAndView fundRec(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView((SiteOEM.getSOEM().isMobile()?"m/":"")+"/fund/fundRec");
		return mv;
	}
	
	/**
	 * 投资类企业政策
	 */
	@RequestMapping(value="fLayOut")
	public ModelAndView fundLayOut(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView((SiteOEM.getSOEM().isMobile()?"m/":"")+"/fund/fundLayOut");
		return mv;
	}
	/**
	 * 互联网金融政策
	 */
	@RequestMapping(value="fNet")
	public ModelAndView fundNet(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView((SiteOEM.getSOEM().isMobile()?"m/":"")+"/fund/fundNet");
		return mv;
	}
	/**
	 * 融资租赁企业政策
	 */
	@RequestMapping(value="fFina")
	public ModelAndView fundFina(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView((SiteOEM.getSOEM().isMobile()?"m/":"")+"/fund/fundFina");
		return mv;
	}
	/**
	 * 常见问题
	 */
	@RequestMapping(value="fQues")
	public ModelAndView fundQues(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView((SiteOEM.getSOEM().isMobile()?"m/":"")+"/fund/fundQues");
		return mv;
	}
	
}
