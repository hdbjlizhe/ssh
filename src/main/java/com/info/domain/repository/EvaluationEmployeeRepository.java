package com.info.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.info.domain.entity.Department;
import com.info.domain.entity.Employee;
import com.info.domain.entity.EvaluationEmployee;

import java.lang.Long;
import java.util.List;
import java.util.Optional;

public interface EvaluationEmployeeRepository extends JpaRepository<EvaluationEmployee, Long> {

	@Query("FROM EvaluationEmployee e WHERE e.season=:season AND e.fromWhom=:fromWhom AND e.toWhom=:toWhom")
	Optional<EvaluationEmployee> findBySeasonFromTo(
			@Param("season") String season, 
			@Param("fromWhom") Employee fromWhom, 
			@Param("toWhom")Employee toWhom);
	
	@Query("FROM EvaluationEmployee e WHERE e.toWhom.department=:department")
	List<EvaluationEmployee> findEvaluationEmployeesByObjectDepartment(@Param("department") Department department);

	@Query("FROM EvaluationEmployee e WHERE e.toWhom.department=:department AND e.toWhom!=:loginEmployee")
	List<EvaluationEmployee> findEvaluationEmployeesByObjectDepartmentExcludeSelf(@Param("loginEmployee") Employee loginEmoployee, @Param("department") Department department);

}
