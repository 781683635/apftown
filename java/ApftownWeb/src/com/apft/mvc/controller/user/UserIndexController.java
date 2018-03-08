package com.apft.mvc.controller.user;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.apft.mvc.dao.CommDao;
import com.apft.mvc.model.TbUserEntity;
import com.apft.utils.SessionUtil;
import com.apft.utils.SiteOEM;


@Controller
@RequestMapping("/user")
public class UserIndexController {
	
	
	@Autowired
	private CommDao commDao;

	@RequestMapping(value = "/index")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response){
		
		TbUserEntity ssUser = SessionUtil.getSessionUser();
		request.setAttribute("tbUser", ssUser);
		if(null != ssUser){
			String logSQL = "SELECT r.id,r.`no`,r.title,r.img "+
					" FROM tb_res AS r INNER JOIN tb_user_act_log AS ulog ON ulog.rid = r.id "+
					" WHERE ulog.user_id='"+ssUser.getId()+"' AND ulog.act_type='news/info.do' limit 10";
			List<Map<String, Object>> loglist = commDao.queryForList(logSQL, 0);
			request.setAttribute("loglist", loglist);
		}
		
		return new ModelAndView((SiteOEM.getSOEM().isMobile()?"m/":"")+"user/index");
	}
}
