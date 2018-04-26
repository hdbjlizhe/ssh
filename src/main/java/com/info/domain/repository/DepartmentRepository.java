package com.info.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info.domain.entity.Department;
import com.info.domain.entity.Employee;
import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	
	List<Department> findByDeputyBureau(Employee deputybureau);
}
