package com.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info.entities.Privilege;

public interface PrivilegeRepository extends JpaRepository<Privilege, Integer> {

}
