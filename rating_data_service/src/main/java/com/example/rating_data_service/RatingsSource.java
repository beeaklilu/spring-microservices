package com.example.rating_data_service;

import org.apache.catalina.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsSource {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId){
        return new Rating(movieId, 3);
    }

    @RequestMapping("users/{userId}")
    public UserRating getRatingByUser(@PathVariable("userId") String userId){
        List<Rating> ratings = Arrays.asList(new Rating("1234", 4));
        UserRating userRatings = new UserRating();
        userRatings.setUserRating(ratings);
        return userRatings;
    }
}
