package com.info.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.domain.dto.EvaluationEmployeeDTO;
import com.info.domain.dto.EvaluationEmployeeDTOList;
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
	private EmployeeRepository employeeRepository;
	
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
	 * 持久化对象数组到数据库
	 * @param evaluationEmployees：EvaluationEmployeeDTO的数据传输对象的数组
	 * @param :登录用户ID
	 * @return ：返回存储的EvaluationEmployee对象
	 */
	public List<EvaluationEmployee> update(EvaluationEmployeeDTOList evaluationEmployees,Employee loginEmployee) {
		List<EvaluationEmployee> rltEvauationEmployees=new ArrayList<>();
		
		for(EvaluationEmployeeDTO eEmployee:evaluationEmployees.getEvaluationEmployees()) {	
			//1.从数据库获取记录
			EvaluationEmployee evaluationEmployee=evaluationEmployeeRepository.getOne(Long.parseLong(eEmployee.getId()));			
			//2.赋值
			evaluationEmployee.setSeason(eEmployee.getSeason());
			evaluationEmployee.setAbility(Float.parseFloat(eEmployee.getAbility()));
			evaluationEmployee.setAchievement(Float.parseFloat(eEmployee.getAchievement()));
			evaluationEmployee.setDiligence(Float.parseFloat(eEmployee.getDiligence()));
			evaluationEmployee.setHonest(Float.parseFloat(eEmployee.getHonest()));
			evaluationEmployee.setMorality(Float.parseFloat(eEmployee.getMorality()));
			evaluationEmployee.setSum();
			//3.获取登录用户user的employee
			Employee fromWhom=loginEmployee;
			evaluationEmployee.setFromWhom(fromWhom);
			//4.获取评价对象
			Employee toWhom=employeeRepository.getOne(Long.parseLong(eEmployee.getToWhom()));
			evaluationEmployee.setToWhom(toWhom);				
			evaluationEmployee.setUpdateTime(new Date());
			//5.存到数据库
			rltEvauationEmployees.add(evaluationEmployeeRepository.save(evaluationEmployee));
		}
		return rltEvauationEmployees;
	}

	/**
	 * 获取EvaluationEmployee的所有记录
	 * @return
	 */
	public List<EvaluationEmployee> getAllEvaluationEmployee() {
		return evaluationEmployeeRepository.findAll();
	}
	
	public List<EvaluationEmployee> getEvaluationEmployeesByObjectDepartment(Long deptId){
		Department department=departmentRepository.getOne(deptId);
		return evaluationEmployeeRepository.findEvaluationEmployeesByObjectDepartment(department);
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
