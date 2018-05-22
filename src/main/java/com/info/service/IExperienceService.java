package com.info.service;

import java.util.List;

import com.info.domain.dto.ExperienceList;
import com.info.domain.entity.Employee;
import com.info.domain.entity.Experience;

public interface IExperienceService {
	List<Experience> getAllByEmployee(Employee employee);

	void saveOrUpdate(Experience experience);

	void saveOrUpdate(ExperienceList experiences);
}
