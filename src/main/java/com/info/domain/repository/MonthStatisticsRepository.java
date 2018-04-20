package com.info.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.info.domain.MonthStatistics;

public interface MonthStatisticsRepository extends JpaRepository<MonthStatistics,Long> {

}
