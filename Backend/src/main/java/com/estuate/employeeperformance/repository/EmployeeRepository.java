package com.estuate.employeeperformance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.estuate.employeeperformance.entity.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	
	@Query("SELECT e FROM Employee e LEFT JOIN FETCH e.appraisal")
    List<Employee> findAllWithAppraisal();

}
