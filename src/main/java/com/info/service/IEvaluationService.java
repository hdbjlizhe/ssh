package com.info.service;

import java.util.List;
import java.util.Optional;

import com.info.domain.entity.Employee;
import com.info.domain.entity.EvaluationEmployee;
import com.info.domain.pojo.EvaluationResult;

public interface IEvaluationService {

	List<EvaluationEmployee> getBySeasonFromTo(String season, Employee employee, List<Employee> employees);

	void update(EvaluationEmployee evaluationEmployee);

	List<EvaluationEmployee> getEvaluationEmployeesByObjectDepartmentExcludeSelf(Employee loginEmoployee, Long id);

	List<List<EvaluationEmployee>> sortByObject(List<EvaluationEmployee> evaluationEmployees);

	List<EvaluationResult> getAllEvaluationResult();

	List<EvaluationEmployee> getEvaluationEmployeesByObjectDepartment(long parseLong);

	Optional<EvaluationEmployee> getEvaluationEmployeeById(Long id);

}
