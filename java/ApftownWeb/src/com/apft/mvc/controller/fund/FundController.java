package com.apft.mvc.controller.fund;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.apft.mvc.service.CommService;
import com.apft.mvc.service.ResService;
import com.apft.utils.SiteOEM;


@Controller
@RequestMapping("f")
public class FundController {
	
	

	
	@Autowired
	private ResService resService;
	
	@Autowired
	private CommService commService;
	
	
	@RequestMapping(value="index")
	public ModelAndView fundIndex(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="pageNum",defaultValue="1")Integer pageNum,
			@RequestParam(value="pageSize",defaultValue="12")Integer pageSize,
			@RequestParam(value="propCode",defaultValue="2001")Integer propCode){
		ModelAndView mv = new ModelAndView((SiteOEM.getSOEM().isMobile()?"m/":"")+"/fund/fundIndex");
		request = resService.queryChildIndex(request,pageNum,pageSize,"200000",propCode,10);
		List<Map<String, Object>> listMap1 = commService.proplst("200000", 2);
		List<Map<String, Object>> listMap0 = resService.queryIndex("200000", 2, 0,0,0);
		List<Map<String, Object>> listMap201 = resService.queryIndex("200000", 2, 201,0,0);
		mv.addObject("listMap0", listMap0);
		mv.addObject("listMap1", listMap1);
		mv.addObject("listMap201", listMap201);
		mv.addObject("propCode", propCode);
		return mv;
	}
	
	
}
