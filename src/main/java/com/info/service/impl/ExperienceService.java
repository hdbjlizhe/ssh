package com.info.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.info.domain.dto.ExperienceList;
import com.info.domain.entity.Employee;
import com.info.domain.entity.Experience;
import com.info.domain.repository.EmployeeRepository;
import com.info.domain.repository.ExperienceRepository;
import com.info.service.IExperienceService;

import org.springframework.stereotype.Service;

@Service
public class ExperienceService implements IExperienceService{

	@Autowired
	private ExperienceRepository experienceRepository;
		
	@Override
	public List<Experience> getAllByEmployee(Employee employee) {
		return experienceRepository.findByEmployee(employee);
	}

	public void saveOrUpdate(Experience experience) {
		experienceRepository.save(experience);
	}
	
	public void saveOrUpdate(ExperienceList experiences){
		if(experiences!=null) {
			for(Experience experience:experiences.getExperiences()) {
				experienceRepository.save(experience);
			}
		}
	}

}
