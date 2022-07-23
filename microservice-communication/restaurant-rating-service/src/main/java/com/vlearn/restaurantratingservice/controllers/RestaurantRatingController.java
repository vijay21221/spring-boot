package com.vlearn.restaurantratingservice.controllers;

import com.vlearn.restaurantratingservice.domains.Rating;
import com.vlearn.restaurantratingservice.domains.RatingInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestaurantRatingController {

    @GetMapping("restaurant/rating/{userId}")
    public RatingInfo getRatingInfo(@PathVariable String userId) {
        List<Rating> movieRatings = new ArrayList<Rating>();
        movieRatings.add(new Rating("123", 3));
        movieRatings.add(new Rating("456", 2));
        return new RatingInfo(userId, movieRatings);
    }
}
