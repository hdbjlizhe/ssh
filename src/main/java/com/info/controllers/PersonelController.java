package com.info.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.info.domain.entity.Employee;
import com.info.service.impl.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Controller
@RequestMapping("/personel")
public class PersonelController {
	
	@GetMapping("/evaluationQuarter")
	public String evaluationQuerter(Model model) {
		return "personel/evaluation-quarter";
	}
	
	@GetMapping("/evaluationMonth")
	public String evaluationMonth(Model model) {
		return "personel/evaluation-month";
	}
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/evaluationFill")//互评填报
	public String evaluationFill(Model model,HttpServletRequest request) {
		if(request.getSession().getAttribute("SPRING_SECURITY_CONTEXT")==null) {
			return "redirect:/login";
		}
		//1.获取登录用户user的employee
		Employee employee=employeeService.getLoginEmployee(request);
		//2.通过employee的部门获取所有属于此部门的员工employee
		List<Employee> employees=employeeService.getEmployeesByChosen(employee);
		//3.根据登录Employee的职务判断，处理employee
		model.addAttribute("employees", employees);
		return "personel/evaluation-fill";
	}
}
