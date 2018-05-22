package com.info.service;

import java.util.List;
import java.util.Optional;

import com.info.domain.entity.Employee;
import com.info.domain.entity.EvaluationEmployee;
import com.info.domain.pojo.EvaluationResult;

public interface IEvaluationEmployeeService {

	List<EvaluationResult> getAllEvaluationResult();

	List<List<EvaluationEmployee>> sortByObject(List<EvaluationEmployee> eEmployees);

	List<EvaluationEmployee> getEvaluationEmployeesByObjectDepartmentExcludeSelf(Employee loginEmoployee, Long deptId);

	List<EvaluationEmployee> getEvaluationEmployeesByObjectDepartment(Long deptId);

	List<EvaluationEmployee> getAllEvaluationEmployee();

	EvaluationEmployee update(EvaluationEmployee evaluationEmployee);

	List<EvaluationEmployee> getBySeasonFromTo(String season, Employee employeeFrom, List<Employee> employeesTo);

	Optional<EvaluationEmployee> getEvaluationEmployeeById(Long id);

}
