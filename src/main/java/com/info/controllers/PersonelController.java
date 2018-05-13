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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.info.domain.dto.EmployeeDTO;
import com.info.domain.dto.EvaluationEmployeeDTOList;
import com.info.domain.dto.ExperienceList;
import com.info.domain.entity.Department;
import com.info.domain.entity.Duty;
import com.info.domain.entity.EduLevel;
import com.info.domain.entity.Employee;
import com.info.domain.entity.EvaluationEmployee;
import com.info.domain.entity.Experience;
import com.info.domain.entity.Nation;
import com.info.domain.entity.Party;
import com.info.domain.entity.Rank;
import com.info.domain.pojo.EvaluationResult;
import com.info.service.impl.DepartmentService;
import com.info.service.impl.DutyService;
import com.info.service.impl.EduLevelService;
import com.info.service.impl.EmployeeService;
import com.info.service.impl.EvaluationService;
import com.info.service.impl.ExperienceService;
import com.info.service.impl.NationService;
import com.info.service.impl.PartyService;
import com.info.service.impl.RankService;
import com.info.utils.DateAndTimeUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.text.ParseException;

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
	
	@Autowired
	private ExperienceService experienceService;
	
	@Autowired
	private RankService rankService;
	
	@Autowired
	private DutyService dutyService;
	
	@Autowired
	private EduLevelService eduLevelService;
	
	@Autowired
	private NationService nationService;
	
	@Autowired
	private PartyService partyService;
	
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
		List<EvaluationEmployee> evaluationEmployees=evaluationService.getEvaluationEmployeesByObjectDepartmentExcludeSelf(loginEmoployee,loginEmoployee.getDepartment().getId());
		List<List<EvaluationEmployee>> evaEmployeess=evaluationService.sortByObject(evaluationEmployees);
		model.addAttribute("evaluationEmployeess", evaEmployeess);
		return "personel/evaluation-query";
	}
	
	//此专门为局级开设
	@GetMapping("/evaluationDept")
	public String evaluationDept(Model model) {
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
	
	/*****************************************************************************************************************************
	 * 人员信息管理业务
	 *****************************************************************************************************************************/
	@GetMapping("/employees/info/{deptId}")
	public String employeesInfo(Model model,@PathVariable Long deptId) {
		List<Department> departments=departmentService.findAll();
		model.addAttribute("departments", departments);
		List<Employee> employees=employeeService.getEmployeesByDepartment(deptId);
		model.addAttribute("employees",employees);
		return "personel/employees-info";
	}	
	
	@GetMapping("/employees/details/{empId}")
	public String employeesDetails(Model model,@PathVariable Long empId) {
		Employee employee=employeeService.getEmployeesById(empId).get();
		model.addAttribute("employee",employee);
		List<Experience> experiences=experienceService.getAllByEmployee(employee);
    	List<Department> departments=departmentService.getAll();
    	List<Rank> ranks=rankService.getAll();
    	List<Duty> dutys=dutyService.getAll();
    	List<EduLevel> eduLevels=eduLevelService.getAll();
    	List<Nation> nations=nationService.getAll();
    	List<Party> partys=partyService.getAll();
    	model.addAttribute("experiences", experiences);
    	model.addAttribute("departments", departments);
    	model.addAttribute("ranks", ranks);
    	model.addAttribute("dutys", dutys);
    	model.addAttribute("eduLevels", eduLevels);
    	model.addAttribute("nations", nations);
    	model.addAttribute("partys", partys);
		return "personel/employees-details";
	}
	
	/**
	 * Employee信息修改
	 * @param eDto:Employee的数据传输对象
	 * @return
	 */
	@PostMapping("/employees/mod")
	public String employeesMod(Employee eDto,BindingResult bResult) {
		if(bResult.hasErrors()) {
			return "redirect:/personel";
		}
		employeeService.update(eDto);
		return "redirect:/personel/employees/info/"+eDto.getDepartment().getId();
	}
	
	@PostMapping("/employees/experience/mod")
	public String employeesExperienceMod(@Valid ExperienceList eList,BindingResult bResult,HttpServletRequest request) throws ParseException{
		log.info(request.getParameter("id[0]"));
		log.info(request.getParameter("startTime[0]"));
		log.info(request.getParameter("endTime[0]"));
		log.info(request.getParameter("jobContent[0]"));
		log.info(request.getParameter("others[0]"));
		log.info(request.getParameter("employee[0]"));
		log.info(request.getParameter("id[1]"));
		log.info(request.getParameter("startTime[1]"));
		log.info(request.getParameter("endTime[1]"));
		log.info(request.getParameter("jobContent[1]"));
		log.info(request.getParameter("others[1]"));
		log.info(request.getParameter("employee[1]"));
		if(bResult.hasErrors()) {
			return "redirect:/personel";
		}
		experienceService.saveOrUpdate(eList);
		return "redirect:/personel";
	}
}
