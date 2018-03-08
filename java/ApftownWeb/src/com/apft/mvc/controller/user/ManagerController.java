package com.apft.mvc.controller.user;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.apft.core.AjaxJson;
import com.apft.mvc.dao.CommDao;
import com.apft.mvc.model.TbResEntity;
import com.apft.mvc.model.TbUserEntity;
import com.apft.mvc.service.BaseService;
import com.apft.mvc.service.CommService;
import com.apft.mvc.service.ResService;
import com.apft.mvc.service.UserService;
import com.apft.utils.SessionUtil;
import com.apft.utils.SiteOEM;
import com.apft.utils.StringUtil;

@Controller
@RequestMapping("user")
public class ManagerController {

	@Autowired
	CommDao commDao;
	
	@Autowired
	ResService resService;
	
	@Autowired
	BaseService baseService;
	
	@Autowired
	CommService commService;
	@Autowired
	private UserService userService;
	
	
	/**
	 * 发布新闻
	 * @param request
	 * @param response
	 * @return
	 */
    @RequestMapping(value="resAdd")
	public ModelAndView newsAdd(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav=new ModelAndView("/user/resAdd");
		
		Map<String, Object> language=baseService.getLg();
		String lg=(String) language.get("reslg");
		String lang=(String) language.get("reslang");
		mav.addObject("lg", lg);
		mav.addObject("lang", lang);
		TbResEntity newsList=resService.resInfo(request);
		request.setAttribute("newsList", newsList);
		return mav;
	}
    
    /**
     * 新闻列表查询
     * @param request
     * @param response
     * @param pageNum
     * @param pageSize
     * @return
     */
	@RequestMapping(value="resList")
	public ModelAndView newList(HttpServletRequest request,HttpServletResponse response
			,@RequestParam(value="pageNum", defaultValue="1")Integer pageNum,
			@RequestParam(value="pageSize", defaultValue="10")Integer pageSize){
		ModelAndView mav=new ModelAndView("/user/resList");
		
		List<Map<String, Object>> parentcode = commService.proplst("200000",0);
		mav.addObject("parentcode", parentcode);
		
		String code=request.getParameter("code");
		if(StringUtil.isNull(code)){
			code="-1";
		}
		request = resService.resList(request, "200000", pageNum, pageSize,Integer.parseInt(code), 0);
        
		request.setAttribute("code2", code);
		
		mav.addObject("pageNum", pageNum);
		mav.addObject("pageSize", pageSize);
		return mav;
	}
	
