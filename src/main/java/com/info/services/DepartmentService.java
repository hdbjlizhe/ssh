package com.info.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.entities.Department;
import com.info.repository.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired 
	private DepartmentRepository departmentRepository;

	public List<Department> findAll() {
		return departmentRepository.findAll();
	}
	
}
