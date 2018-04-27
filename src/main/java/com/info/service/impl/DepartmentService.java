package com.info.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.domain.entity.Department;
import com.info.domain.repository.DepartmentRepository;
import com.info.service.IDepartmentService;

@Service
public class DepartmentService implements IDepartmentService{
	@Autowired 
	private DepartmentRepository departmentRepository;

	public List<Department> findAll() {
		return departmentRepository.findAll();
	}
	@Override
	public List<Department> getAll() {
		return departmentRepository.findAll();
	}
	
}
