package com.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {}
