package com.info.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.domain.entity.Employee;
import com.info.domain.repository.EmployeeRepository;
import com.info.service.IEmployeeService;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee createNewEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

}
