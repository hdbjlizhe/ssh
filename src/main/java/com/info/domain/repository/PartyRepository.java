package com.info.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info.domain.entity.Party;

public interface PartyRepository extends JpaRepository<Party, Long> {

}
