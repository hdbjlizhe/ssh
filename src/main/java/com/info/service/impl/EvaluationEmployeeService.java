package com.info.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.domain.EvaluationEmployee;
import com.info.domain.repository.EvaluationEmployeeRepository;
import com.info.service.IEvaluationEmployeeService;
@Service
public class EvaluationEmployeeService implements IEvaluationEmployeeService {
	@Autowired
	EvaluationEmployeeRepository evaluationEmployeeRepository;
	
	public Optional<EvaluationEmployee> getById(Long id) {
		return evaluationEmployeeRepository.findById(id);
	}
}
