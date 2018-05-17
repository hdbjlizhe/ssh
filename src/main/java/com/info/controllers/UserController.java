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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import com.info.domain.dto.RegistraFormDTO;
import com.info.domain.entity.Department;
import com.info.domain.entity.Duty;
import com.info.domain.entity.EduLevel;
import com.info.domain.entity.Employee;
import com.info.domain.entity.Experience;
import com.info.domain.entity.Nation;
import com.info.domain.entity.Party;
import com.info.domain.entity.Rank;
import com.info.domain.entity.User;
import com.info.domain.entity.ValidateToken;
import com.info.event.OnRegistrationCompleteEvent;
import com.info.service.IUserService;
import com.info.service.IDepartmentService;
import com.info.service.IDutyService;
import com.info.service.IEduLevelService;
import com.info.service.IEmployeeService;
import com.info.service.IExperienceService;
import com.info.service.INationService;
import com.info.service.IPartyService;
import com.info.service.IRankService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
    @Autowired
    private IDepartmentService departmentService;
    @Autowired
    private IDutyService dutyService;
    @Autowired
    private IEduLevelService eduLevelService;
    @Autowired
    private IExperienceService experienceService;
    @Autowired
    private INationService nationService;
    @Autowired
    private IPartyService partyService;
    @Autowired
    private IRankService rankService;

    /**
     *  注册
     * @param registraFormDTO
     * @param result
     * @param request
     * @param model
     * @return
     */
    @PostMapping("/register")
    public String register(@Valid RegistraFormDTO registraFormDTO, BindingResult result, WebRequest request,RedirectAttributesModelMap model){
            	
    	// 校验表单字段
        if (result.hasErrors()){
        	log.info(result.getFieldError().toString());   	
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
	        	model.addFlashAttribute("message", "该邮箱已注册");
	            return  "redirect:/register";
	        }else {
		        try {
		        	//注册完成事件,发送确认邮箱
		            eventPublisher.publishEvent(new OnRegistrationCompleteEvent(user,appUrl));
		        }catch (Exception e){
		            model.addFlashAttribute("message", "请确认邮箱状态是否正常");
		            return  "redirect:/register";
		        }
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
    
    @GetMapping("/user/details")
    public String detail(Model model,HttpServletRequest request) {  	
    	User user=userService.getLoginEmployee(request);
    	Employee employee=employeeService.getLoginEmployee(request);
    	List<Experience> experiences=experienceService.getAllByEmployee(employee);
    	List<Department> departments=departmentService.getAll();
    	List<Rank> ranks=rankService.getAll();
    	List<Duty> dutys=dutyService.getAll();
    	List<EduLevel> eduLevels=eduLevelService.getAll();
    	List<Nation> nations=nationService.getAll();
    	List<Party> partys=partyService.getAll();
    	model.addAttribute("user", user);
    	model.addAttribute("employee",employee);
    	model.addAttribute("experiences", experiences);
    	model.addAttribute("departments", departments);
    	model.addAttribute("ranks", ranks);
    	model.addAttribute("dutys", dutys);
    	model.addAttribute("eduLevels", eduLevels);
    	model.addAttribute("nations", nations);
    	model.addAttribute("partys", partys);
    	return "user/details";
    }
    
    @GetMapping("/user/pwd/mod")
    public String pwdMod() {  	
    	return "user/mod-pwd";
    }
    
    @PostMapping("/user/pwd/mod")
    public String pwdMod(String oldpwd,String newpwd,String newpwdcheck,HttpServletRequest request) {
    	if(!newpwd.equals(newpwdcheck)) {
    		return "redirect:/user/pwd/mod";
    	}
    	//1.获取登录用户user
    	User user=userService.getLoginEmployee(request);
    	//2.检查旧密码是否与提交的旧密码一致，
    	if(passwordEncoder.matches(oldpwd, user.getPassword())) {
    		user.setPassword(passwordEncoder.encode(newpwd));
    		userService.update(user);
        	return "redirect:/user/details";
    	}    	
    	return "redirect:/user/pwd/mod";
    	//3.更新密码
    }
    
    /********************************************************************************************************
     * 以下为Ajax
     * @param username
     * @return
     ********************************************************************************************************/
    
    /**
     * Ajax检查用户名是否可用 true表示可用，false表示不可用
     * @param username
     * @return
     */
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
    
    /**
     * Ajax检查用户名是否可用 true表示可用，false表示不可用   
     * @param email
     * @return
     */
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
