package com.zhelee.info.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class HelloController {
	
	@Value("${message.welcome}")
	private String hello;
	
	@RequestMapping("/index")
	public String index(Model model){
		model.addAttribute("welcome", hello);
		return "index";
	}	
}
