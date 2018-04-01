package com.zhelee.info.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@Value("${message.welcome}")
	private String hello;
	//首页
	@RequestMapping("/index")
	public String index(Model model){
		model.addAttribute("welcome", hello);
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
	//admin
	@GetMapping("/admin")
	public String admin() {
		return "admin/admin";
	}
}
