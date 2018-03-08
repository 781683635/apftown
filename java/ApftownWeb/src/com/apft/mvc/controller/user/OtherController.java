package com.apft.mvc.controller.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.apft.core.AjaxJson;
import com.apft.mvc.service.ResService;
import com.apft.mvc.service.UserService;
import com.apft.utils.SessionUtil;
import com.apft.utils.SiteOEM;

@Controller
@RequestMapping(value="/user")
public class OtherController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 
	 * 用户关注
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="atten")
	public ModelAndView attenui(HttpServletRequest request,HttpServletResponse response){
	/*	System.out.println((SiteOEM.getSOEM().isMobile()?"m/":"")+"user/userAtten");*/
		
		/*if(SiteOEM.getSOEM().isMobile()){
			
		   String userId = (String) SessionUtil.getSessionUser().getId();
		   request = userService.queryAtten(request,pageNum,pageSize, userId, 110,selectCode);
		   
		}*/
		//request.setAttribute("selectCode", request.getParameter("selectCode"));
		
		return new ModelAndView((SiteOEM.getSOEM().isMobile()?"m/":"")+"user/userAtten");
	}
	
	/**
	 * 关注的ajax
	 * @param request
	 * @param response
	 * @return
	 * 
	 */
	@RequestMapping(value="attenJson")
	@ResponseBody
	public AjaxJson attenJson(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="pageNum",defaultValue="1")Integer pageNum,
			@RequestParam(value="pageSize",defaultValue="2")Integer pageSize,
			@RequestParam(value="selectCode",defaultValue="1")String selectCode){
		AjaxJson json = new AjaxJson();
		String userId = (String) SessionUtil.getSessionUser().getId();
		System.out.println("attenJson.do===="+pageSize+"+++++"+selectCode);		
		request = userService.queryAtten(request,pageNum,pageSize, userId,110, selectCode);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("listMap", request.getAttribute("listMap"));
		map.put("pageNum", request.getAttribute("pageNum"));
		map.put("pageSize", request.getAttribute("pageSize"));
		map.put("totalCount", request.getAttribute("totalCount"));

		map.put("code", request.getAttribute("code"));
		json.setAttributes(map);
		return json;
	}
	
	@RequestMapping(value="userMsg")
	public ModelAndView userMsg(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="pageNum", defaultValue="1")Integer pageNum,
			@RequestParam(value="pageSize", defaultValue="4")Integer pageSize){
		ModelAndView mv =  new ModelAndView("user/userMsg");
		String userId = SessionUtil.getSessionUser().getId();
		request = userService.queryMsg(request, pageNum, pageSize, userId);
		return mv;
	}
	
	@RequestMapping(value="updateMsg")
	@ResponseBody
	public AjaxJson updateMsg(HttpServletRequest request,HttpServletResponse response){
		AjaxJson aj = new AjaxJson();
		int conut = userService.updateMsg(request);
		Boolean status = false;
		Map<String, Object> map = new HashMap<String, Object>();
		if(conut>0){
			status = true;
		}
		map.put("conut", conut);
		map.put("status", status);
		aj.setAttributes(map);
		return aj;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "invite")
	public ModelAndView invite(HttpServletRequest request,HttpServletResponse response){
		
		return new ModelAndView("user/invite");
	}
}
