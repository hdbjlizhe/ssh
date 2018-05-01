package com.info.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info.domain.EvaluationEmployee;
import java.lang.Long;

public interface EvaluationEmployeeRepository extends JpaRepository<EvaluationEmployee, Long> {

}
