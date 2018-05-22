package com.info.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.domain.entity.EvaluationMap;
import com.info.domain.repository.EvaluationMapRepository;
import com.info.service.IEvaluationMapService;

@Service
public class EvaluationMapServiceImpl implements IEvaluationMapService {
	
	@Autowired
	private EvaluationMapRepository evaluationMapRepository;
	
	@Override
	public List<EvaluationMap> getAll(){
		return evaluationMapRepository.findAll();
	}

	@Override
	public EvaluationMap saveOrUpdate(EvaluationMap evaluationMap) {
		return evaluationMapRepository.save(evaluationMap);
	}
}
