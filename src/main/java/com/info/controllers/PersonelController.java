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

import com.info.domain.dto.EvaluationEmployeeListDTO;
import com.info.domain.dto.EvaluationMapListDTO;
import com.info.domain.dto.ExperienceList;
import com.info.domain.entity.Department;
import com.info.domain.entity.Duty;
import com.info.domain.entity.EduLevel;
import com.info.domain.entity.Employee;
import com.info.domain.entity.EvaluationEmployee;
import com.info.domain.entity.EvaluationMap;
import com.info.domain.entity.Experience;
import com.info.domain.entity.Nation;
import com.info.domain.entity.Party;
import com.info.domain.entity.Rank;
import com.info.domain.pojo.EvaluationResult;
import com.info.service.IDepartmentService;
import com.info.service.IDutyService;
import com.info.service.IEduLevelService;
import com.info.service.IEmployeeService;
import com.info.service.IEvaluationMapService;
import com.info.service.IEvaluationEmployeeService;
import com.info.service.IExperienceService;
import com.info.service.INationService;
import com.info.service.IPartyService;
import com.info.service.IRankService;
import com.info.utils.DateAndTimeUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
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
	private IEmployeeService employeeService;
	
	@Autowired
	private IEvaluationEmployeeService evaluationEmployeeService;
	
	@Autowired
	private IDepartmentService departmentService;
	
	@Autowired
	private IExperienceService experienceService;
	
	@Autowired
	private IRankService rankService;
	
	@Autowired
	private IDutyService dutyService;
	
	@Autowired
	private IEduLevelService eduLevelService;
	
	@Autowired
	private INationService nationService;
	
	@Autowired
	private IPartyService partyService;

	@Autowired
	private IEvaluationMapService evaluationMapService;
	
	/***********************************************************************************************
	 * 
	 ************************************************************************************************/
	
	/**
	 * 互评填报的页面
	 * @param model
	 * @param request
	 * @return
	 */
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
		model.addAttribute("loginEmployee", employee);
		model.addAttribute("season",season);
		model.addAttribute("evaluationEmployees", evaluationEmployees);
		model.addAttribute("message","");
		return "personel/evaluation-fill";
	}
	
	/**
	 * 	此函数为Ajax函数
	 * @param evaluationEmployees
	 * @param bResult
	 * @param request
	 * @return
	 */
	@PostMapping("/evaluationSeason")
	public String evaluationSeason(@Valid EvaluationEmployeeListDTO evaluationEmployees,BindingResult bResult,HttpServletRequest request) {
		if(bResult.hasErrors()) {
			return "redirect:personel/evaluationFill";
		}
		//获取登录用户
		Employee employee=employeeService.getLoginEmployee(request);
		//数据存储
		for(EvaluationEmployee evaluationEmployee:evaluationEmployees.getEvaluationEmployees()) {
			evaluationEmployee.setFromWhom(employee);
			evaluationEmployee.setSum();
			evaluationEmployeeService.update(evaluationEmployee);
		}
		return "personel/evaluation-success";
	}

	//为处级正职开设
	@GetMapping("/evaluationQuery")
	public String evaluationQuery(Model model,HttpServletRequest request) {
		Employee loginEmoployee=employeeService.getLoginEmployee(request);
		List<EvaluationEmployee> evaluationEmployees=evaluationEmployeeService.getEvaluationEmployeesByObjectDepartmentExcludeSelf(loginEmoployee,loginEmoployee.getDepartment().getId());
		List<List<EvaluationEmployee>> evaEmployeess=evaluationEmployeeService.sortByObject(evaluationEmployees);
		model.addAttribute("evaluationEmployeess", evaEmployeess);
		List<Float> sums=new ArrayList<Float>();
		for(List<EvaluationEmployee> evaEmployees:evaEmployeess) {
			Float tmpSum=0f;
			for(EvaluationEmployee evaluationEmployee:evaEmployees) {
				tmpSum+=evaluationEmployee.getSum();
			}
			sums.add(tmpSum);
		}
		model.addAttribute("sums", sums);
		return "personel/evaluation-query";
	}
	
	//此专门为局级开设
	@GetMapping("/evaluationDept")
	public String evaluationDept(Model model) {
		List<Department> departments=departmentService.getAll();
		model.addAttribute("departments", departments);
		List<EvaluationResult> evaluationResults=evaluationEmployeeService.getAllEvaluationResult();
		model.addAttribute("evaluationResults",evaluationResults);
		return "personel/evaluation-dept";
	}
	//此地址专门为局级开设
	@GetMapping("/evaluationDept/{deptId}")
	public String evaluationQuery(Model model,@PathVariable @NotNull @NotEmpty String deptId) {
		List<Department> departments=departmentService.getAll();
		model.addAttribute("departments", departments);
		List<EvaluationEmployee> evaluationEmployees=evaluationEmployeeService.getEvaluationEmployeesByObjectDepartment(Long.parseLong(deptId));
		model.addAttribute("evaluationEmployees",evaluationEmployees);
		return "personel/evaluation-dept";
	}
	
	@GetMapping("/evaluationSettings")
	public String evaluationSettings(Model model) {
		List<Duty> duties=dutyService.getAll();
		model.addAttribute("objects", duties);		
		List<EvaluationMap> evaluationMaps= evaluationMapService.getAll();
		model.addAttribute("evaluationMaps", evaluationMaps);
		return "personel/evaluation-settings";
	}
	
	@PostMapping("/evaluationSettings")
	public String evaluationSettings(EvaluationMapListDTO evaluationMaps) {
		for(EvaluationMap evaluationMap:evaluationMaps.getEvaluationMaps()) {
			evaluationMapService.saveOrUpdate(evaluationMap);
		}
		return "personel/evaluation-settings-success";
	}
	
	/*****************************************************************************************************************************
	 * 人员信息管理业务
	 *****************************************************************************************************************************/
	@GetMapping("/employees/info/{deptId}")
	public String employeesInfo(Model model,@PathVariable Long deptId) {
		Department department=departmentService.getById(deptId);
		model.addAttribute("department", department);
		List<Department> departments=departmentService.getAll();
		model.addAttribute("departments", departments);
		List<Employee> employees=employeeService.getEmployeesByDepartment(deptId);
		model.addAttribute("employees",employees);
		return "personel/employees-info";
	}
	
	@GetMapping("/employees/details/{empId}")
	public String employeesDetails(Model model,@PathVariable Long empId) {
		Employee employee=employeeService.getEmployeesById(empId);
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
	
	@GetMapping("/employees/delete/{empId}")
	public String employeesDelete(Model model,@PathVariable Long empId) {	
		Employee employee=employeeService.getEmployeesById(empId);	
		Long depId=employee.getDepartment().getId();
		employee.init();
		employeeService.update(employee);
		return "redirect:/personel/employees/info/"+depId;
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
	
	/**
	 * 职工的经历——修改
	 * @param eList
	 * @param bResult
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@PostMapping("/employees/experience/mod")
	public String employeesExperienceMod(@Valid ExperienceList eList,BindingResult bResult,HttpServletRequest request) throws ParseException{
		Long depId=eList.getExperiences().get(0).getEmployee().getDepartment().getId();
		if(bResult.hasErrors()) {
			return "redirect:/personel";
		}
		experienceService.saveOrUpdate(eList);
		if(depId!=null) {
			return "redirect:/personel/employees/info/"+depId;
		}else
			return "redirect:/personel";
	}
}
