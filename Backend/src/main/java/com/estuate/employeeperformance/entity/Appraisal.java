package com.estuate.employeeperformance.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Appraisal")
public class Appraisal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appraisalId;

   
    @Column(nullable = false, length = 1)
    private String rating; 
    
    
    @OneToOne
    @JoinColumn(name = "employee_id")
    @JsonBackReference
    private Employee employee;

    
    public Appraisal() {
		super();
	}

	public int getAppraisalId() {
        return appraisalId;
    }

    public void setAppraisalId(int appraisalId) {
        this.appraisalId = appraisalId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}

