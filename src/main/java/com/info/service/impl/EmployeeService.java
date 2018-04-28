package com.info.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Service;

import com.info.domain.EvaluationMap;
import com.info.domain.entity.Department;
import com.info.domain.entity.Employee;
import com.info.domain.entity.User;
import com.info.domain.repository.DepartmentRepository;
import com.info.domain.repository.EmployeeRepository;
import com.info.domain.repository.EvaluationMapRepository;
import com.info.domain.repository.UserRepository;
import com.info.service.IEmployeeService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Service
public class EmployeeService implements IEmployeeService {
	
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private EvaluationMapRepository evaluationMapRepository;
	
	@Override
	public Employee createNewEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	/**
	 * 获取当前登录用户的employee
	 * @param request
	 * @return
	 */
	public Employee getLoginEmployee(HttpServletRequest request) {
		SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");			
		log.info("Username:"+securityContextImpl.getAuthentication().getName());
		String username=securityContextImpl.getAuthentication().getName();
		User loginUser= userRepository.findByUsername(username);
		return loginUser.getEmployeee();		
	}
	
	/**
	 * 通过部门获取所有的employee
	 * @param department
	 * @return
	 */
	public List<Employee> getEmployeesByDepartment(Department department) {
		return employeeRepository.findByDepartment(department);
	}
	
	
	/**
	 * 获取指定的
	 * @param employee 登录用户
	 * @param department
	 * @return
	 */
	public List<Employee> getEmployeesByChosen(Employee employee) {
		
//		int weight=employee.getDuty().getWeight();
//		//首先判断employee的级别
//		List<EvaluationMap> evaluationMaps=evaluationMapRepository.findByScorer(weight);
//		//获取打分者级别
//		List<Employee> employees=null;
//		for(EvaluationMap evaluationMap:evaluationMaps) {
//				
//		}
//		//然后去找登录用户作这个级别打分人所对应的打分对象并返回
				
		List<Employee> employees=new ArrayList<Employee>();
		if(employee.getDuty()!=null) {			
			//1.如果employee是普通科员、处级副职、处级正职
			if(employee.getDuty().getWeight()<=5) {
				//获取此员式所在部门的所有员工
				employees=getEmployeesByDepartment(employee.getDepartment());
				//减掉此员工自己
				employees.remove(employee);
				List<Employee> rltEmployees=new ArrayList<>(employees);
				//rltEmployees=employees;
				int level=employee.getDuty().getWeight();
				for(Employee emp:employees) {
					if(emp.getDuty().getWeight()>level) {//扣除职务高的人
						rltEmployees.remove(emp);
					}
				}
				return rltEmployees;
			}
			//2.如果employee是局级副职
			else if(employee.getDuty().getWeight()==6) {				
				//返回所分管的处室的正职和副职
				List<Department> departments=departmentRepository.findByDeputyBureau(employee);
				for(Department dep:departments) {
					employees.add(dep.getDepartmentPrincipal());
					employees.add(dep.getDepartmentDeputy());
				}
				employees.removeAll(Collections.singleton(null));//滤除null对象
				return employees;
			}
			//3.如果employee是局级正职
			else if(employee.getDuty().getWeight()==7) {
				//返回各处室正职
				List<Department> departments=departmentRepository.findAll();
				for(Department dep:departments) {
					if(dep.getDepartmentPrincipal()!=null)
						employees.add(dep.getDepartmentPrincipal());
				}
				employees.removeAll(Collections.singleton(null));//滤除null对象
				employees.remove(employee);//滤除自己
				return employees;
			}
		}
		
		return null;
	}

}
