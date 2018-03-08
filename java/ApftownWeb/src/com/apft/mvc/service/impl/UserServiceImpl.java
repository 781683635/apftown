package com.apft.mvc.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apft.mvc.dao.CommDao;
import com.apft.mvc.service.UserService;
import com.apft.utils.StringUtil;



@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private CommDao commDao;
	
	
	
	
	/**
	 * 关注的查询
	 */
	@Override
	public HttpServletRequest queryAtten(HttpServletRequest request,Integer pageNum,Integer pageSize,
			String userId,Integer type) {
		String fromWhere = "FROM tb_res_attention AS ratt LEFT JOIN tv_res AS r ON ratt.res_id = r.id LEFT JOIN tb_res_prop_ln AS trpl ON trpl.res_id = ratt.res_id INNER JOIN tb_res_prop AS trp ON LEFT(trpl.code,1) = trp.`code`" +
				" WHERE ratt.status>0 AND ratt.user_id ='"+userId+"' AND ratt.type ="+type;
		String sql = "SELECT ratt.id,ratt.type,r.title,DATE_FORMAT(ratt.insert_time,'%Y-%m-%d') insert_time ,r.img,r.no,trpl.code,trp.name,ratt.res_id "+fromWhere;
		String sqlc ="SELECT COUNT(*) pageCount "+fromWhere;
		int totalCount = commDao.queryForCount(sqlc, 0);
		List<Map<String, Object>> listMap = commDao.PagingQueryForList(sql, pageNum, pageSize, 0);
		request.setAttribute("listMap", listMap);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("totalCount", totalCount);
		return request;
	}
	/**
	 * 关注根据code查询
	 */
	@Override
	public HttpServletRequest queryAtten(HttpServletRequest request,Integer pageNum,Integer pageSize,
			String userId,Integer type,String code) {
		String fromWhere = "FROM tb_res_attention AS ratt LEFT JOIN tv_res AS r ON ratt.res_id = r.id LEFT JOIN tb_res_prop_ln AS trpl ON trpl.res_id = ratt.res_id INNER JOIN tb_res_prop AS trp ON LEFT(trpl.code,1) = trp.`code`" +
				" WHERE ratt.status>0 AND ratt.user_id ='"+userId+"' AND ratt.type ="+type+" AND LEFT(trpl.code,1)="+code+"";
		String sql = "SELECT ratt.id,ratt.type,r.title,DATE_FORMAT(ratt.insert_time,'%Y-%m-%d') insert_time ,r.img,r.no,trpl.code,trp.name,ratt.res_id "+fromWhere;
		String sqlc ="SELECT COUNT(*) pageCount "+fromWhere;
		int totalCount = commDao.queryForCount(sqlc, 0);
		List<Map<String, Object>> listMap = commDao.PagingQueryForList(sql, pageNum, pageSize, 0);
		request.setAttribute("listMap", listMap);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("totalCount", totalCount);
		

		request.setAttribute("code", code);
		return request;
	}
	
	/**
	 * 站内信查询
	 */
	@Override
	public HttpServletRequest queryMsg(HttpServletRequest request,Integer pageNum,Integer pageSize,
			String userId){
		String fromWhere = " FROM tb_user_msg AS um WHERE user_id = '"+userId+"' AND status>-1 ORDER BY status ,create_time DESC";
		String sql = "SELECT um.id,um.msg_content, um.status, um.msg_title, um.create_time"+fromWhere;
		String sqlc = "SELECT COUNT(*) pageCount"+fromWhere;
		int totalCount = commDao.queryForCount(sqlc, 0);
		List<Map<String, Object>> listMap = commDao.PagingQueryForList(sql, pageNum, pageSize, 0);
		request.setAttribute("listMap", listMap);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("totalCount", totalCount);
		return request;
	}

	/**
	 * 站内信更新(删除和已读)
	 */
	@Override
	public int updateMsg(HttpServletRequest request){
		String str = request.getParameter("str");
		String id = request.getParameter("id");
		String sql = null;
		int count= 0 ;
		if("delete".equals(str)){
			sql="UPDATE tb_user_msg um SET um.status= -10 where id= '"+id+"'";
			count = commDao.update(sql);
		}else if("read".equals(str)){
			sql="UPDATE tb_user_msg um SET um.status= 1 where id= '"+id+"'";
			count = commDao.update(sql);
		}
		return count; 
	}
