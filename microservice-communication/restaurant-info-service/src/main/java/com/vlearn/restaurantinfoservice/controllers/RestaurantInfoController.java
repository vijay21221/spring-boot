package com.vlearn.restaurantinfoservice.controllers;

import com.vlearn.restaurantinfoservice.domains.Menu;
import com.vlearn.restaurantinfoservice.domains.RestaurantInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class RestaurantInfoController {

    @GetMapping("/restaurant/info/{restaurantId}")
    public RestaurantInfo getRestaurantInfo(@PathVariable String restaurantId) {
        return RestaurantInfo.builder()
                .restaurantId(restaurantId)
                .restaurantName("Meridian")
                .restaurantAddress("Panjagutta Hyderabad")
                .menu(new Menu("1m", Collections.singletonList("idli")))
                .build();
    }
}
