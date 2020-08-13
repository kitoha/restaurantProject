package com.toyproject.restaurant.controller;

import com.toyproject.restaurant.application.RestaurantService;
import com.toyproject.restaurant.domain.MenuItem;
import com.toyproject.restaurant.domain.MenuItemRepository;
import com.toyproject.restaurant.domain.Restaurant;
import com.toyproject.restaurant.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<Restaurant> list(){
        List<Restaurant> restaurants= restaurantService.getRestaurants();

        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id){
        Restaurant restaurant= restaurantService.getRestaurant(id);

        return restaurant;
    }
}
