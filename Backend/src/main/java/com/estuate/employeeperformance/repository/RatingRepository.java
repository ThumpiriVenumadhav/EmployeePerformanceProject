package com.estuate.employeeperformance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estuate.employeeperformance.entity.Rating;


@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {

	
}
