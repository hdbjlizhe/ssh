package com.info.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info.domain.entity.ValidateToken;

public interface ValidateTokenRepository extends JpaRepository<ValidateToken,Long> {

    ValidateToken findByToken(String token);
}
