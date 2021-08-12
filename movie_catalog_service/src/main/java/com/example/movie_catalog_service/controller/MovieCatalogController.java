package com.example.movie_catalog_service.controller;


import com.example.movie_catalog_service.CatalogItem;
import com.example.movie_catalog_service.Movie;
import com.example.movie_catalog_service.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        RestTemplate restTemplate = new RestTemplate();

        List<Rating> ratings = Arrays.asList(
                new Rating("1", 2),
                new Rating("2", 4)
        );
        return ratings.stream().map(rating -> {
             Movie movie = restTemplate.getForObject("http://localhost:8081/movies/" + rating.getMovieId(), Movie.class);
               return new CatalogItem(movie.getName(), "mv", rating.getRating());
        }

        ).collect(Collectors.toList());

    }
}