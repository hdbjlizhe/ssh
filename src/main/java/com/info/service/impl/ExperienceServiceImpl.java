package com.info.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.info.domain.dto.ExperienceList;
import com.info.domain.entity.Employee;
import com.info.domain.entity.Experience;
import com.info.domain.repository.ExperienceRepository;
import com.info.service.IExperienceService;

import org.springframework.stereotype.Service;

@Service
public class ExperienceServiceImpl implements IExperienceService{

	@Autowired
	private ExperienceRepository experienceRepository;
		
	@Override
	public List<Experience> getAllByEmployee(Employee employee) {
		return experienceRepository.findByEmployee(employee);
	}
	@Override
	public void saveOrUpdate(Experience experience) {
		experienceRepository.save(experience);
	}
	@Override
	public void saveOrUpdate(ExperienceList experiences){
		if(experiences!=null) {
			for(Experience experience:experiences.getExperiences()) {
				experienceRepository.save(experience);
			}
		}
	}

}
