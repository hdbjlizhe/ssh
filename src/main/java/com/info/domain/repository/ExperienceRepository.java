package com.info.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info.domain.entity.Experience;
import com.info.domain.entity.Employee;
import java.util.List;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
	List<Experience> findByEmployee(Employee employee);
}
