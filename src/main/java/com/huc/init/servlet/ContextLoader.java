package com.huc.init.servlet;

import javax.servlet.ServletContextEvent;

import org.springframework.web.context.ContextLoaderListener;

import com.huc.common.constant.Constants;
import com.huc.util.PropertiesUtils;



public class ContextLoader  extends ContextLoaderListener{

	@Override
	public void contextInitialized(ServletContextEvent event) {
		PropertiesUtils.init();
		System.out.println("当前环境-"+PropertiesUtils.getConfig("environment"));
		System.setProperty("environment", PropertiesUtils.getConfig("environment"));
		System.setProperty("dubbo.shutdown.hook", "true");
		Constants.ENVIRONMENT = PropertiesUtils.getConfig("environment");
		super.contextInitialized(event);
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		super.contextDestroyed(event);
	}
	

}