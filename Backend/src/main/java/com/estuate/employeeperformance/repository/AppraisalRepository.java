package com.estuate.employeeperformance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estuate.employeeperformance.entity.Appraisal;


@Repository
public interface AppraisalRepository extends JpaRepository<Appraisal, Integer> {

	
}
