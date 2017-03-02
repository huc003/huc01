package com.huc.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserAction {
	
	@RequestMapping("/login")
	public String login() {
		
		return "redirect:/index/index";
	}
	
//	@RequestMapping("/index")
//	public String index() {
//		System.out.println("-----------------------------index");
//		return "index";
//	}
}
