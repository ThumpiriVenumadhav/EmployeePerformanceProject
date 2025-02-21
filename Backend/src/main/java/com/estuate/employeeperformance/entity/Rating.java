package com.estuate.employeeperformance.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ratingId;

    @Column(nullable = false, length = 1)
    private String category; // A, B, C, D, E

    @Column(nullable = false)
    private double standardPercentage;

    
    public Rating() {
		super();
	}

	public Rating(String category, double standardPercentage) {
		super();
		this.category = category;
		this.standardPercentage = standardPercentage;
	}

	public int getRatingId() {
        return ratingId;
    }

    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getStandardPercentage() {
        return standardPercentage;
    }

    public void setStandardPercentage(double standardPercentage) {
        this.standardPercentage = standardPercentage;
    }
}
