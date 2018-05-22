package com.info.service;

import java.util.List;

import com.info.domain.entity.DepartStatistics;
import com.info.domain.entity.Department;

public interface IDepartmentService {

	List<Department> getAll();

	Department getById(Long deptId);
}
