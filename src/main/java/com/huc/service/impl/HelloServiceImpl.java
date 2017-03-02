package com.huc.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import com.huc.dao.HelloDao;
import com.huc.service.HelloService;

/**
 * Created by huc on 2017/1/14.
 */
public class HelloServiceImpl implements HelloService {
	
	@Resource
	private HelloDao helloDao;

	public Map<String, Object> test() {
		return helloDao.test();
	}
    
}
