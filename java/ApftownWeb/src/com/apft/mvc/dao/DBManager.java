package com.apft.mvc.dao;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;


@Controller
public class DBManager {

	@Resource
	private JdbcTemplate jdbcTemplate;
	

	
	public static DBManager _me;
	
	private DBManager() {

		_me = this;
		
//		DBCache.getInstance().setJdbcTemplate(jdbcTemplate);
	}

	public static DBManager getInstance() {
		
		if (_me == null) {

			_me = new DBManager();
		}

		return _me;
	}
	
	public JdbcTemplate getSQLDao() {
		return jdbcTemplate;
	}
	
}
