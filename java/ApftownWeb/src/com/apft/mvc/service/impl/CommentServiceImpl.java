package com.apft.mvc.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apft.mvc.dao.CommDao;
import com.apft.mvc.model.TbUserEntity;
import com.apft.mvc.service.CommentService;
import com.apft.utils.SessionUtil;
import com.apft.utils.StringUtil;


@Service("commentService")
@Transactional
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommDao dao;
	
	
	@Override
	public List<Map<String, Object>> getCommentList(String resid, int cachaTime) {
		/*List<Map<String, Object>> list12 = (List<Map<String, Object>>) DBCache.getInstance().get("comment12"+resid);
		if(null == list12){
			String SQL12 = "SELECT co.*,u.user_img,u.user_name FROM tb_res_comment co,tb_user u WHERE co.user_id=u.id and res_id='"+resid+"' and length(class_id)<=6 ORDER BY class_id asc,insert_time DESC ";
			list12 = dao.queryForList(SQL12, 0);
			
			DBCache.getInstance().set("comment12"+resid, list12);
		}
		request.setAttribute("list12", list12);
		
		List<Map<String, Object>> list3 = (List<Map<String, Object>>) DBCache.getInstance().get("comment3"+resid);
		if(null == list3){
			String SQL3 = "SELECT co.*,u.user_img,u.user_name FROM tb_res_comment co,tb_user u WHERE co.user_id=u.id and res_id='"+resid+"' and length(class_id)>6 ORDER BY class_id asc,insert_time DESC ";
			list3 = dao.queryForList(SQL3, 0);
			
			DBCache.getInstance().set("comment3"+resid, list3);
		}
		request.setAttribute("list3", list3);*/
		
		
		String commsql = "SELECT co.*,DATE_FORMAT(co.insert_time,'%Y-%m-%d %T') tt,u.user_img,u.user_name FROM tb_res_comment co,tb_user u WHERE co.user_id=u.id and res_id='"+resid+"' ORDER BY class_id asc,insert_time DESC limit 50";
		List<Map<String, Object>> commlst = dao.queryForList(commsql, cachaTime);
		
		
		
		return commlst;
	}

	
	
	
	@Override
	public int saveComment(String comment,String resid,String parentid,String uid2,String type,String catid, String attach) {
		TbUserEntity user = SessionUtil.getSessionUser();
		if( null != user && (
				(!StringUtil.isNull(resid) && !StringUtil.isNull(comment)) || !StringUtil.isNull(attach)
			)
		){
			
			parentid = parentid == "" ? null : parentid;
			attach = attach == "" ? null : attach;
			
			List<Object> lstPara = new ArrayList<Object>();
			lstPara.add(parentid);
			lstPara.add(resid);
			lstPara.add(user.getId());
			lstPara.add(uid2);
			lstPara.add(catid);
			lstPara.add(type);
			lstPara.add(comment);
			lstPara.add( attach );
			lstPara.add("ret");
			
			List<Object> addret = dao.callProc("pc_res_comment_add", lstPara, 1);
			return Integer.parseInt(addret.get(0).toString());
		}
		return -1;
	}
	
	
	@Override
	public int getCommentCnt(String resId, String type) {
		String sql="select count(att.id) from tb_res_attention att where att.res_id='"+resId+"' and att.type="+type+" and att.status="+type;
		return dao.queryForCount(sql, 0);
	}
	
}
