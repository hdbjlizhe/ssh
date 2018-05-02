package com.info.service.impl;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.options;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.css.ElementCSSInlineStyle;

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
}
