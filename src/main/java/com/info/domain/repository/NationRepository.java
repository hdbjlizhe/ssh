package com.info.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info.domain.entity.Nation;

public interface NationRepository extends JpaRepository<Nation, Long> {

}
