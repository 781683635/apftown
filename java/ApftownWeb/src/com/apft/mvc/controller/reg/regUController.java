package com.apft.mvc.controller.reg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.apft.core.ApplicationContextUtil;
import com.apft.mvc.dao.CommDao;
import com.apft.mvc.model.TbUserEntity;
import com.apft.mvc.service.ResService;
import com.apft.utils.SessionUtil;
import com.apft.utils.SiteOEM;
import com.apft.utils.ZToken;

@Controller
@RequestMapping("/user")
public class regUController {
	@Autowired
	CommDao commDao;
	@Autowired
	ResService resService;
	
	@RequestMapping(value="regFbainfo2")
	public ModelAndView regFbainfo2(HttpServletRequest request,HttpServletResponse response){
		TbUserEntity tbUser = null;
		tbUser =(TbUserEntity) request.getSession().getAttribute("tbUserRegister");
		if(tbUser==null){
			tbUser = SessionUtil.getSessionUser();
			if(tbUser!=null){
			ZToken zt = ApplicationContextUtil.getContext().getBean(ZToken.class);
			tbUser = zt.signUserToken(request, response);
			}
		}
		String moblie=tbUser.getUserRegMobile();
		request=resService.upFundInfo(moblie,request);
		ModelAndView mv = new ModelAndView((SiteOEM.getSOEM().isMobile()?"m/":"")+"/reg/regFbainfo2");
		return mv;
	}
	
	@RequestMapping(value="regFmaininfo")
	public ModelAndView regFmaininfo(HttpServletRequest request,HttpServletResponse response){
		TbUserEntity tbUser = null;
		tbUser =(TbUserEntity) request.getSession().getAttribute("tbUserRegister");
		if(tbUser==null){
			tbUser = SessionUtil.getSessionUser();
			/*ZToken zt = ApplicationContextUtil.getContext().getBean(ZToken.class);
			tbUser = zt.signUserToken(request, response);*/
		}
		String moblie=tbUser.getUserRegMobile();
		request=resService.upFundInfo(moblie,request);
		ModelAndView mv = new ModelAndView((SiteOEM.getSOEM().isMobile()?"m/":"")+"/reg/regFmaininfo");
		return mv;
	}

}
