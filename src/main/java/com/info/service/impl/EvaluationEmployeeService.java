package com.info.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.info.domain.EvaluationEmployee;
import com.info.domain.entity.Employee;
import com.info.domain.repository.EvaluationEmployeeRepository;
import com.info.service.IEvaluationEmployeeService;
@Service
public class EvaluationEmployeeService implements IEvaluationEmployeeService {
	@Autowired
	EvaluationEmployeeRepository evaluationEmployeeRepository;
	
	public Optional<EvaluationEmployee> getById(Long id) {
		return evaluationEmployeeRepository.findById(id);
	}

	/**
	 * 通过季度、评价人、评价对象进行查询
	 * @param season
	 * @param employeeFrom
	 * @param employeesTo
	 * @return
	 */
	public List<EvaluationEmployee> getBySeasonFromTo(String season,Employee employeeFrom, List<Employee> employeesTo) {
		List<EvaluationEmployee> rltEEmployees=new ArrayList<EvaluationEmployee>();
		for(Employee emp:employeesTo) {
			Optional<EvaluationEmployee> optional=evaluationEmployeeRepository.findBySeasonFromTo(season, employeeFrom, emp);
			EvaluationEmployee tmpEvaluationEmployee=null;
			if(!optional.isPresent()){
				tmpEvaluationEmployee=new EvaluationEmployee();
				tmpEvaluationEmployee.setSeason(season);
				tmpEvaluationEmployee.setFromWhom(employeeFrom);
				tmpEvaluationEmployee.setToWhom(emp);
				tmpEvaluationEmployee=evaluationEmployeeRepository.save(tmpEvaluationEmployee);
			}else {
				tmpEvaluationEmployee=optional.get();
			}
			rltEEmployees.add(tmpEvaluationEmployee);
		}
		return rltEEmployees;
	}

	/**
	 * 持久化对象到数据库
	 * @param evaluationEmployee
	 * @return
	 */
	public EvaluationEmployee update(EvaluationEmployee evaluationEmployee) {
		return evaluationEmployeeRepository.save(evaluationEmployee);	
	}
}
