package com.info.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.domain.MonthStatistics;
import com.info.domain.repository.MonthStatisticsRepository;

@Service
public class MonthStatisticsService {
	@Autowired
	private MonthStatisticsRepository monthStatisticsRepository;

	public MonthStatistics findByMonth(String month) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
