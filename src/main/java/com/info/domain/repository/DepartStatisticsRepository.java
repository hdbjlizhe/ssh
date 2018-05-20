package com.info.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info.domain.entity.DepartStatistics;
import java.lang.String;

public interface DepartStatisticsRepository extends JpaRepository<DepartStatistics, Long> {

	List<DepartStatistics> findByMonth(String month);
}
