package com.toyproject.restaurant.application;

import com.toyproject.restaurant.domain.MenuItem;
import com.toyproject.restaurant.domain.MenuItemRepository;
import com.toyproject.restaurant.domain.Restaurant;
import com.toyproject.restaurant.domain.RestaurantRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    MenuItemRepository menuItemRepository;

    public Restaurant getRestaurant(Long id){
        Restaurant restaurant=restaurantRepository.findById(id);

        List<MenuItem> menuItems=menuItemRepository.findAllByRestaurantId(id);
        restaurant.setMenuItem(menuItems);

        return restaurant;
    }

    public List<Restaurant> getRestaurants() {
        List<Restaurant> restaurants=restaurantRepository.findAll();

        return restaurants;
    }
}
