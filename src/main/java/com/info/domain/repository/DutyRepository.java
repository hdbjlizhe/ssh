package com.info.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info.domain.entity.Duty;

public interface DutyRepository extends JpaRepository<Duty, Long> {

}
