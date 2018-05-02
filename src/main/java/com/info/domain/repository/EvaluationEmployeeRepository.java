package com.info.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.info.domain.EvaluationEmployee;
import com.info.domain.entity.Employee;

import java.lang.Long;
import java.util.Optional;

public interface EvaluationEmployeeRepository extends JpaRepository<EvaluationEmployee, Long> {

	@Query("FROM EvaluationEmployee e WHERE e.season=:season AND e.fromWhom=:fromWhom AND e.toWhom=:toWhom")
	Optional<EvaluationEmployee> findBySeasonFromTo(
			@Param("season") String season, 
			@Param("fromWhom") Employee fromWhom, 
			@Param("toWhom")Employee toWhom);

}
