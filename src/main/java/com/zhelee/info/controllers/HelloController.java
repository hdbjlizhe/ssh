package com.zhelee.info.controllers;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	private final static Logger logger=LoggerFactory.getLogger(HelloController.class);
	
	@Value("${message.welcome}")
	private String hello;
	
	@Autowired
	private MessageSource messageSource;
	
	//首页
	@RequestMapping(value={"/","/index"})
	public String index(Model model){
		Locale locale = LocaleContextHolder.getLocale();
		String msg = messageSource.getMessage("hello",null,locale);
		logger.info(msg);
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
