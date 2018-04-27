package com.info.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
		
	private static final Logger log = LoggerFactory.getLogger(IndexController.class);
	
	//首页
	@RequestMapping("/")
	public String home() {
		return "redirect:/index";
	}
	
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	//错误处理
	@GetMapping("/error")
	public String Error() {
		return "error";
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
	//人事
	@GetMapping("/personel")
	public String personal(){
		return "personel/personel";
	}
	//政策
	@GetMapping("/policy")
	public String policy(){
		return "policy/policy";
	}
	//活动
	@GetMapping("/activity")
	public String activity(){
		return "activity/activity";
	}
	//关于
	@GetMapping("/about")
	public String about() {
		return "about";
	}
    //拒绝登录页面
    @RequestMapping(value = {"/deny"})
    public String deny(){
        return "deny";
    }
    //注册页面
    @GetMapping("/register")
    public String regist(){
        return "register";
    }
    //注册协议
    @GetMapping("/protocol")
    public String Protocol() {
    	return "protocol";
    }
    //Get请求的登录页面
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    //登录错误页面
    @GetMapping("/login-error")
    public String loginError(){
        return "login";
    }
    //CSRF测试页面
    @GetMapping("/CSRFTest")
    public String product(){
        return "CSRFTest";
    }
    //CSRF测试检查页面
    @PostMapping("/CSRFTestcheck")
    public String product1(){
        return "home";
    }
}
