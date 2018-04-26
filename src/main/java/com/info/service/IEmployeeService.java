package com.info.service;

import com.info.domain.entity.Employee;
import javax.servlet.http.HttpServletRequest;

public interface IEmployeeService {
	
	Employee createNewEmployee(Employee employee);
	
	Employee getLoginEmployee(HttpServletRequest request);
}
