package com.info.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.info.domain.EvaluationEmployee;
import com.info.domain.dto.EvaluationEmployeeDTO;
import com.info.domain.entity.Employee;
import com.info.service.impl.EmployeeService;
import com.info.service.impl.EvaluationEmployeeService;

import org.hibernate.dialect.DataDirectOracle9Dialect;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.util.Date;
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
	
	@Autowired
	EvaluationEmployeeService evaluationEmployeeService;
	
	@PostMapping("/evaluationSeason")
	public String evaluationSeason(List<EvaluationEmployeeDTO> eDtos,BindingResult bResult,HttpServletRequest request,Model model) {
		if(bResult.hasErrors()) {
			return "redirect:/personel/evaluation-fill";
		}
		for(EvaluationEmployeeDTO eDto:eDtos) {
			EvaluationEmployee evaluationEmployee=null;
			if(eDto.getId()!=null) {
				evaluationEmployee=evaluationEmployeeService.getById(eDto.getId()).get();}
			else {
				evaluationEmployee=new EvaluationEmployee();
				evaluationEmployee.setCreateTime(new Date());
			}			
				evaluationEmployee.setAbility(eDto.getAbility());
				evaluationEmployee.setAchievement(eDto.getAchievement());
				evaluationEmployee.setDiligence(eDto.getDiligence());
				evaluationEmployee.setHonest(eDto.getHonest());
				evaluationEmployee.setMorality(eDto.getMorality());
				//evaluationEmployee.setSeason(season);
				evaluationEmployee.setSum();
				//Employee employeeFrom=employeeService.getLoginEmployee(request);
				//evaluationEmployee.setFromWho(eDto.getFromWho());
				//Employee employeeTo=employeeService.getEmployeeById(eDto.getToWhom()).get();
				//evaluationEmployee.setToWhom(employeeTo);
				evaluationEmployee.setUpdateTime(new Date());
		}
		return "redirect:/personel/evaluation-fill";
	}
}
