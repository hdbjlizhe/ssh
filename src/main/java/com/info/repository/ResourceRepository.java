package com.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info.entities.Resource;

public interface ResourceRepository extends JpaRepository<Resource, Integer>{
	
}