/*	*//**
	 * 查询入园管理，每个分类下的左边菜单栏
	 * @param request
	 * @param pageNum
	 * @param pageSize
	 * @param Code 对应的code参数
	 * @return
	 *//*
	@Override
	public HttpServletRequest queryIntoPark(HttpServletRequest request,
			Integer pageNum, Integer pageSize, String Code) {
		String status=request.getParameter("status");
		String title=request.getParameter("title");
		String sql="SELECT ra.`value` AS `name`,ra1.`value` AS email,ra2.`value` AS mobile,ra3.`value` AS remark,r.update_status,ra1.res_id,ra1.`no`,rpl.code,r.director FROM tb_res AS r"+
				" INNER JOIN tb_res_attrib AS ra ON (ra.res_id = r.id AND ra.label = 'name')"+
				" INNER JOIN tb_res_attrib AS ra1 ON (ra1.res_id = r.id AND ra1.label = 'email')"+
				" INNER JOIN tb_res_attrib AS ra2 ON (ra2.res_id = r.id AND ra2.label = 'mobile')"+
				" INNER JOIN tb_res_attrib AS ra3 ON (ra3.res_id = r.id AND ra3.label = 'remark')"+
				" INNER JOIN tb_res_lg AS rl ON rl.res_id = r.id "+
				" INNER JOIN tb_res_prop_ln AS rpl ON (rpl.res_id = r.id AND rpl.code='"+Code+"')";

		if(StringUtil.isNotEmpty(status)){
			sql+=" where r.update_status='"+status+"'";
			
		}
		if(StringUtil.isNotEmpty(title)){
			sql+=" AND ra.value like '%"+title+"%'";
			
		}
		sql+=" ORDER BY r.update_time DESC";
		List<Map<String, Object>> listMap=commDao.PagingQueryForList(sql, pageNum, pageSize, 0);
		String sqls="SELECT count(*) FROM tb_res AS r"+
				" INNER JOIN tb_res_attrib AS ra ON (ra.res_id = r.id AND ra.label = 'name')"+
				" INNER JOIN tb_res_attrib AS ra1 ON (ra1.res_id = r.id AND ra1.label = 'email')"+
				" INNER JOIN tb_res_attrib AS ra2 ON (ra2.res_id = r.id AND ra2.label = 'mobile')"+
				" INNER JOIN tb_res_attrib AS ra3 ON (ra3.res_id = r.id AND ra3.label = 'remark')"+
				" INNER JOIN tb_res_lg AS rl ON rl.res_id = r.id"+
				" INNER JOIN tb_res_prop_ln AS rpl ON (rpl.res_id = r.id AND rpl.code='"+Code+"')";
		int totalCount = commDao.queryForCount(sqls, 0);
		request.setAttribute("title", title);
		request.setAttribute("status", status);
		request.setAttribute("listMap", listMap);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("totalCount", totalCount);
		return request;
	}*/
	
	/**
	 * 报名信息管理
	 */
	@Override
	public HttpServletRequest queryDateList(HttpServletRequest request,
			Integer pageNum, Integer pageSize, String Code) {
		String status=request.getParameter("status");
		String attribName=request.getParameter("attribName");
		String sql="SELECT ra.`value` AS `name`,ra1.`value` AS email,ra2.`value` AS mobile,ra3.`value` AS company,ra4.`value` AS job,r.update_status,ra1.res_id,ra1.`no`,rpl.code,r.director FROM tb_res AS r"+
				" INNER JOIN tb_res_attrib AS ra ON (ra.res_id = r.id AND ra.label = 'name')"+
				" INNER JOIN tb_res_attrib AS ra1 ON (ra1.res_id = r.id AND ra1.label = 'email')"+
				" INNER JOIN tb_res_attrib AS ra2 ON (ra2.res_id = r.id AND ra2.label = 'mobile')"+
				" INNER JOIN tb_res_attrib AS ra3 ON (ra3.res_id = r.id AND ra3.label = 'company')"+
				" INNER JOIN tb_res_attrib AS ra4 ON (ra4.res_id = r.id AND ra4.label = 'job')"+
				" INNER JOIN tb_res_lg AS rl ON rl.res_id = r.id "+
				" INNER JOIN tb_res_prop_ln AS rpl ON (rpl.res_id = r.id AND rpl.code='"+Code+"')";
		if(StringUtil.isNotEmpty(status)){
			sql+=" where r.update_status='"+status+"'";
			
		}
		if(StringUtil.isNotEmpty(attribName)){
			sql+="AND ra.value like '%"+attribName+"%'";
			
		}
		sql+=" ORDER BY r.update_time DESC";
		List<Map<String, Object>> listMap=commDao.PagingQueryForList(sql, pageNum, pageSize, 0);
		String sqls="SELECT count(*) FROM tb_res AS r"+
				" INNER JOIN tb_res_attrib AS ra ON (ra.res_id = r.id AND ra.label = 'name')"+
				" INNER JOIN tb_res_attrib AS ra1 ON (ra1.res_id = r.id AND ra1.label = 'email')"+
				" INNER JOIN tb_res_attrib AS ra2 ON (ra2.res_id = r.id AND ra2.label = 'mobile')"+
				" INNER JOIN tb_res_attrib AS ra3 ON (ra3.res_id = r.id AND ra3.label = 'company')"+
				" INNER JOIN tb_res_attrib AS ra4 ON (ra4.res_id = r.id AND ra4.label = 'job')"+
				" INNER JOIN tb_res_lg AS rl ON rl.res_id = r.id"+
				" INNER JOIN tb_res_prop_ln AS rpl ON (rpl.res_id = r.id AND rpl.code='"+Code+"')";
		int totalCount = commDao.queryForCount(sqls, 0);
		request.setAttribute("attribName", attribName);
		request.setAttribute("status", status);
		request.setAttribute("listMap", listMap);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("totalCount", totalCount);
		return request;
	}
	
	/**
	 * 显示用户入园更新状态
	 */
	public HttpServletRequest selUpstatus(HttpServletRequest request,String id) {
		// TODO Auto-generated method stub
		String sql="SELECT c.id,c.user_id,c.`status` FROM tb_comp_information AS c  LEFT JOIN tb_user AS u ON c.user_id = u.id WHERE u.id = '"+id+"'";
		List<Map<String, Object>> listMap=commDao.queryForList(sql, 0);
		request.setAttribute("listMap", listMap);
		return request;
		
	}
	/**
	 * 查询入园管理，每个分类下的左边菜单栏
	 * @param request
	 * @param pageNum
	 * @param pageSize
	 * @param Code 对应的code参数
	 * @return
	 */
	@Override
	public HttpServletRequest querypintoPark(HttpServletRequest request,
			Integer pageNum, Integer pageSize) {
		String companyname=request.getParameter("company_name");
		String sql="SELECT c.id,c.company_name,c.duties,c.contact_person,c.contact_email,c.contact_phone, DATE_FORMAT(c.update_time,'%Y-%m-%d') update_time,c.status FROM tb_comp_information AS c where c.status>-90";
		if(StringUtil.isNotEmpty(companyname)){
			sql+=" AND c.company_name like '%"+companyname+"%'";
		}else{
			sql+=" ";
		}
		sql+="ORDER BY c.update_time DESC";
		List<Map<String, Object>> listMap=commDao.PagingQueryForList(sql, pageNum, pageSize, 0);
		String sqls="SELECT count(*) FROM tb_comp_information AS c where c.status>-90";
		if(StringUtil.isNotEmpty(companyname)){
			sqls+=" AND c.company_name like '%"+companyname+"%'";
		}else{
			sqls+=" ";
		}
		int totalCount = commDao.queryForCount(sqls, 0);
		request.setAttribute("companyname", companyname);
		request.setAttribute("listMap", listMap);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("totalCount", totalCount);
		return request;
	}

}