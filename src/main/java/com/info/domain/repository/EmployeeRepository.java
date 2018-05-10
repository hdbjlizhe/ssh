package com.info.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.info.domain.entity.Department;
import com.info.domain.entity.Employee;

import java.util.List;
import com.info.domain.entity.Duty;

/**
 * @author Administrator
 *
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findByDuty(Duty duty);
	
	List<Employee> findByDepartment(Department department);
	@Query("FROM Employee e where e.department=:department AND e.duty=:duty")
	List<Employee> findByDepartmentAndDuty(@Param("department") Department department,@Param("duty") Duty duty);

	@Query("FROM Employee e where e.department=:department AND e.duty=:duty AND e.isFormal=:formal")
	List<Employee> findByDepartmentAndDutyAndFormal(@Param("department") Department department,@Param("duty") Duty duty,@Param("formal") boolean formal);
	
	@Query(value="select * from e_employee where department_id=?1",nativeQuery = true)
	List<Employee> findByDepartment(Long deptId);
}
