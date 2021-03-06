package com.example.movie_catalog_service.controller;


import com.example.movie_catalog_service.CatalogItem;
import com.example.movie_catalog_service.Movie;
import com.example.movie_catalog_service.Rating;
import com.example.movie_catalog_service.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;
    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

//        return ratings.stream().map(rating -> {
//                    Movie movie = webClientBuilder.build()
//                            .get()
//                            .uri("http://localhost:8081/movies/" + rating.getMovieId())
//                            .retrieve()
//                            .bodyToMono(Movie.class)
//                            .block();
//                    return new CatalogItem(movie.getName(), "mv", rating.getRating());
//                }
//
//        ).collect(Collectors.toList());


        UserRating ratings =  restTemplate.getForObject("http://rating-data-service/ratingsdata/users/" + userId, UserRating.class);
        return ratings.getUserRating().stream().map(rating -> {
             Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
               return new CatalogItem(movie.getName(), "mv", rating.getRating());
        }

        ).collect(Collectors.toList());

    }
}
