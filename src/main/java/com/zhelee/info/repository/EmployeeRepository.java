package com.zhelee.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zhelee.info.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
