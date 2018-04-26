package com.info.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info.domain.entity.Department;
import com.info.domain.entity.Employee;

import java.util.List;
import com.info.domain.entity.Duty;

/**
 * @author Administrator
 *
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	List<Employee> findByDuty(Duty duty);
	List<Employee> findByDepartment(Department department);

}
