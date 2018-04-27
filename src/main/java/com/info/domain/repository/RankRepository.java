package com.info.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info.domain.entity.Rank;
import java.lang.String;
import java.util.List;

public interface RankRepository extends JpaRepository<Rank, Long> {

	List<Rank> findByRankName(String rankname);
}
