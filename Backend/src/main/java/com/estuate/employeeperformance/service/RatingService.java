package com.estuate.employeeperformance.service;

import com.estuate.employeeperformance.entity.Rating;
import com.estuate.employeeperformance.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    
    @Cacheable(value = "ratings")
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @CacheEvict(value = "ratings" , allEntries = true)
    public Rating addRating(Rating rating) {
        return ratingRepository.save(rating);
    }
}

