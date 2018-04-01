package com.zhelee.info.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhelee.info.entities.Department;
import com.zhelee.info.repository.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired 
	private DepartmentRepository departmentRepository;

	public List<Department> findAll() {
		return departmentRepository.findAll();
	}
	
}
