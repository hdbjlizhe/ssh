package com.zhelee.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zhelee.info.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {}
