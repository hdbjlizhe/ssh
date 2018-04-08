package com.info.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info.domain.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {}
