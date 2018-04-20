package com.info.controllers;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import com.info.domain.dto.RegistraFormDTO;
import com.info.domain.entity.Employee;
import com.info.domain.entity.User;
import com.info.domain.entity.ValidateToken;
import com.info.event.OnRegistrationCompleteEvent;
import com.info.service.IUserService;
import com.info.service.IEmployeeService;

import javax.validation.Valid;

@Controller
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;
    
    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    // 注册
    @PostMapping("/register")
    public String register(@Valid RegistraFormDTO registraFormDTO, BindingResult result, WebRequest request,RedirectAttributesModelMap model){
            	
    	// 校验表单字段
        if (result.hasErrors()){
        	log.info(result.getFieldError().toString());
        	//mav.addObject("message", result.getFieldError());
        	//mav.setViewName("redirect:/register");      	
        	model.addFlashAttribute("message", result.getFieldError());
            return "redirect:/register";
        }else if(!"on".equals(registraFormDTO.getCheckbox())) {
        	log.info(registraFormDTO.getCheckbox().toString());
        	model.addFlashAttribute("message", "您未同意注册协议");
        	return "redirect:/register";
        }
        else {
	        //保存注册信息
	        User user = new User();
	        Employee employee=new Employee();
	        user.setUsername(registraFormDTO.getUsername());
	        user.setPassword(passwordEncoder.encode(registraFormDTO.getPassword()));
	        user.setEmail(registraFormDTO.getEmail());
	        user.setEmployee(employee);
	        employeeService.createNewEmployee(employee);
	        User registrated  = userService.creatNewUser(user);
	        // 发布邮箱验证事件
	        String appUrl = request.getContextPath();
	        if (registrated == null){
	        	//mav.addObject("message", "该邮箱已注册");
	        	//mav.setViewName("/register");
	        	model.addFlashAttribute("message", "该邮箱已注册");
	            return  "redirect:/register";
	        }else {
		        try {
		        	//注册完成事件,发送确认邮箱
		            eventPublisher.publishEvent(new OnRegistrationCompleteEvent(user,appUrl));
		        }catch (Exception e){
		            log.info(e.getMessage());
		            //mav.addObject("message", "请确认邮箱状态是否正常");
		            //mav.setViewName("/login");
		            //throw e;
		            model.addFlashAttribute("message", "请确认邮箱状态是否正常");
		            return  "redirect:/register";
		        }
		        //mav.addObject("message","注册成功，请到邮箱确认后再登录");
		        //mav.setViewName("redirect:/login");
		        model.addFlashAttribute("message","注册成功，请到邮箱确认后再登录");
		        return "redirect:/login";
	        }
        }
          
    }
    /**
     *  邮箱验证
     *  1、判断token是否存在
     *  2、判断是否过期
     */
    @GetMapping("/registationConfirm")
    public String registationConfirm(String token, RedirectAttributesModelMap model){
        ValidateToken validateToken = userService.findValidateToken(token);
        if (validateToken == null) {
            model.addFlashAttribute("message","请求地址中的Token不存在");
            return "redirect:/register";
        }
        if (validateToken.getExpiryDate().getTime()- DateTime.now().getMillis()<0){
            model.addFlashAttribute("message","请求地址中的Token已过期");
            return "redirect:/register";
        }
        User user = validateToken.getUser();
        user.setEnabled(true);
        userService.saveRegistratedUser(user);
        model.addFlashAttribute("message", "确认成功，请登录");
        return "redirect:/login";
    }
    
    //Ajax检查用户名是否可用 true表示可用，false表示不可用
    @ResponseBody
    @PostMapping("/validateUserName")
    public boolean validateUserName(String username){
    	if(userService.findByUsername(username)!=null){
    		return false;
    	}
    	else {
			return true;
		}
    }
    
    //Ajax检查用户名是否可用 true表示可用，false表示不可用   
    @ResponseBody
    @PostMapping("/validateEmail")
    public boolean validateEmail(String email){
    	if(userService.findByEmail(email)!=null){
    		return false;
    	}
    	else {
			return true;
		}
    }

}
