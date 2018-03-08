package com.apft.mvc.service;


import java.util.List;
import java.util.Map;


public interface CommentService {
	
	public List<Map<String, Object>> getCommentList(String resId, int cachaTime);
	
	
	/***
	 * 保存评论
	 * @param comment	评论内容
	 * @param resid		tb_res.id
	 * @param parentid	
	 * @param uid2
	 * @param type		评论分类 0:text, 1:html 10:点赞 
	 * @param catid		分类 0:评论，100:专家回答
	 * @param attach	附件
	 * @return
	 */
	public int saveComment(String comment,String resId,String parentId,String uid2,String type,String catId, String attach);
	
	
	
	/***
	 * 获取关注/ 总记录数
	 * @param resId
	 * @param type
	 * @return
	 */
	public int getCommentCnt(String resId, String type);
	
}
