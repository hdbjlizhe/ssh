package com.info.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.info.domain.entity.MonthStatistics;

import java.lang.String;
@Repository
public interface MonthStatisticsRepository extends JpaRepository<MonthStatistics,Long> {

	MonthStatistics findByMonth(String month);
	
}
