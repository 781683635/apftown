package com.apft.mvc.service.impl;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.apft.core.DBCache;
import com.apft.mvc.dao.CommDao;
import com.apft.mvc.model.TbCompInformation;
import com.apft.mvc.model.TbResEntity;
import com.apft.mvc.model.TbUserEntity;
import com.apft.mvc.service.ResService;
import com.apft.utils.SessionUtil;
import com.apft.utils.StringUtil;

@Service
public class ResServiceImpl extends BaseServiceImpl implements ResService{
    
	@Autowired
	private CommDao commDao;
	
	/**
	 * 新闻详细的管理的回显
	 */
	@Override
	public TbResEntity resInfo(HttpServletRequest request) {
		//Map<String, Object> map = getLg();
		
		Map<String, Object> language=getLg();
		String lg=(String) language.get("reslg");
		String lang=(String) language.get("reslang");
		String id=request.getParameter("id");
		 
	//	String status=request.getParameter("status");
		TbResEntity newsList=null;
		if(!StringUtil.isNull(id)){
			DBCache.getInstance().addCount("tb_res", "view_times", id);
			
			String sql="SELECT pl.res_id,pl.code,rp.name codeName, r.id,r.title,r.title2,r.vfrom,r.author,r.vdesc,r.vtext,r.lg,r.cat_id,r.img,r.keyword,r.lang,r.view_times,r.update_time " +
						" FROM tv_res AS r LEFT JOIN tb_res_prop_ln AS pl ON r.id = pl.res_id LEFT JOIN tb_res_prop rp ON rp.code=pl.code WHERE  r.status>-90 AND r.id ='"+id+"' "
						+" ORDER BY ABS(r.lg - "+lg+") ASC";
			//and r.lg='"+lg+"' and r.lang='"+lang+"'
			try {
				newsList=(TbResEntity)commDao.queryForEntity(sql, TbResEntity.class, 0);
				if(newsList!=null){
				int viewTimes = newsList.getViewTimes()+DBCache.getInstance().getCount("tb_res", "view_times", id);
								
				newsList.setViewTimes(viewTimes);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
		return newsList;
	}
	
	/**
	 *新闻列表
	 *根据状态查询
	 */
	@Override
	public HttpServletRequest resList(HttpServletRequest request,String catId, Integer pageNum, Integer pageSize,int code, int cacheTime) {
		Map<String, Object> map=getLg();
		String lg=(String) map.get("reslg");
		String lang=(String) map.get("reslang");
		String str = request.getParameter("status");
		String title = request.getParameter("title");
		String querySQL = " AND status>-90 ";
		if(!StringUtil.isNull(str)){
			if("notup".equals(str)){
				querySQL = " AND status=0 ";
			}else if("up".equals(str)){
				querySQL = " AND status=10 ";
			}else if("down".equals(str)){
				querySQL = " AND status=-40 ";
			}else{
				querySQL = " AND status>-90 ";
			}
		}
		
		if(code > 0){
			querySQL += " AND LEFT (rpl.CODE, 1) = "+code;
		}
		
	    if(!StringUtil.isNull(title) && !StringUtil.isNull(title.trim())){
	    	querySQL += " AND title like '%"+title+"%'";
	    }
		String commSQL=" FROM tv_res r LEFT JOIN tb_user AS u ON u.id = r.user_id LEFT JOIN tb_res_prop_ln rpl ON rpl.res_id = r.id " +
						" WHERE r.cat_id = "+catId+" "+querySQL+" "; 
		//AND r.lg = '"+lg+"' AND r.lang = '"+lang+"' 
		
		String listSQL = "SELECT r.title,DATE_FORMAT(r.update_time,'%Y-%m-%d %T') update_time,r.id,r.img,r.status,r.no,r.author,r.vdesc,r.vtext" +
							",u.user_name "
						+commSQL +" order by r.update_time desc,ABS(r.lg-"+map.get("reslg")+") ASC";
		List<Map<String,Object>> list=commDao.PagingQueryForList(listSQL, pageNum, pageSize, cacheTime);
		String countSQL = " select count(r.id) "+commSQL;
		int count = commDao.queryForCount(countSQL, cacheTime);
		request.setAttribute("title", title);
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		request.setAttribute("status", str);
		
		return request;
	}
	
	
	/**
	 *修改新闻的状态
	 */
	@Override
	public int updateres(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		String str=request.getParameter("str");
		String id=request.getParameter("id");
		String sql=null;
		Map<String, Object> map=getLg();
		String lg=(String) map.get("reslg");
		String lang=(String) map.get("reslang");
		if("up".equals(str)){
			sql="UPDATE tv_res r SET r.status=10 where id='"+id+"'";	
			
		}else if("down".equals(str)){
			sql="UPDATE tv_res r SET r.status=-40 where id='"+id+"'";
		}else if("delete".equals(str)){
			sql="UPDATE tv_res r SET r.status=-90 where FIND_IN_SET(r.id,'"+id+"')";
		}
		  int count=commDao.update(sql);
		  return count;
	}
	
	
	/**
	 *6个分类的首页
	 */
	@Override
	public HttpServletRequest queryChildIndex(HttpServletRequest request,Integer pageNum,Integer pageSize,String catId, Integer code,Integer status){
		Map<String, Object> map = getLg();
		String commSQL = " FROM tv_res r LEFT JOIN tb_res_prop_ln rpl ON rpl.res_id = r.id LEFT JOIN tb_res_prop AS rp ON rpl.code = rp.code " +
						"WHERE r.cat_id ="+catId+" AND r.status="+status+" AND LEFT (rpl. CODE, 4)="+code;
		// AND r.lg ="+map.get("reslg")+" AND r.lang ="+map.get("reslang")+"
		
		String sql = "SELECT r.title,r.title2,r.update_time,r.id,r.img,r.no,r.author,r.view_times,r.vtext,rp.name,(SELECT COUNT(rc.id) FROM tb_res_comment rc WHERE rc.res_id=r.id) comment "
					+commSQL+" ORDER BY r.update_time DESC, ABS(r.lg-"+map.get("reslg")+") ASC";
		List<Map<String, Object>> listMap = commDao.PagingQueryForList(sql, pageNum, pageSize, 0);
		int totalCount = commDao.queryForCount("select count(r.id) "+commSQL, 0);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("totalCount", totalCount);
		request.setAttribute("listMap", listMap); 
		return request;
	}
	
	/**
	 * tb_res catId是 apftown 200000
	 * cat 首页数据类型xxyyzz 
	 * bk 产学研分类
	 */
	@Override
	public List<Map<String, Object>> queryIndex(String catId,Integer cat,Integer bk,Integer pageNum,Integer pageSize) {
		Map<String, Object> map = getLg();
		String sql = null;
		String sqls = "SELECT r.id, rt.cat, rt.bk, rt.top, rt.res_id, IFNULL(rt.img, r.img) img, r.title, r.`no`, r.title2, r.cat_id, r.view_times, r.update_time, r.vtext " +
						",(SELECT COUNT(rc.id) FROM tb_res_comment rc WHERE rc.res_id=r.id) comment " +
						" FROM tb_res_top AS rt LEFT JOIN tv_res AS r ON rt.res_id = r.id ";
		if(pageNum==0||pageSize==0){
				sql = sqls+" WHERE r.cat_id="+catId+" AND rt.cat="+cat;
				//AND r.lang="+map.get("reslang")+" AND r.lg="+map.get("reslg")+" 
			if(bk!=-1){
				sql += " AND rt.bk="+bk;
			}
			sql += " AND rt.res_id=r.id ORDER BY rt.bk,rt.top ASC, ABS(r.lg-"+map.get("reslg")+") ASC ";
			
			if(bk == 0)
				sql += " limit 12 ";
		}else{
				sql = sqls+" WHERE r.cat_id = "+catId+" AND rt.cat = "+cat+" AND rt.bk = "+bk;
				//AND r.lang ="+map.get("reslang")+" AND r.lg =
				sql += " ORDER BY ABS(r.lg - "+map.get("reslg")+") ASC";
		}
		List<Map<String, Object>> listMap = commDao.queryForList(sql, 0);
	
		
		return listMap;
	}
	
	
	/**
	 * top管理的查询
	 */
	@Override
	public List<Map<String, Object>> queryIndex(HttpServletRequest request,String catId,Integer cat,Integer bk,Integer pageNum,Integer pageSize) {
		Map<String, Object> map = getLg();
		String sql = null;
		String sqls = "SELECT rt.id, rt.cat, rt.bk, rt.top, rt.res_id, IFNULL(rt.img, r.img) img, r.title, r.`no`, r.title2, r.cat_id, r.view_times, r.update_time, r.vtext" +
						",(SELECT COUNT(rc.id) FROM tb_res_comment rc WHERE rc.res_id=r.id) comment ";
		String sqlss=" FROM tb_res_top AS rt LEFT JOIN tv_res AS r ON rt.res_id = r.id ";
		String sqlsss=" WHERE r.cat_id = "+catId+" AND rt.cat = "+cat+" AND rt.bk = "+bk+" AND r.lang ="+map.get("reslang")+" AND r.lg ="+map.get("reslg")+" ORDER BY r.update_time DESC";
			sql =sqls+sqlss+sqlsss;
		
		List<Map<String, Object>> listMap = commDao.PagingQueryForList(sql, pageNum, pageSize, 0);
		String countSQL = " select count(*) "+sqlss+sqlsss;
		int count = commDao.queryForCount(countSQL, 0);
		request.setAttribute("count", count);
		request.setAttribute("cat", cat);
		request.setAttribute("bk", bk);
		return listMap;
	}
	
	/**
	 * 新闻详细
	 */
	@Override
	public Map<String, Object> newInfo(String catId, Integer resNo){
		Map<String, Object> newInfo = null;
		
		if(resNo!=0){
			
			Map<String, Object> map = getLg();
			
			String sql = "SELECT r.id,r.`no`,r.cat_id,r.title,r.title2,r.vfrom,r.img,r.length,r.author,r.vdesc,r.vtext,r.keyword," +
						"r.view_times,r.user_id,r.`status`,r.update_time,r.lang,r.lg, rpl.`code`,rp.`name`,cm.code_val,cm.code_desc "+
						",(select count(1) from tb_res_attention att where att.res_id=r.id and att.type=110 and att.status=110) likes " +
						",(select count(1) from tb_res_attention att where att.res_id=r.id and att.type=120 and att.status=120) collection " +
						" FROM tv_res AS r INNER JOIN tb_res_prop_ln AS rpl ON rpl.res_id = r.id ,tb_res_prop AS rp "+ 
						" LEFT JOIN tb_code_msg AS cm ON cm.code_val=LEFT(rp.`code`, 1)" +
						" WHERE r.no='"+resNo+"' AND r.cat_id="+catId+" AND rp.`code`=rpl.`code` "
						+" ORDER BY ABS(r.lg - "+map.get("reslg")+") ASC";
			//AND r.lang="+map.get("reslang")+" AND r.lg="+map.get("reslg")+" 
			newInfo = commDao.queryForMap(sql, 0);
			
			if(null != newInfo && newInfo.size() > 0){
				DBCache.getInstance().addCount("tb_res", "view_times", newInfo.get("id").toString());
				int viewTimes = Integer.parseInt(newInfo.get("view_times").toString());
				
				viewTimes += DBCache.getInstance().getCount("tb_res", "view_times", newInfo.get("id").toString());
				
				newInfo.put("view_num", viewTimes);
			}
		}
		
		return newInfo;
	}
	/**
	 * 新闻列表集合
	 */
	@Override
	public  List<Map<String,Object>> newMap(int code){
		List<Map<String,Object>> newsmap = null;
		
	/*	if(code!=null){*/
			
			Map<String, Object> map = getLg();
			
			String sql = "SELECT r.id,r.`no`,r.cat_id,r.title,r.title2,r.vfrom,r.img,r.length,r.author,r.vdesc,r.vtext,r.keyword," +
						"r.view_times,r.user_id,r.`status`,r.update_time,r.lang,r.lg, rpl.`code`,rp.`name`,cm.code_val,cm.code_desc "+
						",(select count(1) from tb_res_attention att where att.res_id=r.id and att.type=110 and att.status=110) likes " +
						",(select count(1) from tb_res_attention att where att.res_id=r.id and att.type=120 and att.status=120) collection " +
						" FROM tv_res AS r INNER JOIN tb_res_prop_ln AS rpl ON rpl.res_id = r.id ,tb_res_prop AS rp "+ 
						" LEFT JOIN tb_code_msg AS cm ON cm.code_val=LEFT(rp.`code`, 1)" +
						" WHERE rp.`code`='"+code+"'"+
						" ORDER BY ABS(r.lg - "+map.get("reslg")+") ASC";
			//AND r.lang="+map.get("reslang")+" AND r.lg="+map.get("reslg")+" 
		//	newsmap = commDao.queryForMap(sql, 0);
			newsmap =commDao.queryForList(sql, 0);
/*		}*/
		
		return newsmap;
	}

		@Override
		public HttpServletRequest upFundInfo(String moblie,HttpServletRequest request) {
			// TODO Auto-generated method stub
			TbUserEntity user=null;
			if(moblie!=null){
				String sql="SELECT u.id FROM tb_user AS u WHERE u.user_reg_mobile='"+moblie+"'";
				user=(TbUserEntity) commDao.queryForObject(sql, TbUserEntity.class,0);
			}else{
				user=SessionUtil.getSessionUser();
			}
			List<Map<String, Object>> comp=null;
			if(user!=null){
				String sqlss="SELECT c.id FROM tb_comp_information AS c WHERE c.user_id='"+user.getId()+"'";
				TbCompInformation compInfo=(TbCompInformation) commDao.queryForObject(sqlss, TbCompInformation.class, 0);
				if(compInfo==null){	
					request.setAttribute("comp", comp);
					return request;
				}else{
					String sqls="SELECT c.type_of_entity,c.fund_type,c.company_name,c.office_address,c.zipcode,c.registecapital,c.paidcapital,c.managescale,c.firstcapital," +
							"c.employees,c.contact_phone,c.status,c.duties,c.contact_person,c.contact_email,c.id,c.user_id FROM tb_comp_information AS c LEFT JOIN tb_user AS u ON c.user_id = u.id WHERE u.id='"+user.getId()+"'";
					comp=commDao.queryForList(sqls, 0);
					request.setAttribute("comp", comp);
					return request;	
				}
			}
			return null;
		}
		
		
		/**
		 *修改入园申请人的状态(0:未联系,1：已联系,-90:删除)
		 */
		@Override
		public int updateComp(HttpServletRequest request) {
			// TODO Auto-generated method stub
			
			String str=request.getParameter("str");
			String id=request.getParameter("id");
			String sql=null;
			Map<String, Object> map=getLg();
			if("0".equals(str)){
				sql="UPDATE tb_comp_information c SET c.status=0 where id='"+id+"'";
			}else if("1".equals(str)){
				sql="UPDATE tb_comp_information c SET c.status=1 where id='"+id+"'";
			}else if("2".equals(str)){
				sql="UPDATE tb_comp_information c SET c.status=2 where id='"+id+"'";
			}else if("3".equals(str)){
				sql="UPDATE tb_comp_information c SET c.status=3 where id='"+id+"'";
			}else if("4".equals(str)){
				sql="UPDATE tb_comp_information c SET c.status=4 where id='"+id+"'";
			}else if("5".equals(str)){
				sql="UPDATE tb_comp_information c SET c.status=5 where id='"+id+"'";
			}else if("6".equals(str)){
				sql="UPDATE tb_comp_information c SET c.status=6 where id='"+id+"'";
			}else{
				sql="UPDATE tb_comp_information c SET c.status=-90 where id='"+id+"'";
			}
			  int count=commDao.update(sql);
			  return count;
		}
		@Override
		public HttpServletRequest upMInfo(HttpServletRequest request) {
			// TODO Auto-generated method stub
			String id=request.getParameter("id");
			List<Map<String, Object>> comp=null;
			String sqls="SELECT c.type_of_entity,c.fund_type,c.company_name,c.office_address,c.zipcode,c.registecapital,c.paidcapital,c.managescale,c.firstcapital," +
					"c.employees,c.contact_phone,c.duties,c.contact_person,c.contact_email,c.id,c.status,c.user_id FROM tb_comp_information AS c LEFT JOIN tb_user AS u ON c.user_id = u.id WHERE c.id='"+id+"'";
			comp=commDao.queryForList(sqls, 0);
			request.setAttribute("comp", comp);
			return request;	
		}
}
