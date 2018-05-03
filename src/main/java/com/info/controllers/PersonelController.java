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
import com.info.domain.dto.EvaluationEmployeeDTO;
import com.info.domain.dto.EvaluationEmployeeDTOList;
import com.info.domain.entity.Employee;
import com.info.service.impl.EmployeeService;
import com.info.service.impl.EvaluationEmployeeService;
import com.info.utils.DateAndTimeUtil;

import org.hibernate.dialect.DataDirectOracle9Dialect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.Date;
import java.util.Enumeration;
import java.util.List;

@Controller
@RequestMapping("/personel")
public class PersonelController {
	
	
	private static final Logger log = LoggerFactory.getLogger(PersonelController.class);
	
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
		//3.获取评分数据
		String season=DateAndTimeUtil.getSeason();//获取当前季度的前一个季度
		List<EvaluationEmployee> evaluationEmployees=evaluationEmployeeService.getBySeasonFromTo(season,employee,employees);
		//4.根据登录Employee的职务判断，处理employee
		//model.addAttribute("employees", employees);
		model.addAttribute("season",season);
		model.addAttribute("evaluationEmployees", evaluationEmployees);
		return "personel/evaluation-fill";
	}
	
	@Autowired
	EvaluationEmployeeService evaluationEmployeeService;
	
	@PostMapping("/evaluationSeason")
	public String evaluationSeason(@Valid EvaluationEmployeeDTOList evaluationEmployees,BindingResult bResult,HttpServletRequest request,Model model) {
		if(bResult.hasErrors()) {
			return "redirect:/personel/evaluation-fill";
		}
			
		for(EvaluationEmployeeDTO eEmployee:evaluationEmployees.getEvaluationEmployees()) {	
			//1.从数据库获取记录
			EvaluationEmployee evaluationEmployee=evaluationEmployeeService.getById(Long.parseLong(eEmployee.getId())).get();			
			//2.赋值
			evaluationEmployee.setSeason(eEmployee.getSeason());
			evaluationEmployee.setAbility(Float.parseFloat(eEmployee.getAbility()));
			evaluationEmployee.setAchievement(Float.parseFloat(eEmployee.getAchievement()));
			evaluationEmployee.setDiligence(Float.parseFloat(eEmployee.getDiligence()));
			evaluationEmployee.setHonest(Float.parseFloat(eEmployee.getHonest()));
			evaluationEmployee.setMorality(Float.parseFloat(eEmployee.getMorality()));
			evaluationEmployee.setSum();
			//3.获取登录用户user的employee
			Employee fromWhom=employeeService.getLoginEmployee(request);
			evaluationEmployee.setFromWhom(fromWhom);
			//4.获取评价对象
			Employee toWhom=employeeService.getEmployeeById(Long.parseLong(eEmployee.getToWhom())).get();
			evaluationEmployee.setToWhom(toWhom);				
			evaluationEmployee.setUpdateTime(new Date());
			//5.存到数据库
			evaluationEmployeeService.update(evaluationEmployee);
		}
		return "redirect:/personel/evaluationFill";
	}

	@GetMapping("/personal/evaluationQuery")
	public String evaluationQuery(Model model) {
		return "/personal/evaluation-query";
	}
	
	@GetMapping("/personal/evaluationQuery/{deptId}")
	public String evaluationQuery(Model model,@PathVariable @NotNull @NotEmpty Long deptId) {
		//根据
		return "/personal/evaluation-query";
	}

}
