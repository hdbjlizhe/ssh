package com.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
