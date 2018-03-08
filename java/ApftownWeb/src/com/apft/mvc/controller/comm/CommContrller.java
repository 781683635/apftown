package com.apft.mvc.controller.comm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apft.core.AjaxJson;
import com.apft.core.DBCache;
import com.apft.mvc.dao.CommDao;
import com.apft.mvc.model.TbChinaAreaEntity;
import com.apft.mvc.service.CommService;
import com.apft.utils.SessionUtil;
import com.apft.utils.StringUtil;



@Controller
@RequestMapping("/comm")
public class CommContrller {
	
	@Autowired
	private CommDao dao;
	
	   
	@Autowired
	private CommService commService;
	
	

	@RequestMapping(value="qsql")
	@ResponseBody
	public AjaxJson qsql(HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Map<String, Object>> datalist = null;
		String cl = request.getParameter("cl");
		String tb = request.getParameter("tb");
		String st = request.getParameter("st");
		
		String pageNum = request.getParameter("pageNum");
		String numPerPage = request.getParameter("pageSize");
		
		String strSQL = "select "+cl+" from "+tb+" where "+ st;
		
		if(null != cl && cl.length() > 0 
				&& null != tb && tb.length() > 0
				&& null != st && st.length() > 0
				)
		{
			//总记录数
			Integer totalCount = 0;
			//第几页
			Integer pageNum2 = 0;
			//每页多少记录
			Integer pageSize = 0;
			//第几页不为空，就为当前的页数
			if(!StringUtil.isNull(pageNum)){
				pageNum2 = Integer.parseInt(pageNum);
			  //每页多少记录不为空，就是分页记录，否则就是8个记录条数
				if(!StringUtil.isNull(numPerPage))
					pageSize = Integer.parseInt(numPerPage);
				else
					pageSize = 8;
				
				if(st.indexOf("limit") < 0 && st.indexOf("LIMIT") < 0 ){
					
					String stsql="select count(*) from ("+strSQL+") A";
					
					totalCount = dao.queryForCount(stsql, 0);
					
					map.put("totalCount", totalCount);
				}
				map.put("pageNum", pageNum2);
				map.put("pageSize", pageSize);
			}
			
			if(pageNum2 != 0 && pageSize != 0)
				datalist = (List<Map<String, Object>>) DBCache.getInstance().get(strSQL+" limit "+pageNum2+","+pageSize);
			else
				datalist = (List<Map<String, Object>>) DBCache.getInstance().get(strSQL);
			
			if (null == datalist){
				
				if(pageNum2 != 0 && pageSize != 0 && st.indexOf("limit") < 0 && st.indexOf("LIMIT") < 0)
					datalist = dao.PagingQueryForList(strSQL, pageNum2, pageSize, 0);
				else
					datalist = dao.queryForList(strSQL, 0);
				
				DBCache.getInstance().set(strSQL, datalist);
			}
			map.put("datalist", datalist);
		}
		
		map.put("tbUser", SessionUtil.getSessionUser());
		
		j.setAttributes(map);
		return j;
	}
	
	
	/**
	 * 认证选择地区
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "chinaArea")
	@ResponseBody
	public AjaxJson getChinaArea(HttpServletRequest request,
			HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		j.setSuccess(false);
		
		String parentid = request.getParameter("parentid");
		if(null != parentid && parentid.length() > 0){
			List<TbChinaAreaEntity> tbChinaAreaEntitys = commService.chinaArea(parentid);
			
			j.setObj(tbChinaAreaEntitys);
			j.setSuccess(true);
		}
		return j;
	}
	
	
	@RequestMapping(value = "resProp")
	@ResponseBody
	public AjaxJson getResProp(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		j.setSuccess(false);
		
		String parentcode =request.getParameter("parentcode");
		if(null != parentcode && parentcode.length() > 0){
			List<Map<String, Object>> resProplst = commService.proplst("200000", Integer.parseInt(parentcode));
			
			j.setObj(resProplst);
			j.setSuccess(true);
		}
		return j;
	}
	
}
