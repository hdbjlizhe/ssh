package com.info.controllers;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.info.domain.dto.RegistraFormDTO;
import com.info.domain.entity.User;
import com.info.domain.entity.ValidateToken;
import com.info.event.OnRegistrationCompleteEvent;
import com.info.service.IUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;

@Controller
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    // 注册
    @RequestMapping("/register")
    public String register(@Valid RegistraFormDTO registraFormDTO, BindingResult result, WebRequest request,Model model){
        // 校验表单字段
        if (result.hasErrors()){
        	log.info(result.getFieldError().toString());
        	model.addAttribute("message", result.getFieldError());
            return "redirect:/register";
        }
        // 保存注册信息
        User user = new User();
        user.setUsername(registraFormDTO.getUsername());
        user.setPassword(passwordEncoder.encode(registraFormDTO.getPassword()));
        user.setEmail(registraFormDTO.getEmail());
        User registrated  = userService.creatNewUser(user);
        // 发布邮箱验证事件
        String appUrl = request.getContextPath();
        if (registrated == null){
        	model.addAttribute("message", "该邮箱已注册");
            return  "register";
        }
        try {
        	//注册完成事件
            eventPublisher.publishEvent(new OnRegistrationCompleteEvent(user,appUrl));
        }catch (Exception e){
            log.info(e.getMessage());
            model.addAttribute("message", "请确认邮箱状态是否正常");
            return  "redirect:/login";
        }
        return "redirect:/login";
    }
    /**
     *  邮箱验证
     *  1、判断token是否存在
     *  2、判断是否过期
     */
    @GetMapping("/registationConfirm")
    public String registationConfirm(String token, Model model){
        ValidateToken validateToken = userService.findValidateToken(token);
        if (validateToken == null) {
            model.addAttribute("message","请求地址中的Token不存在");
            return "redirect:/register";
        }
        if (validateToken.getExpiryDate().getTime()- DateTime.now().getMillis()<0){
            model.addAttribute("message","请求地址中的Token已过期");
            return "redirect:/register";
        }
        User user = validateToken.getUser();
        user.setEnabled(true);
        userService.saveRegistratedUser(user);
        return "redirect:/login";
    }
    
    //Ajax检查用户名是否可用 true表示可用，false表示不可用   
    @PostMapping("/validateUserName")
    public Boolean validateUserName(String username){
    	if(userService.findByUsername(username)!=null){
    		return false;
    	}
    	else {
			return true;
		}
    }
    
    //Ajax检查用户名是否可用 true表示可用，false表示不可用   
    @PostMapping("/validateEmail")
    public Boolean validateEmail(String email){
    	if(userService.findByEmail(email)!=null){
    		return false;
    	}
    	else {
			return true;
		}
    }

}
