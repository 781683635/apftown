package com.apft.mvc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apft.mvc.dao.CommDao;
import com.apft.mvc.model.TbChinaAreaEntity;
import com.apft.mvc.service.CommService;
import com.apft.utils.StringUtil;


@Service
public class CommServiceImpl implements CommService{
	
	@Autowired
	private CommDao dao;
	
	
	@Override
	public List<Map<String, Object>> proplst(String cat, int res_prop) {
		//res_prop = StringUtil.isNull(res_prop)?"0":res_prop;
		String sql = "select * from tb_res_prop where cat="+cat+" and parent_code="+res_prop+" order by code asc";
		return dao.queryForList(sql, 0);
	}
	
	@Override
	public List<TbChinaAreaEntity> chinaArea(String parentid) {
		List<TbChinaAreaEntity> chinaArealst = null;
		if(null != parentid && parentid.length() > 0){
			try {
				chinaArealst = dao.queryForListEntity("select * from tb_chinaarea where parentid='"+parentid+"'", TbChinaAreaEntity.class, -1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return chinaArealst;
	}
	
	
}
