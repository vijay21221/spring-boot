package com.vlearn.jwtauth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private static List<String> products = Arrays.asList("Iphone 13 pro", "Lenove Ideapad Flex", "Mouse", "keyboard");


    @RequestMapping("/")
    public List<String> getProducts() {
        return products;
    }

}
