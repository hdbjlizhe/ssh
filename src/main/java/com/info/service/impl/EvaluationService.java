package com.info.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.domain.entity.Department;
import com.info.domain.entity.Employee;
import com.info.domain.entity.EvaluationEmployee;
import com.info.domain.entity.EvaluationMap;
import com.info.domain.pojo.EvaluationResult;
import com.info.domain.repository.DepartmentRepository;
import com.info.domain.repository.EmployeeRepository;
import com.info.domain.repository.EvaluationEmployeeRepository;
import com.info.domain.repository.EvaluationMapRepository;
import com.info.service.IEvaluationEmployeeService;
@Service
public class EvaluationService implements IEvaluationEmployeeService {
	
	
	private static final Logger log = LoggerFactory.getLogger(EvaluationService.class);

	
	@Autowired
	private EvaluationEmployeeRepository evaluationEmployeeRepository;
	
	@Autowired
	private EvaluationMapRepository evaluationMapRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	/**
	 * 通过Id获取EvaluationEmployee对象	
	 * @param id
	 * @return
	 */
	public Optional<EvaluationEmployee> getEvaluationEmployeeById(Long id) {
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

	/**
	 * 获取EvaluationEmployee的所有记录
	 * @return
	 */
	public List<EvaluationEmployee> getAllEvaluationEmployee() {
		return evaluationEmployeeRepository.findAll();
	}
	
	/**
	 * 通过对象和部门查询评价记录
	 * @param deptId
	 * @return
	 */
	public List<EvaluationEmployee> getEvaluationEmployeesByObjectDepartment(Long deptId){
		Department department=departmentRepository.getOne(deptId);
		return evaluationEmployeeRepository.findEvaluationEmployeesByObjectDepartment(department);
	}
	
	/**
	 * 按照登录用户的部门去查找，且要去掉对登录用户的评分
	 * @param loginEmoployee
	 * @param deptId
	 * @return
	 */
	public List<EvaluationEmployee> getEvaluationEmployeesByObjectDepartmentExcludeSelf(Employee loginEmoployee, Long deptId) {
		Department department=departmentRepository.getOne(deptId);
		return evaluationEmployeeRepository.findEvaluationEmployeesByObjectDepartmentExcludeSelf(loginEmoployee, department);
	}
	
	
	/**
	 * 排序函数
	 * @param eEmployees
	 * @return
	 */
	public List<List<EvaluationEmployee>> sortByObject(List<EvaluationEmployee> eEmployees){
		Set<Employee> employees=new HashSet<Employee>();
		for(EvaluationEmployee e:eEmployees) {
			employees.add(e.getToWhom());
		}
		
		List<List<EvaluationEmployee>> tables=new ArrayList<>();
		for(Employee e:employees) {
			List<EvaluationEmployee> tmp=new ArrayList<>();
			for(EvaluationEmployee ee:eEmployees) {
				if(ee.getToWhom().equals(e)) {
					tmp.add(ee);
				}
			}
			tables.add(tmp);
		}
		return tables;		
	}
	
	/**
	 * 获取所有人员的考核结果
	 * @return
	 */
	public List<EvaluationResult> getAllEvaluationResult(){
		List<EvaluationEmployee> evaluationEmployees=evaluationEmployeeRepository.findAll();
		List<EvaluationMap> evaluationMaps=evaluationMapRepository.findAll();
		
		List<EvaluationResult> evaluationResults=new ArrayList<>();//用于结果返回；
		
		List<Employee> employeeList=new ArrayList<>();
		
		for(EvaluationEmployee eEmployee:evaluationEmployees) {
			employeeList.add(eEmployee.getToWhom());
		}
		Set<Employee> sEmployees=new HashSet<>(employeeList);//得到所有的用户
		
		for(Employee e:sEmployees) {
			EvaluationResult tmpEvaluationResult=new EvaluationResult();
			tmpEvaluationResult.setObject(e);
			List<EvaluationEmployee> evaEmployees=new ArrayList<EvaluationEmployee>();
			for(EvaluationEmployee ee:evaluationEmployees) {
				if(e.equals(ee.getToWhom())) {
					evaEmployees.add(ee);
				}
			}
			//当前evaEmployees就有值了
			List<EvaluationMap> evaMaps=new ArrayList<EvaluationMap>();
			for(EvaluationMap em:evaluationMaps) {
				if(e.getDuty().equals(em.getObject())) {
					evaMaps.add(em);
				}
			}
			//当前evaMaps就有值了,开始计算过程
			float sum=0f;
			for(EvaluationMap tmpEMap:evaMaps) {
				float tmpSum=0;
				List<EvaluationEmployee> evaEmp=new ArrayList<>();
				for(EvaluationEmployee eemp:evaEmployees) {
					if(eemp.getFromWhom().getDuty().getWeight()<=tmpEMap.getMaxScorer().getWeight()
							&&eemp.getFromWhom().getDuty().getWeight()>=tmpEMap.getMinScorer().getWeight()) {
						evaEmp.add(eemp);
					}
				}
				int count=0;
				for(EvaluationEmployee ee:evaEmp) {
					tmpSum=tmpSum+ee.getSum();
					count++;
				}
				if(count!=0) {
					tmpSum=tmpSum/count;	
				}else {
					tmpSum=0;
				}
				sum+=tmpSum*tmpEMap.getProportions();
			}
			tmpEvaluationResult.setSum(sum);
			evaluationResults.add(tmpEvaluationResult);
		}		
		return evaluationResults;
	}


}
