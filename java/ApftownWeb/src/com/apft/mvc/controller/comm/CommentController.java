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
import com.apft.mvc.model.TbUserEntity;
import com.apft.mvc.service.CommentService;
import com.apft.utils.SessionUtil;
import com.apft.utils.StringUtil;
import com.apft.utils.ZLUtils;



@Controller
@RequestMapping("/user")
public class CommentController {
	
	@Autowired
	private CommDao dao;
	
	@Autowired
	private CommentService commService;
	
	
	/**
	 * 保存评论
	 * @param comment	评论内容
	 * @param resId		评论哪个tb_res.id
	 * @param classid	评论级别
	 * @param parentid	回复的父级id
	 * @param type		评论分类 0:text, 1:html 10:点赞
	 * @return
	 */
	@RequestMapping(value = "saveComment")
	@ResponseBody
	public AjaxJson saveComment(HttpServletRequest request, HttpServletResponse response
			,String comment,String resId,String parentId,String uid2,String type){
		AjaxJson json = new AjaxJson();
		json.setSuccess(false);
		
		String catid = request.getParameter("catid");
		String attach = request.getParameter("attach");
		//保存评论
		int addRet = commService.saveComment(comment, resId, parentId, uid2, type, catid, attach);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Map<String, Object>> commlst = commService.getCommentList(resId, -1);
		TbUserEntity ssUser = SessionUtil.getSessionUser();
		
		map.put("commlst", commlst);
		map.put("ssUser", ssUser);
		
		json.setAttributes(map);
		json.setObj(addRet);
		return json;
	}
	
	
	/**
	 * 
	 * @param resId
	 * @param commentid
	 * @return
	 */
	@RequestMapping(value = "commentLike")
	@ResponseBody
	public AjaxJson commentlike(HttpServletRequest request, HttpServletResponse response,String resId,String commentId){
		AjaxJson json = new AjaxJson();
		
		Map<String, Object> comment = dao.queryForMap("select * from tb_res_comment where id='"+commentId+"' and res_id='"+resId+"'", 0);
		
		Boolean bl = DBCache.getInstance().getActTime(resId, "likes", request.getSession().getId());
		if(bl){
			int likes = Integer.parseInt(comment.get("user_likes").toString())+DBCache.getInstance().addCount("tb_res_comment", "user_likes", commentId);
			
			List<Map<String, Object>> commlst = commService.getCommentList(resId, 0);
			if(null != commlst){
				for (int i = 0; i < commlst.size(); i++) {
					if(commlst.get(i).get("id").equals(commentId)){
						commlst.get(i).put("user_likes", likes);
					}
				}
			}
			json.setObj(likes);
		}else{
			json.setObj(comment.get("user_likes"));
		}
		
		return json;
	}
	
	
	/**
	 * 
	 * @param resId
	 * @param commentid
	 * @return
	 */
	@RequestMapping(value = "commentDel")
	@ResponseBody
	public AjaxJson commentdel(HttpServletRequest request, HttpServletResponse response,String resId,String commentId){
		AjaxJson j = new AjaxJson();		
		j.setSuccess(false);
		
		TbUserEntity ssUser = SessionUtil.getSessionUser();
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(!StringUtil.isNull(resId) && !StringUtil.isNull(commentId)){
			
			int del = dao.delete("delete from tb_res_comment where id='"+commentId+"'");
			if(del>0){
				
				List<Map<String, Object>> commlst = commService.getCommentList(resId, -1);
				
				map.put("commlst", commlst);
				map.put("ssUser", ssUser);
			
				j.setAttributes(map);
				j.setSuccess(true);
			}
		}
		
		return j;
	}
	
	

	
	
	
	/***
	 * 点赞/关注
	 * @param resId
	 * @param type		310:点赞，320:关注
	 */
	@RequestMapping(value = "likes")
	@ResponseBody
	public AjaxJson likes(HttpServletRequest request,String resId,String type){
		AjaxJson j = new AjaxJson();
		j.setSuccess(false);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		TbUserEntity user = SessionUtil.getSessionUser();
		if(null != user && !StringUtil.isNull(resId)){
			
			int cnt = dao.queryForCount("select count(id) from tb_res_attention where (status="+type+" or status=-"+type+") and type="+type+" and res_id='"+resId+"' and user_id='"+user.getId()+"'", 0);
			if(cnt == 0){
				dao.update("insert into tb_res_attention(id,res_id,user_id,type,status,update_time) values ('"+ZLUtils.UUIDgenerate()+"', '"+resId+"', '"+user.getId()+"', "+type+", "+type+", now())");
			}else{
				dao.update("update tb_res_attention set status = "+type+",update_time=now() where res_id='"+resId+"' and user_id='"+user.getId()+"' and type="+type);
			}
			//String strSQL = "select count(1) from tb_res_attention att where att.res_id='"+resId+"' and att.type="+type+" and att.status="+type;
			int count = commService.getCommentCnt(resId, type);
			map.put("count",count);
			
			j.setAttributes(map);
			j.setSuccess(true);
		}
		
		return j;
	}


	
	/***
	 * 取消关注
	 * @param resId
	 * @param type
	 */
	@RequestMapping(value = "nolike")
	@ResponseBody
	public AjaxJson nolike(HttpServletRequest request,String resId,String type){
		AjaxJson j = new AjaxJson();
		j.setSuccess(false);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		TbUserEntity user = SessionUtil.getSessionUser();
		if(null != user && !StringUtil.isNull(resId)){
			
			String noSQL = "update tb_res_attention set status = '-"+type+"' where res_id='"+resId+"' and user_id='"+user.getId()+"' and type="+type;
			int upret = dao.update(noSQL);
			map.put("upret", upret);
			/*int ucolle = commService.getCommentCnt(resId, type);
			if(ucolle==0){
				map.put("count", ucolle);
			}else{
			}*/
			map.put("count", 0);
			j.setAttributes(map);
			j.setSuccess(true);
		}
		return j;
	}
	
	
	
	

}
