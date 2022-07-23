package com.vlearn.restaurantratingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RestaurantRatingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantRatingServiceApplication.class, args);
	}

}
