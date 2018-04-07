package com.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
