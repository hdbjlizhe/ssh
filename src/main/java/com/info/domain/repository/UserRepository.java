package com.info.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info.domain.entity.User;

public interface UserRepository extends JpaRepository<User , Long> {

    User findByUsername(String username);

    User findByEmail(String eamil);

}