	/**
	 * top管理
	 * @param request
	 * @param response
	 * @param pageNum
	 * @param pageSize
	 * @param cat
	 * @param bk
	 * @return
	 */
	@RequestMapping(value="top")
	public ModelAndView topMange(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="pageNum", defaultValue="1")Integer pageNum,
			@RequestParam(value="pageSize", defaultValue="2")Integer pageSize,
			@RequestParam(value="catCentre", defaultValue="0")Integer cat,
			@RequestParam(value="bkCentre", defaultValue="0")Integer bk){
		ModelAndView mv = new ModelAndView("/user/topMange");
		List<Map<String, Object>> listMap = resService.queryIndex(request,"200000", cat, bk, pageNum, pageSize);
		mv.addObject("listMap", listMap);
		mv.addObject("pageNum", pageNum);
		mv.addObject("pageSize", pageSize);
		mv.addObject("cat", cat);
		mv.addObject("bk", bk);
		return mv;
	}
	
	/**
	 * 报名信息
	 * @param request
	 * @param response
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	
	  @RequestMapping(value="dataList")
	  public ModelAndView dataList(HttpServletRequest request,HttpServletResponse response,
			  @RequestParam(value="pageNum",defaultValue="1")Integer pageNum,
			  @RequestParam(value="pageSize",defaultValue="7")Integer pageSize,
			  @RequestParam(value="code",defaultValue="3")String code){
			 request=userService.queryDateList(request, pageNum, pageSize, code);
			  return new ModelAndView("/user/dataList");
	  }
	  
	/*@RequestMapping(value="dataList")
	public ModelAndView datalist(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="pageNum", defaultValue="1")Integer pageNum,
			@RequestParam(value="pageSize", defaultValue="12")Integer pageSize){
		String sql = "SELECT GROUP_CONCAT( (case ds.label WHEN 'mobile' THEN '联系方式' WHEN 'name' THEN '姓名' WHEN 'comName' THEN '公司名称' WHEN 'remark' THEN '描述' ELSE ds.label END),':',ds.`value` ORDER BY ds.label DESC)content "+
					 "FROM tb_data_submit ds GROUP BY ds.submit_no";
		String sqlc = "SELECT COUNT(DISTINCT ds.submit_no) FROM tb_data_submit ds";
		int totalCount = commDao.queryForCount(sqlc, 0);
		List<Map<String, Object>> datalist = commDao.PagingQueryForList(sql, pageNum, pageSize, 0);
		request.setAttribute("datalist", datalist); 
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("totalCount", totalCount);
		return new ModelAndView("/user/dataList");
	}*/
	
	
	/**
	 * 更新状态
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="updateRes")
	@ResponseBody
	public AjaxJson newsUpdate(HttpServletRequest request, HttpServletResponse response){
		AjaxJson aj=new AjaxJson();
		Map<String, Object> map=new HashMap<String, Object>();
		Boolean status = false;
	    int count=resService.updateres(request); 
		if(count>0){
			status=true;
		}
		
		map.put("status", status);
		map.put("count", count);
		aj.setAttributes(map);
		return aj;
	}
	
	/**
	 * 用户关注
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/userAuthen")
	public ModelAndView userAuthen(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav=new ModelAndView("/user/userAuthen");
		
		String sms6 = StringUtil.getRandomString(6);
		//将产生的6位验证码存入session,kqum
		request.getSession().setAttribute("randomSMS", sms6);
		TbUserEntity ssUser=SessionUtil.getSessionUser();
		mav.addObject("ssUser", ssUser);
		return mav;
	}
	
	/**
	 * 校验旧密码
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/checkOldPwd")
	@ResponseBody
	public boolean checkOldPwd(HttpServletRequest request,HttpServletResponse response){
		String oldPwd=request.getParameter("oldPwd");
		String sql="select count(*) from tb_user where user_pwd='"+PasswordUtil.encrypt(oldPwd)+"'";
		
		int count=commDao.queryForCount(sql, 0);
		boolean ckPwd=false;
		if(count>0){
			ckPwd=true;
		}
		return ckPwd;
	}
	/**
	 * 修改密码
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "updateuserpwd")
	@ResponseBody
	public AjaxJson updateuserpwd(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson aj = new AjaxJson();
		String resetPw = request.getParameter("resetPw");
		
		if(!StringUtil.isNull(resetPw)){
			resetPw = PasswordUtil.encrypt(resetPw);
			
			TbUserEntity ssUser=SessionUtil.getSessionUser();
			if(null != ssUser && null != ssUser.getId()){
				
				String sql = "update tb_user set user_pwd='" + resetPw + "' where id='"+ ssUser.getId() + "'";
				int i = commDao.update(sql);
				
				aj.setObj(i);
			}
		}else{
			aj.setObj(-1);
		}
		return aj;
	}
	
	
	@RequestMapping(value = "passwd")
	@ResponseBody
	public AjaxJson passwd(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson aj = new AjaxJson();
		String passUpwd = request.getParameter("passUpwd");
		if(!StringUtil.isNull(passUpwd)){
			passUpwd = PasswordUtil.encrypt(passUpwd);
			TbUserEntity ssUser=SessionUtil.getSessionUser();
			String sql="";
		if(null != ssUser && null != ssUser.getId()){
				sql="SELECT COUNT(*) FROM tb_user AS u WHERE u.id='"+ssUser.getId()+"'  and u.user_pwd='"+passUpwd+"'";
			}
		int count=commDao.queryForCount(sql, 0);
	    if(count>0){
			aj.setObj(count);
	       }
		}else{
			aj.setObj(-1);
		}
		return aj;
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @param ptUser
	 * @param type		type="userImg":代表修改用户头像
	 * @return
	 */
	@RequestMapping(value="setUserInfo")
	@ResponseBody
	public AjaxJson setUserInfo(HttpServletRequest request, HttpServletResponse response,TbUserEntity ptUser,String type) {
		AjaxJson aj=new AjaxJson();
		TbUserEntity ssUser=SessionUtil.getSessionUser();
		
		List<Object> lstPara = new ArrayList<Object>();
		
		lstPara.add(ssUser.getId());
		if("usImg".equals(type) && !StringUtil.isNull(ptUser.getUserImg())){ 
			lstPara.add(6);
			lstPara.add(ptUser.getUserImg());
			lstPara.add(null);		
			ssUser.setUserImg(ptUser.getUserImg());
		}else if("usMobile".equals(type) && !StringUtil.isNull(ptUser.getUserRegMobile())){ 
			lstPara.add(1);
			lstPara.add(ptUser.getUserRegMobile());
			lstPara.add(null);		
			ssUser.setUserImg(ptUser.getUserRegMobile());
		}
		lstPara.add("ret");
		List<Object> result = commDao.callProc("pc_set_user_status", lstPara, 1);
		if(result.size()>0 && Integer.parseInt(result.get(0).toString())>=0 ){
			TbUserEntity tbUser = null;
			try {
				tbUser = (TbUserEntity) commDao.queryForEntity("select * from tb_user where id='"+ssUser.getId()+"'", TbUserEntity.class, -1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(null != tbUser)
				SessionUtil.setSessionUser(tbUser);
			aj.setMsg(result.get(0).toString());
			aj.setSuccess(true);
		}
		return aj;
		}
	
	
	@RequestMapping(value="/binding1")
	public ModelAndView binding1(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav=new ModelAndView("/user/binding1");
		return mav;
	}
	@RequestMapping(value="/binding-1")
	public ModelAndView binding(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav=new ModelAndView("/user/binding-1");
		return mav;
	}
	@RequestMapping(value="/zTop")
	public AjaxJson zTop(HttpServletRequest request,HttpServletResponse response){
		AjaxJson aj=new AjaxJson();
		Map<String, Object> map=new HashMap<String, Object>();
	     String id=request.getParameter("id");
	     String sql="update tb_res_top AS t set t.update_time=now() where t.id='"+id+"' order by t.update_time desc";
	     int count=commDao.update(sql);
	     boolean msg=false;
	     if(count>0){
	       msg=true;
	     }
	     map.put("msg", msg);
	     aj.setAttributes(map);
	     return aj;
	}
	/**
	 * 根据code查询
	 * @param request
	 * @param response
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
   @RequestMapping(value="selCode")
   public ModelAndView selCode(HttpServletRequest request,HttpServletResponse response,
		   @RequestParam(value="pageNum",defaultValue="1")Integer pageNum,
			@RequestParam(value="pageSize",defaultValue="2")Integer pageSize){
	   String Code=request.getParameter("selectCode");
	   String userId = (String) SessionUtil.getSessionUser().getId();
	   request = userService.queryAtten(request,pageNum,pageSize, userId, 110,Code);
	   return new ModelAndView("redirect:/user/atten.do");
   }

  
  /**
   * 
   * @param request 用户入园服务
   * @param response
   * @return
   */
  @RequestMapping(value="/UintoPark")
  
  public ModelAndView UintoPark(HttpServletRequest request,HttpServletResponse response){ 
	  ModelAndView mv = new ModelAndView((SiteOEM.getSOEM().isMobile()?"m/":"")+"/user/UintoPark");
	  TbUserEntity tbUser = SessionUtil.getSessionUser();
		String id = null;
		if(tbUser != null){
			id = tbUser.getId();
  		}
		request=userService.selUpstatus(request,id);
		return mv;
  }
  
  @RequestMapping(value="/phintoPark")
  
  	public ModelAndView pintoPark(HttpServletRequest request,HttpServletResponse response,
  		  @RequestParam(value="pageNum",defaultValue="1")Integer pageNum,
		  @RequestParam(value="pageSize",defaultValue="7")Integer pageSize){ 
	  request=userService.querypintoPark(request, pageNum, pageSize);
	  ModelAndView mv = new ModelAndView((SiteOEM.getSOEM().isMobile()?"m/":"")+"/user/phintoPark");
		return mv;
  	}
	  /**
	   * 更改入园流程状态
	   * @param request
	   * @param response
	   * @return
	   */
	  @RequestMapping(value="/updateComp")
	  @ResponseBody
	  public AjaxJson updateComp(HttpServletRequest request,HttpServletResponse response){
		 int count=resService.updateComp(request);
		 AjaxJson aj=new AjaxJson();
		 if(count>0){ 
			 aj.setMsg("操作成功");
		 }else{
			 aj.setMsg("操作失败");
		 }
		 return aj;
	  }
	  @RequestMapping(value="Fbainfo")
		public ModelAndView regFbainfo2(HttpServletRequest request,HttpServletResponse response){
		  TbUserEntity tbUser = null;
		  tbUser =(TbUserEntity) request.getSession().getAttribute("tbUserRegister");
		  if(tbUser==null){
				tbUser = SessionUtil.getSessionUser();
			}
			String moblie=tbUser.getUserRegMobile();
			request=resService.upFundInfo(moblie,request);
			ModelAndView mv = new ModelAndView((SiteOEM.getSOEM().isMobile()?"m/":"")+"/user/Fbainfo");
			return mv;
		}
	  	@RequestMapping(value="upCompInfo")
		public ModelAndView upCompInfo(HttpServletRequest request,HttpServletResponse response){
	  		request=resService.upMInfo(request);
			ModelAndView mv = new ModelAndView((SiteOEM.getSOEM().isMobile()?"m/":"")+"/user/upCompInfo");
			return mv;
		}
}



