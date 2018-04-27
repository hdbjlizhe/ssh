package com.info.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.info.domain.entity.Employee;
import com.info.domain.entity.Experience;
import com.info.domain.repository.ExperienceRepository;
import com.info.service.IExperienceService;

import org.springframework.stereotype.Service;

@Service
public class ExperienceService implements IExperienceService{

	@Autowired
	private ExperienceRepository experienceRepository;
	
	
	@Override
	public List<Experience> getAllByEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return experienceRepository.findByEmployee(employee);
	}

}
