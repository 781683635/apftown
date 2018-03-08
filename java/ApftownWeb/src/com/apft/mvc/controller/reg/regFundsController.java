package com.apft.mvc.controller.reg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecgframework.core.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.apft.core.AjaxJson;
import com.apft.core.ApplicationContextUtil;
import com.apft.mvc.dao.CommDao;
import com.apft.mvc.model.TbUserEntity;
import com.apft.mvc.service.ResService;
import com.apft.utils.SessionUtil;
import com.apft.utils.SiteOEM;
import com.apft.utils.StringUtil;
import com.apft.utils.ZLUtils;
import com.apft.utils.ZToken;

@Controller
public class regFundsController {

	@Autowired
	CommDao commDao;
	@Autowired
	ResService resService;
	
	@RequestMapping(value="regFphone")
	public ModelAndView regFphone(HttpServletRequest request,HttpServletResponse response){
		ZToken zt = ApplicationContextUtil.getContext().getBean(ZToken.class);
		zt.removeToken(request, response, zt.ZTOKEN_USER_KEY, null);
		SessionUtil.removeSession(SessionUtil.KEY_USER);
		String sms6 = StringUtil.getRandomString(6);
		request.getSession().setAttribute("randomSMS", sms6);
		ModelAndView mv = new ModelAndView((SiteOEM.getSOEM().isMobile()?"m/":"")+"/reg/regFphone");
		return mv;
	}
	/*@RequestMapping(value="/regCode?user_reg_mobile",method = RequestMethod.GET)
	
	public ModelAndView regCode(HttpServletRequest request,HttpServletResponse response,@RequestParam("user_reg_mobile")String user_reg_moblie){
		String user_reg_mobile=request.getParameter("user_reg_mobile");
		ModelAndView mv = new ModelAndView((SiteOEM.getSOEM().isMobile()?"m/":"")+"/reg/regFcode");
		return mv;
	}*/
	@RequestMapping(value="regCode")
	public ModelAndView regCode(HttpServletRequest request,HttpServletResponse response){
		String user_reg_email=request.getParameter("user_reg_moblie");
		TbUserEntity tbUser = new TbUserEntity();
		tbUser.setUserRegEmail(user_reg_email);
		request.getSession().setAttribute("tbUserRegister", tbUser);
		request.setAttribute("user_reg_email", user_reg_email);
		ModelAndView mv = new ModelAndView((SiteOEM.getSOEM().isMobile()?"m/":"")+"/reg/regFcode");
		return mv;	
	}
	@RequestMapping(value="regFpwd")
	public ModelAndView regFpwd(HttpServletRequest request,HttpServletResponse response){
		String userName=request.getParameter("userName");
		if(userName!=null){
			TbUserEntity tbUser = new TbUserEntity();
			tbUser.setUserName(userName);
			request.getSession().setAttribute("tbUserRegister", tbUser);
		}else{
			String userRegMobile=request.getParameter("user_reg_email");
			if(userRegMobile!=null){
				TbUserEntity tbUser = new TbUserEntity();
				tbUser.setUserRegMobile(userRegMobile);
				request.getSession().setAttribute("tbUserRegister", tbUser);
			}
		}
		ModelAndView mv = new ModelAndView((SiteOEM.getSOEM().isMobile()?"m/":"")+"/reg/regFpwd");
		return mv;
	}
	//注册
	@RequestMapping(value="regFsub")
	@ResponseBody
	public AjaxJson regFsub(HttpServletRequest request,HttpServletResponse response){
		AjaxJson aj=new AjaxJson();
		String regPwd=request.getParameter("password");
		String user_reg_email=request.getParameter("user_reg_email");
		TbUserEntity tbUser = (TbUserEntity) request.getSession().getAttribute("tbUserRegister");
		tbUser.setUserPwd(PasswordUtil.encrypt(regPwd));
		tbUser.setUserRegMobile(user_reg_email);
		List<Object> list = new ArrayList<Object>();
		list.add(tbUser.getUserName());
		list.add(tbUser.getUserRegMobile());
		list.add(null);
		list.add(tbUser.getUserPwd());
		list.add("0");
		list.add("apftown");
		list.add(null);
		list.add(ZLUtils.getIpAddr(request));
		list.add(null);
		list.add("ret");
		list.add("uid");
		List<Object> lst = commDao.callProc("pc_user_register", list, 2);
		String mes=null;
		int ret= Integer.parseInt( lst.get(0).toString());
		if(ret == 1){
			request.getSession().removeAttribute("randomSMS");
			
			String userId = (String) lst.get(1);
			String sql = "SELECT * FROM tb_user WHERE id = '"+userId+"'";
			try {
				TbUserEntity user = (TbUserEntity) commDao.queryForEntity(sql, TbUserEntity.class, 0);
				SessionUtil.setSessionUser(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
			mes="注册成功";
			aj.setMsg(mes);
		}else if(ret==-110){
				mes="用户名和别人的真实姓名重名,手机号已注册！注册失败";
				aj.setMsg(mes);
		}else{
				mes="注册失败,请重新注册！";
				aj.setMsg(mes);
		}
		return aj;
	}
	
	//登录
	@RequestMapping(value="regFlogin")
	@ResponseBody
	public AjaxJson regFlogin(HttpServletRequest request,HttpServletResponse response){
		AjaxJson aj=new AjaxJson();
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		if(!StringUtil.isNull(userName) && !StringUtil.isNull(password)){
			String userAgent = request.getHeader("user-agent");
			if (null != userAgent && userAgent.length() > 1000) {
				userAgent = userAgent.substring(0, 1000);
			}
		
			List<Object> lstPara = new ArrayList<Object>();
			lstPara.add(userName);
			lstPara.add(PasswordUtil.encrypt(password));
			lstPara.add(ZLUtils.getIpAddr(request));
			lstPara.add(userAgent);
			lstPara.add("ret");
			lstPara.add("uid");
			List<Object> result = commDao.callProc("pc_user_signin", lstPara, 2);

			int code = Integer.parseInt(result.get(0).toString());
			Map<String, Object> map = new HashMap<String, Object>();
			if (code == 0 || code == 1) {
				String userId = (String) result.get(1);
				TbUserEntity user = (TbUserEntity) commDao.queryForObject("select * from tb_user where id='" + userId + "'", TbUserEntity.class, 0);
				SessionUtil.setSessionUser(user);
			}
			map.put("code", code);
			aj.setAttributes(map);
		}

		return aj;
	}
	
	@RequestMapping(value="regFtabinpark")
	public ModelAndView regFtabinpark(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView((SiteOEM.getSOEM().isMobile()?"m/":"")+"/reg/regFtabinpark");
		return mv;
	}
	@RequestMapping(value="regFpolicy")
	public ModelAndView regFpolicy(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView((SiteOEM.getSOEM().isMobile()?"m/":"")+"/reg/regFpolicy");
		return mv;
	}
	@RequestMapping(value="regFservice")
	public ModelAndView regFservice(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView((SiteOEM.getSOEM().isMobile()?"m/":"")+"/reg/regFservice");
		return mv;
	}
	@RequestMapping(value="regFfail")
	public ModelAndView regFfail(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView((SiteOEM.getSOEM().isMobile()?"m/":"")+"/reg/regFfail");
		return mv;
	}
	@RequestMapping(value="regFsuccess")
	public ModelAndView regFsuccess(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView((SiteOEM.getSOEM().isMobile()?"m/":"")+"/reg/regFsuccess");
		return mv;
	}
	@RequestMapping(value="regFshare")
	public ModelAndView regFshare(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView((SiteOEM.getSOEM().isMobile()?"m/":"")+"/reg/regFshare");
		return mv;
	}
	
}
