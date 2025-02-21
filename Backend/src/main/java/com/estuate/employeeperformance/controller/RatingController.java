package com.estuate.employeeperformance.controller;

import com.estuate.employeeperformance.entity.Rating;
import com.estuate.employeeperformance.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    // Get all ratings
    @GetMapping
    public List<Rating> getAllRatings() {
        return ratingService.getAllRatings();
    }

    // Add new rating
    @PostMapping
    public Rating addRating(@RequestBody Rating rating) {
        return ratingService.addRating(rating);
    }
}

