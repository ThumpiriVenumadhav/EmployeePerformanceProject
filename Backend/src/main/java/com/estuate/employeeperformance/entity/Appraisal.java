package com.estuate.employeeperformance.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Appraisal")
public class Appraisal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appraisalId;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(nullable = false, length = 1)
    private String rating; 

    
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

