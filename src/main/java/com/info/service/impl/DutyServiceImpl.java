package com.info.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.domain.entity.Duty;
import com.info.domain.repository.DutyRepository;
import com.info.service.IDutyService;

@Service
public class DutyServiceImpl implements IDutyService {

	@Autowired
	private DutyRepository dutyRepository;
	
	@Override
	public List<Duty> getAll() {
		return dutyRepository.findAll();
	}

}
