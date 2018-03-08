package com.apft.mvc.controller.reg;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jeecgframework.core.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.apft.core.AjaxJson;
import com.apft.mvc.dao.CommDao;
import com.apft.mvc.model.TbUserEntity;
import com.apft.utils.StringUtil;



@Controller
public class BackPwdController {
	@Autowired
	CommDao commDao;

	@RequestMapping(value = "/forgetPwd")
	public ModelAndView forgetPwd(HttpServletRequest request, HttpServletResponse response) {
		// 短信验证码
		String sms6 = StringUtil.getRandomString(6);
		request.getSession().setAttribute("randomSMS", sms6);
		return new ModelAndView("/reg/forgetPwd");
	}

	/***
	 * mobile/email 存在返回true
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/existMoEm")
	@ResponseBody
	public boolean existMoEm(HttpServletRequest request, HttpServletResponse response) {
		String userMobile = request.getParameter("userMobile");
		String userEmail = request.getParameter("userEmail");
		boolean b1 = false;
			
		TbUserEntity tbUserRegister = null;
		try {
			String sql = "";
			if(!StringUtil.isNull(userMobile)){
				sql += " user_reg_mobile='"+ userMobile + "' ";
			}
			if(!StringUtil.isNull(userEmail)){
				sql += " user_reg_email='"+ userEmail + "' ";
			}
			
			if(!StringUtil.isNull(sql)){
				tbUserRegister = (TbUserEntity) commDao.queryForEntity("SELECT * FROM tb_user WHERE "+sql, TbUserEntity.class, 0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (null != tbUserRegister && null != tbUserRegister.getId()) {
			HttpSession session = request.getSession();
			session.setAttribute("tbUserRegister", tbUserRegister);
			b1 = true;
		}
		
		return b1;
	}

	
	@RequestMapping(value = "/setPwd")
	public ModelAndView setpwd(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/reg/setPwd");
		TbUserEntity tbUserRegister = (TbUserEntity) request.getSession().getAttribute("tbUserRegister");
		mav.addObject("tbUserRegister", tbUserRegister);
		return mav;
	}

	
	/**
	 * 重置更新密码
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "updatePwd")
	@ResponseBody
	public AjaxJson updatePwd(HttpServletRequest request,HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		j.setSuccess(false);
		
		TbUserEntity tbUser =(TbUserEntity) request.getSession().getAttribute("tbUserRegister");
		String user_pwd = request.getParameter("newpassword"); 
		
		if(null == tbUser){
			String userid = request.getParameter("userId");
			String username = request.getParameter("userName");
			String useremail = request.getParameter("userRegEmail");
			String sql = "1=1";
			if(null != userid && userid.length()>0)
				sql += " and id='"+userid+"' ";
			if(null != username && username.length()>0){
				sql += " and user_name='"+username+"' ";
			}				
			if(null != useremail && useremail.length()>0)
				sql += " and user_reg_email='"+useremail+"' ";
			
			
			if(!"1=1".equals(sql)){
				tbUser = (TbUserEntity) commDao.queryForObject("select * from tb_user where "+sql, TbUserEntity.class, 0);
			}
		}
		
		if(tbUser!=null){
			user_pwd = PasswordUtil.encrypt(user_pwd); 
			tbUser.setUserPwd(user_pwd);
			
			String upsql=" update tb_user set user_pwd='"+user_pwd+"' ";
			
			upsql += " where id='"+tbUser.getId()+"'";
			
			int upret = commDao.update(upsql);
			j.setObj(upret);
			if(upret >= 0)
				j.setSuccess(true);
		}
		
		return j;
	}
}