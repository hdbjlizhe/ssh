package com.info.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.domain.entity.Department;
import com.info.domain.repository.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired 
	private DepartmentRepository departmentRepository;

	public List<Department> findAll() {
		return departmentRepository.findAll();
	}
	
}
