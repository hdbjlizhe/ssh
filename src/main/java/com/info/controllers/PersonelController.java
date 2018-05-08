package com.info.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.info.domain.EvaluationEmployee;
import com.info.domain.dto.EvaluationEmployeeDTOList;
import com.info.domain.entity.Department;
import com.info.domain.entity.Employee;
import com.info.domain.pojo.EvaluationResult;
import com.info.service.impl.DepartmentService;
import com.info.service.impl.EmployeeService;
import com.info.service.impl.EvaluationService;
import com.info.utils.DateAndTimeUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Controller
@RequestMapping("/personel")
public class PersonelController {
	
	
	private static final Logger log = LoggerFactory.getLogger(PersonelController.class);
	
	/************************************************************************************************
	 * Bean
	 ************************************************************************************************/
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EvaluationService evaluationService;
	
	@Autowired
	private DepartmentService departmentService;
	
	/***********************************************************************************************
	 * 
	 ************************************************************************************************/
	@GetMapping("/evaluationFill")//互评填报
	public String evaluationFill(Model model,HttpServletRequest request) {
		if(request.getSession().getAttribute("SPRING_SECURITY_CONTEXT")==null) {
			return "redirect:/login";
		}
		//1.获取登录用户user的employee
		Employee employee=employeeService.getLoginEmployee(request);
		//2.通过employee的部门获取所有属于此部门的员工employee
		List<Employee> employees=employeeService.getEmployeesByChosen(employee);
		//3.获取评分数据
		String season=DateAndTimeUtil.getSeason();//获取当前季度的前一个季度
		List<EvaluationEmployee> evaluationEmployees=evaluationService.getBySeasonFromTo(season,employee,employees);
		//4.根据登录Employee的职务判断，处理employee
		model.addAttribute("loginEmployee", employee);
		model.addAttribute("season",season);
		model.addAttribute("evaluationEmployees", evaluationEmployees);
		return "personel/evaluation-fill";
	}
		
	@PostMapping("/evaluationSeason")
	public String evaluationSeason(@Valid EvaluationEmployeeDTOList evaluationEmployees,BindingResult bResult,HttpServletRequest request,Model model) {
		if(bResult.hasErrors()) {
			return "redirect:/personel/evaluation-fill";
		}
		//数据存储
		evaluationService.update(evaluationEmployees,employeeService.getLoginEmployee(request));
		return "redirect:/personel/evaluationFill";
	}

	//为处级正职开设
	@GetMapping("/evaluationQuery")
	public String evaluationQuery(Model model,HttpServletRequest request) {
		Employee loginEmoployee=employeeService.getLoginEmployee(request);
		//Department department=loginEmoployee.getDepartment();
		List<EvaluationEmployee> evaluationEmployees=evaluationService.getEvaluationEmployeesByObjectDepartment(loginEmoployee.getDepartment().getId());
		model.addAttribute("evaluationEmployees", evaluationEmployees);
		return "personel/evaluation-query";
	}
	
	//此专门为局级开设
	@GetMapping("/evaluationDept")
	public String evaluationDept(Model model,HttpServletRequest request) {
		List<Department> departments=departmentService.findAll();
		model.addAttribute("departments", departments);
		List<EvaluationResult> evaluationResults=evaluationService.getAllEvaluationResult();
		model.addAttribute("evaluationResults",evaluationResults);
		return "personel/evaluation-dept";
	}
	//此地址专门为局级开设
	@GetMapping("/evaluationDept/{deptId}")
	public String evaluationQuery(Model model,@PathVariable @NotNull @NotEmpty String deptId) {
		List<Department> departments=departmentService.findAll();
		model.addAttribute("departments", departments);
		List<EvaluationEmployee> evaluationEmployees=evaluationService.getEvaluationEmployeesByObjectDepartment(Long.parseLong(deptId));
		model.addAttribute("evaluationEmployees",evaluationEmployees);
		return "personel/evaluation-dept";
	}
}
