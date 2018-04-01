package com.zhelee.info.controllers;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhelee.config.WebSecurityConfig;
import com.zhelee.info.domain.Result;
import com.zhelee.info.entities.Employee;
import com.zhelee.info.entities.User;
import com.zhelee.info.repository.UserRepository;
import com.zhelee.info.services.UserService;
import com.zhelee.utils.ResultUtil;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//登录界面获取
	@GetMapping("/login")
	public String login(){
		return "login";
	}
	//用户登录操作
	@PostMapping("/login")
    public String login(String account, String password, HttpSession session,Model model) {
		//查询数据库用户是否存在
		User user=userService.findByAccountAndPassword(account, password);
		//用户存在
        if (user!=null) {   
            // 设置session
            session.setAttribute(WebSecurityConfig.SESSION_KEY, account);
            model.addAttribute("result", ResultUtil.success(user));
            return "redirect:/index";
        }else {//用户不存在
			model.addAttribute("result",ResultUtil.error("用户名或密码错误"));
			return "redirect:/login";
		}
	}
	
	//用户登出操作
	@GetMapping("/logout")
    public String logout(HttpSession session) {
        // 移除session
        session.removeAttribute(WebSecurityConfig.SESSION_KEY);
        return "index";
    }
	
	//用户注册界面
	@GetMapping("/register")
	public String register(){
		return "register";
	}
	//user register
	@PostMapping("/register")
	public String register(Model model,String account,String password){
		//0.查找数据库
		User user=(User) userService.findByAcount(account);
		//1.首先判断用户数据库有没有重复的
		if(user!=null){//2.有重复，则返回（用户名重复信息，手机号已注册，Email已注册信息）
			model.addAttribute(ResultUtil.error("用户已存在！"));
			return "register";
		}
		//2.没有重复，则增加用户
		try {
			User newUser=new User();
			newUser.setAcount(account);
			newUser.setPassword(password);
			userService.addUser(newUser);
			model.addAttribute(ResultUtil.success(null));
		} catch (Exception e) {
			model.addAttribute(ResultUtil.error("用户添加失败"));
			return "register";
		}
		return "login";
	}
	//Ajax-检查用户名是否可用
	@PostMapping(value="/user-validateAccount")
	@ResponseBody//返回jason数据
	public String ajaxAccountValidate(@RequestParam("account") String account) {
		
		if(userService.findByAcount(account) != null){
			return "0";
		}else{
			return "1";
		}		
	}
}
