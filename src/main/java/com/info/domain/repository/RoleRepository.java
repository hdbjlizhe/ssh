package com.info.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info.domain.entity.Role;

public interface RoleRepository extends JpaRepository<Role,Long>{
}
