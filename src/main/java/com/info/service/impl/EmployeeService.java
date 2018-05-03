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
import java.util.List;
import java.util.Optional;

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
	 * 
	 * @param request
	 * @return
	 */
	public Employee getLoginEmployee(HttpServletRequest request) {
		SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession()
				.getAttribute("SPRING_SECURITY_CONTEXT");
		log.info("Username:" + securityContextImpl.getAuthentication().getName());
		String username = securityContextImpl.getAuthentication().getName();
		User loginUser = userRepository.findByUsername(username);
		return loginUser.getEmployeee();
	}

	/**
	 * 通过部门获取所有的employee
	 * 
	 * @param department
	 * @return
	 */
	public List<Employee> getEmployeesByDepartment(Department department) {
		return employeeRepository.findByDepartment(department);
	}

	/**
	 * 获取指定的
	 * 
	 * @param employee
	 *            登录用户
	 * @param department
	 * @return
	 */
	public List<Employee> getEmployeesByChosen(Employee employee) {

		List<Employee> rltEmployees = new ArrayList<Employee>();

		int weight = employee.getDuty().getWeight();

		List<EvaluationMap> tmpEvaluationMaps = new ArrayList<EvaluationMap>();
		List<EvaluationMap> evaluationMaps = evaluationMapRepository.findAll();

		for (EvaluationMap evaluation : evaluationMaps) {
			if (evaluation.getMaxScorer().getWeight() >= weight && evaluation.getMinScorer().getWeight() <= weight) {
				tmpEvaluationMaps.add(evaluation);
			}
		}

		for (EvaluationMap evaluation : tmpEvaluationMaps) {
			if (evaluation.isDepartDivided()) {// 区分部门的情况，按部门查找
				rltEmployees.addAll(employeeRepository.findByDepartmentAndDutyAndFormal(employee.getDepartment(),
						evaluation.getObject(), evaluation.isExcludInformal()));
				if(!evaluation.isIncludingSelf())
					rltEmployees.remove(employee);
			} else {// 不区分部门的情况下，就按职务查找
				List<Department> depts = departmentRepository.findByDeputyBureau(employee);
				if (depts.size() >= 1) {// 副局长
					for (Department dept : depts) {
						rltEmployees.addAll(employeeRepository.findByDepartmentAndDutyAndFormal(dept,
								evaluation.getObject(), evaluation.isExcludInformal()));
					}
				} else {// 局长
					rltEmployees = employeeRepository.findByDuty(evaluation.getObject());
				}
			}
		}

		return rltEmployees;
	}

	public Optional<Employee> getEmployeeById(Long toWhom) {
		return employeeRepository.findById(toWhom);
	}

}
