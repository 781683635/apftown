package com.apft.mvc.controller.other;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.apft.core.ApplicationContextUtil;
import com.apft.utils.LogParseAct;



@Controller
@Scope("prototype")
public class LogActController {

	
	@RequestMapping(value = "saveActlog")
	public void saveActlog() {
		//存 日志  tb_user_act_log
		LogParseAct actlog = ApplicationContextUtil.getContext().getBean(LogParseAct.class);
		actlog.doUserAct();
		
	}
	
	
}
