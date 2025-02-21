package com.estuate.employeeperformance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estuate.employeeperformance.entity.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	

}
