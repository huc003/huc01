package com.huc.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.huc.service.HelloService;

@Controller
@RequestMapping("/")
public class HelloController {

    @Resource
    private HelloService helloService;

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", helloService.test());
		return "hello";
	}
}