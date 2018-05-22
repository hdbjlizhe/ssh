package com.info.service;

import java.util.List;

import com.info.domain.entity.DepartStatistics;

public interface IDepartStatisticsService {

	List<DepartStatistics> findPreOneByMonth();

	List<DepartStatistics> getByMonth(String rltMonth);

}
