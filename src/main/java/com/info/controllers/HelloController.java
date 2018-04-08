package com.info.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	private final static Logger logger=LoggerFactory.getLogger(HelloController.class);

	//首页
	@RequestMapping(value={"/","/index"})
	public String index(Model model){
		return "index";
	}
	//党务模块
	@GetMapping("/party")
	public String party(){
		return "party/party";
	}
	//公文往来
	@GetMapping("/office")
	public String office(){
		return "office/office";
	}
	//日常工作
	@GetMapping("/daily")
	public String daily(){
		return "daily/daily";
	}
	//personel
	@GetMapping("/personel")
	public String personal(){
		return "personel/personel";
	}
	//policy
	@GetMapping("/policy")
	public String policy(){
		return "policy/policy";
	}
	//activity
	@GetMapping("/activity")
	public String activity(){
		return "activity/activity";
	}
	//About
	@GetMapping("/about")
	public String about() {
		return "about";
	}
}
