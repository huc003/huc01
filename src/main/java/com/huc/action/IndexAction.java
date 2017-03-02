package com.huc.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/index")
public class IndexAction {
	
	@RequestMapping("/top")
	public String login(ModelMap model) {
		model.addAttribute("message", "adasd");
		return "";
	}
	
	@RequestMapping("/index")
	public String index() {
		System.out.println("-----------------------------index");
		return "index";
	}
}
