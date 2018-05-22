package com.info.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.domain.entity.DepartStatistics;
import com.info.domain.repository.DepartStatisticsRepository;
import com.info.service.IDepartStatisticsService;
import com.info.utils.DateAndTimeUtil;

@Service
public class DepartStatisticsServiceImpl implements IDepartStatisticsService {
	
	@Autowired
	private DepartStatisticsRepository departStatisticsRepository;

	@Override
	public List<DepartStatistics> findPreOneByMonth() {
		SimpleDateFormat dFormat=new SimpleDateFormat("yyyy-MM-dd");
		String currentDate=dFormat.format(new Date());
		String month=DateAndTimeUtil.getPreMonth(currentDate);
		return departStatisticsRepository.findByMonth(month);
	}
		
	@Override
	public List<DepartStatistics> getByMonth(String month){
		return departStatisticsRepository.findByMonth(month);
	}

}
