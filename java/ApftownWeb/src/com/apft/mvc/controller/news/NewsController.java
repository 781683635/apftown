package com.apft.mvc.controller.news;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.apft.mvc.dao.CommDao;
import com.apft.mvc.model.TbResEntity;
import com.apft.mvc.service.BaseService;
import com.apft.mvc.service.CommService;
import com.apft.mvc.service.CommentService;
import com.apft.mvc.service.ResService;
import com.apft.utils.SessionUtil;
import com.apft.utils.SiteOEM;
import com.apft.utils.StringUtil;

@Controller
@RequestMapping("n")
public class NewsController {
	
	
	@Autowired
	private ResService resService;
	
	@Autowired
	private BaseService baseService;
	
	@Autowired
	private CommService commService;
	
	@Autowired
	private CommentService commentService;
	
	
	@RequestMapping(value="/i")
	public ModelAndView newsInfo(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav=new ModelAndView("/news/newsInfo");
		Map<String, Object> language=baseService.getLg();
		String lg=(String) language.get("reslg");
		String lang=(String) language.get("reslang");
		Integer no= Integer.parseInt(request.getParameter("no"));
		if(no!=0){
			Map<String, Object> newsInfo = resService.newInfo("200000", no);
			mav.addObject("newsInfo", newsInfo); 
			int code= (Integer) newsInfo.get("code_val");
			List<Map<String,Object>> newslist=resService.newMap(code);
			request.setAttribute("newslist", newslist);
			request.setAttribute("propCode", newsInfo.get("code"));
			request.setAttribute("parentCode", newsInfo.get("code_val"));
			List<Map<String, Object>> commlst = commentService.getCommentList(newsInfo.get("id").toString(), 0);
			request.setAttribute("commlst", commlst);
			request.setAttribute("ssUser", SessionUtil.getSessionUser());
			
			mav.addObject("lg", lg);
			mav.addObject("lang", lang);
			return mav;
		}
		return new ModelAndView("redirect:/news/index.do");
	}
	
	@RequestMapping(value="index")
	public ModelAndView newsIndex(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="pageNum", defaultValue="1")Integer pageNum,
			@RequestParam(value="pageSize", defaultValue="12")Integer pageSize,
			@RequestParam(value="propCode",defaultValue="6001")Integer propCode){
		ModelAndView mv = new ModelAndView((SiteOEM.getSOEM().isMobile()?"m/":"")+"/news/newsIndex");
		request = resService.queryChildIndex(request,pageNum,pageSize,"200000",propCode,10);
		List<Map<String, Object>> listMap1 = commService.proplst("200000", 6);
		List<Map<String, Object>> listMap0 = resService.queryIndex("200000", 6, 0,0,0);
		List<Map<String, Object>> listMap201 = resService.queryIndex("200000", 6, 201,0,0);
		mv.addObject("listMap0", listMap0);
		mv.addObject("listMap1", listMap1);
		mv.addObject("listMap201", listMap201);	
		mv.addObject("propCode", propCode);
		return mv;
	}
	
}
