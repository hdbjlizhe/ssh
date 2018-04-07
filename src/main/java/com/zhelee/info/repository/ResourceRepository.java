package com.zhelee.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zhelee.info.entities.Resource;

public interface ResourceRepository extends JpaRepository<Resource, Integer>{
	
}
