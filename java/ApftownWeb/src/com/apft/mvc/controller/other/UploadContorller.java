package com.apft.mvc.controller.other;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.apft.core.ApplicationContextUtil;
import com.apft.mvc.model.TbUserEntity;
import com.apft.utils.SessionUtil;
import com.apft.utils.ZToken;

@Controller
@RequestMapping(value="/user")
public class UploadContorller {
	
	
	@RequestMapping(value="/upload")
	public ModelAndView upload(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("/fileUpload/upload"); 
		/*TbUserEntity user = SessionUtil.getSessionUser();
		if (user == null) {
			ZToken zt = ApplicationContextUtil.getContext().getBean(ZToken.class);
			user = zt.signUserToken(request, response);
		}
		String regName = user.getRegName();
		request.setAttribute("regName", regName);*/
		return mv;
	}

	
	@RequestMapping(value="listfile")
	public ModelAndView listfile(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("/fileUpload/listfile");
		return mv;
	} 

	@RequestMapping(value="message")
	public ModelAndView message(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("/fileUpload/message");
		return mv;
	} 
	
}
