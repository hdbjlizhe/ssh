package com.zhelee.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zhelee.info.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {}