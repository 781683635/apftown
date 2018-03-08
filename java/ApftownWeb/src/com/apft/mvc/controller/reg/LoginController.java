package com.apft.mvc.controller.reg;

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
import com.apft.mvc.model.TbUserPersonalEntity;
import com.apft.utils.SessionUtil;
import com.apft.utils.StringUtil;
import com.apft.utils.ZLUtils;
import com.apft.utils.ZToken;

@Controller
public class LoginController {

	@Autowired
	CommDao commDao;

	
	@RequestMapping(value = "/loginui")
	public ModelAndView loginui(HttpServletRequest request, HttpServletResponse response) {
		
		if (SessionUtil.getSessionUser() != null) {
			return new ModelAndView("index.do");
		}
		return new ModelAndView("/reg/loginui");
	}

	@RequestMapping(value = "/login")
	@ResponseBody
	public AjaxJson login(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson aj = new AjaxJson();

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String rememberMe = request.getParameter("rememberMe");

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
				if ("on".equals(rememberMe)) {
					ZToken zt = ApplicationContextUtil.getContext().getBean(ZToken.class);
					String cos = zt.writeToken(request, response, zt.ZTOKEN_USER_KEY, userId);
				}
			}
			map.put("code", code);
			aj.setAttributes(map);
		}

		return aj;
	}

	@RequestMapping(value = "logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		ZToken zt = ApplicationContextUtil.getContext().getBean(ZToken.class);
		zt.removeToken(request, response, zt.ZTOKEN_USER_KEY, null);
		SessionUtil.removeSession(SessionUtil.KEY_USER);
		return "redirect:/index.do";
	}

	public TbUserEntity setUserAllUnits(HttpServletRequest request, HttpServletResponse response, String userId, String compId, String signType){
		ZToken token = ApplicationContextUtil.getContext().getBean(ZToken.class);
		//根据user获取token登录身份
		
		TbUserEntity user = null;
		if(signType != null && (signType == "2" || signType.equals("2"))){
			TbUserPersonalEntity tbUPers = (TbUserPersonalEntity) commDao.queryForObject("SELECT * FROM tb_user WHERE id = '"+userId+"'", TbUserPersonalEntity.class,0);
			user = (TbUserEntity) commDao.queryForObject("select * from tb_user where id='"+compId+"'", TbUserEntity.class, 0);
			Map<String, Object> catMap = commDao.queryForMap("SELECT id, cat FROM tb_user_role WHERE user_id = '"+userId+"' AND company_id = '"+compId+"' AND status = '300'",0);
			tbUPers.setCat(Integer.parseInt(catMap.get("cat").toString()));
			String roleLst = "";
			List<Map<String,Object>> eventLst = null;
			if(catMap.get("cat").toString().equals("0")){
				eventLst = commDao.queryForList("SELECT url FROM tb_user_role_event WHERE type = 0 ",0);
			}else{
				eventLst = commDao.queryForList("SELECT url FROM tb_user_role_event re, tb_user_role_event_ln el WHERE re.id = el.event_id AND el.role_id = '"+catMap.get("id").toString()+"' AND el.status = 0 ",0);
			}
			if(eventLst.size()>0){
				for(Map<String,Object> m : eventLst){
					roleLst += m.get("url")+",";
				}
				tbUPers.setRole(roleLst.substring(0, roleLst.length()-1));
			}
			user.setTbUserPersonalEntity(tbUPers);
		}else{
			signType = "1";
			user = (TbUserEntity) commDao.queryForObject("select * from tb_user where id='"+userId+"'", TbUserEntity.class, 0);
		}
		if(compId != null && !compId.equals("")){
			user.setUserComp(compId);
			commDao.update("UPDATE tb_user_role SET signin_type = '"+signType+"' WHERE user_id = '"+userId+"' AND company_id = '"+compId+"'");
		}
		//将user登录身份写入token
		token.writeSignType(request, response, userId, Integer.parseInt(signType));
		//将用户写入session
		SessionUtil.setSessionUser(user);
		return user;
	}
	
	
}
