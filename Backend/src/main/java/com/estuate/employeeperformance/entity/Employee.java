package com.estuate.employeeperformance.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Employee")
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "employeeId")
    private int employeeId;

    @Column(nullable = false)
    private String employeeName;

    
    public Employee() {
		super();
	}

	public Employee(int employeeId, String employeeName) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
	}

	public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
}
