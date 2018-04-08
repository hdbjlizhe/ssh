package com.info.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info.domain.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
