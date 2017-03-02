package com.huc.dao.impl;

import java.util.Map;

import com.huc.dao.HelloDao;


public class HelloDaoImpl extends GeneralDaoImpl implements HelloDao{

	@Override
	public Map<String, Object> test() {
		String sql = "select * from users where id = 1";
		return this.resultSql(sql);
	}
 
}
