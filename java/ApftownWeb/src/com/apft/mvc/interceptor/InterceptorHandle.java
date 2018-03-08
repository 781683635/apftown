package com.apft.mvc.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.apft.core.ApplicationContextUtil;
import com.apft.mvc.model.TbUserEntity;
import com.apft.mvc.service.OtherService;
import com.apft.utils.SessionUtil;
import com.apft.utils.SiteOEM;
import com.apft.utils.StringUtil;
import com.apft.utils.ZToken;




public class InterceptorHandle implements HandlerInterceptor{

	
	@Autowired
	private OtherService otherService;
	
	
	
	
	private List<String> urlList;

	public List<String> getUrlList() {
		return urlList;
	}

	public void setUrlList(List<String> urlList) {
		this.urlList = urlList;
	}

	
	
	
	//请求完成之后执行
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	//Controller执行之后，返回视图之前执行
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	//请求处理之前执行
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		
		//获取原请求的url
		String targetUrl = request.getRequestURL().append("?").append(request.getQueryString()).toString();
		
   		
		//根据浏览器语言  ,设置网站中英版本
		HttpSession session1 = request.getSession();
		String sflg = (String) session1.getAttribute("SF_LG");
		if(StringUtil.isNull(sflg)){
			String requestGetLanguage = request.getLocale().getLanguage();
			if(requestGetLanguage.equals("zh")){
			  session1.setAttribute("SF_LG", "cn");	
			}else{
			  session1.setAttribute("SF_LG", "en");
			}
		}
		
		//获得请求
		String requestPath = request.getRequestURI() + "?" + request.getQueryString();
		//获得项目名称
		String path = request.getContextPath()+"/";
		
		if (requestPath.indexOf("&") > -1) {// 去掉其他参数
			requestPath = requestPath.substring(0, requestPath.indexOf("&"));
		}
		// 去掉项目路径
		requestPath = requestPath.substring(request.getContextPath().length());

		SiteOEM s_oem = SiteOEM.getSOEM(); 
		if (null == s_oem) 
			s_oem = new SiteOEM(request, response);		
		
		String strWebName = request.getServerName().toLowerCase();
		String url = request.getHeader("Referer");
//		System.out.println("strWebName==="+strWebName+",Referer----"+url);	
		if(!StringUtil.isEmpty(url) && !url.contains(strWebName))
			s_oem.setSite(strWebName);
		
		
		otherService.userAct(request, response, "", "");
		
		
		if(containUrl(requestPath)){
        	
        	TbUserEntity tbUserEntity = SessionUtil.getSessionUser();
        	if(tbUserEntity==null){
        		
        		ZToken tk = ApplicationContextUtil.getContext().getBean(ZToken.class);
    			tbUserEntity = tk.signUserToken(request, response);
    			
    			if(null != tbUserEntity){
    				SessionUtil.setSessionUser(tbUserEntity);
    				
    				//查询该用户的红点提醒
    				//Map<String, Object> tipsTotal = userTdService.tips(tbUserEntity.getId());
    				//request.getSession().setAttribute("tipsTotal", tipsTotal);
    			}else{
        		
	        		String strAccept = (String)request.getHeader("Accept");
	        		String strReferer = (String)request.getHeader("Referer");
	        		if (!StringUtil.isNull(strAccept) && strAccept.indexOf("application/json")>=0){
	        			SessionUtil.getSession().setAttribute("targetUrl", strReferer);
	        			response.getWriter().write("tosignin");
	        			return false;
	        		}
	        		//将访问的URL存入到SESSION中
            		SessionUtil.getSession().setAttribute("targetUrl", targetUrl);

            		response.sendRedirect(path+"loginui.do");
                	return false;
    			}
        	}else{
        		//查询该用户的红点提醒
				//Map<String, Object> tipsTotal = userTdService.tips(tbUserEntity.getId());
				//request.getSession().setAttribute("tipsTotal", tipsTotal);
        		return true;
        	}
        }
        return true; 
	}

	/**
	 * 判断拦截列表中的数据
	 * @param url
	 * @return
	 */
	private boolean containUrl(String url){
		//遍历url,判断是否存在
		for(String u: urlList)
			if(url.contains(u))
				return true;
		return false;
	}
	
}
