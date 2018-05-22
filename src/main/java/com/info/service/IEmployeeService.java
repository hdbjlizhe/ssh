package com.info.service;

import com.info.domain.entity.Department;
import com.info.domain.entity.Employee;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface IEmployeeService {
	
	Employee createNewEmployee(Employee employee);
	
	Employee getLoginEmployee(HttpServletRequest request);

	List<Employee> getEmployeesByChosen(Employee employee);

	Employee getEmployeeById(Long toWhom);

	List<Employee> getEmployeesByDepartment(Long deptId);
	
	List<Employee> getEmployeesByDepartment(Department department);
	
	Employee update(Employee employee);

	Employee getEmployeesById(Long empId);
}
