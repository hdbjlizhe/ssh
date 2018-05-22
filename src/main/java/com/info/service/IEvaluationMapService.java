package com.info.service;

import java.util.List;

import com.info.domain.entity.EvaluationMap;

public interface IEvaluationMapService {

	List<EvaluationMap> getAll();

	EvaluationMap saveOrUpdate(EvaluationMap evaluationMap);

}
