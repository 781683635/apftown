package com.apft.mvc.controller.comm;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.apft.core.AjaxJson;
import com.apft.mvc.dao.CommDao;
import com.apft.mvc.model.TbUserEntity;
import com.apft.mvc.service.XFormSubmit;
import com.apft.utils.SessionUtil;
import com.apft.utils.StringUtil;
import com.apft.utils.ZLUtils;






@Controller
@RequestMapping("/")
public class FormSubmitController{

	@Autowired
	CommDao dao;
	
	@Autowired
	XFormSubmit xform;
	
	/***
	 * 
	 * @param r.id	只能代表 tb_res.id（切记，因为有删除语句）
	 * @return
	 */
	@RequestMapping(value = "xfm")
	@ResponseBody
	public AjaxJson savepub(HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		TbUserEntity tbUser = SessionUtil.getSessionUser();
		int retdel = -1;
		String resid = request.getParameter("r.id");
		if(!StringUtil.isNull(resid)){
			String sql = "delete from tb_res_prop_ln where res_id='"+resid+"'";
			retdel = dao.update(sql);
			j.setObj(retdel);
		}
		Map map = getParameterMap(request);
		System.out.println(map);
		String uid = null;
		if(tbUser != null)
		   uid = tbUser.getId();
		j.setObj(xform.saveOrUpdatgeFormListMap(dao, map,uid));
		return j;
	}
			
	public static Map getParameterMap(HttpServletRequest request) {
	    // 参数Map
	    Map properties = request.getParameterMap();
	    // 返回值Map
	    Map returnMap = new HashMap();
	    Iterator entries = properties.entrySet().iterator();
	    Map.Entry entry;
	    String name = "";
	    String value = "";
	    while (entries.hasNext()) {
	        entry = (Map.Entry) entries.next();
	        name = (String) entry.getKey();
	        Object valueObj = entry.getValue();
	        if(null == valueObj){
	            value = "";
	        }else if(valueObj instanceof String[]){
	            String[] values = (String[])valueObj;
	            for(int i=0;i<values.length;i++){
	                value = values[i] + ",";
	            }
	            value = value.substring(0, value.length()-1);
	        }else{
	            value = valueObj.toString();
	        }
	        returnMap.put(name, value);
	    }
	    return returnMap;
	}
	
	
	
	/***
	 * 提交信息
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/infoSub{id}")
	public ModelAndView infoSub(HttpServletRequest request, HttpServletResponse response
			,@PathVariable String id){
		TbUserEntity tbUser = SessionUtil.getSessionUser();
		String userId = null;
		if(tbUser != null)
			userId = tbUser.getId();
		request.setAttribute("userId", userId);
		return new ModelAndView("form/infoSub"+id);
	}
	
	
	
	@RequestMapping(value = "/subData")
	@ResponseBody
	public AjaxJson dataSub(HttpServletRequest request, HttpServletResponse response){
		AjaxJson j = new AjaxJson();
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		response.setContentType("text/html;charset=utf-8");
		
		String userId = "";
		TbUserEntity tbUser = SessionUtil.getSessionUser();
		if(null != tbUser){
			userId = tbUser.getId();
		}
		
		String resId = request.getParameter("resId");
		String catId = "100";
		
		String data = request.getParameter("data");
		String[] dataC = data.split("&");
		int ii=0;
		String submitNo = ZLUtils.UUIDgenerate();
		for(int i=1;i<dataC.length+1;i++){
			String[] sC = dataC[i-1].split("=");
			if(sC.length!=2 ){
				continue;
			}
			if("catId".equals(sC[0])){
				catId = sC[1];
				continue;
			}
			
			
			Map<String, Object> tblink = new HashMap();
			tblink.put("id", ZLUtils.UUIDgenerate());
			tblink.put("cat_id", catId);
			if(!StringUtil.isNull(userId))
				tblink.put("user_id", userId);
			if(!StringUtil.isNull(resId))
				tblink.put("res_id", resId);
			tblink.put("submit_no", submitNo);
			tblink.put("label", sC[0]);
			try {
				tblink.put("value", URLDecoder.decode(sC[1], "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		    ii = dao.insert("tb_data_submit", tblink);
		    
		    if(ii!=1)
		    	break;
		}
		j.setObj(ii);
		
		return j;
	}
	
}
