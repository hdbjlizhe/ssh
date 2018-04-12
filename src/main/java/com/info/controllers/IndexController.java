package com.info.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	//首页
	@RequestMapping(value={"/","/index"})
	public String index(){
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
	//HOME页面
    @RequestMapping(value = {"/home"})
    public String home(){
        return "home";
    }
    //管理员页面
    @RequestMapping(value = {"/admin"})
    public String admin(){
        return "admin/admin";
    }
    //普通用户页面
    @RequestMapping(value = {"/user"})
    public String user(){
        return "user";
    }
    //VIP用户页面
    @RequestMapping(value = {"/vip"})
    public String vip(){
        return "vip";
    }
    //超级用户页面
    @RequestMapping(value = {"/super"})
    public String superm(){
        return "super";
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
    //登录页面
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
