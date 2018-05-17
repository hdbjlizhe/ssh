package com.info.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.domain.entity.EvaluationMap;
import com.info.domain.repository.EvaluationMapRepository;

@Service
public class EvaluationMapService {
	
	@Autowired
	private EvaluationMapRepository evaluationMapRepository;
	
	public List<EvaluationMap> getAll(){
		return evaluationMapRepository.findAll();
	}

	public EvaluationMap saveOrUpdate(EvaluationMap evaluationMap) {
		return evaluationMapRepository.save(evaluationMap);
	}
}
