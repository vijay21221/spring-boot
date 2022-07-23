package com.vlearn.restaurantcatalogservice.controllers;

import com.vlearn.restaurantcatalogservice.domains.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RestaurantCatalogController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("restaurant/catalog/{userId}")
    public RestaurantCatalog getCatalogItems(@PathVariable String userId) {

        RatingInfo ratingInfo = restTemplate.getForObject("http://restaurant-rating-service/restaurant/rating/" + userId, RatingInfo.class);

        List<CatalogItem> catalogItems = ratingInfo.getRatingList().stream().map(rating -> {
            RestaurantInfo restaurantInfo = restTemplate.getForObject("http://restaurant-info-service/restaurant/info/" + rating.getRestaurantId(), RestaurantInfo.class);
            return new CatalogItem(restaurantInfo.getRestaurantName(), rating.getRating());
        }).collect(Collectors.toList());

        return new RestaurantCatalog("vijaybabugadda", userId, catalogItems);

    }
}
