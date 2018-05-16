package com.info.domain.dto;

import java.util.List;

import com.info.domain.entity.EvaluationEmployee;

public class EvaluationEmployeeListDTO {
	
	private List<EvaluationEmployee> evaluationEmployees;

	public List<EvaluationEmployee> getEvaluationEmployees() {
		return evaluationEmployees;
	}

	public void setEvaluationEmployees(List<EvaluationEmployee> evaluationEmployees) {
		this.evaluationEmployees = evaluationEmployees;
	}
	
}
