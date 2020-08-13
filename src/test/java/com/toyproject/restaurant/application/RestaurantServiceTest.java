package com.toyproject.restaurant.application;

import com.toyproject.restaurant.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class RestaurantServiceTest {

    private RestaurantService restaurantService;
    private RestaurantRepository restaurantRepostitory;
    private MenuItemRepository menuItemRepository;

    @BeforeEach
    public void setup(){
        restaurantRepostitory=new RestaurantRepositoryImpl();
        menuItemRepository=new MenuItemRepositoryImpl();
        restaurantService=new RestaurantService(restaurantRepostitory,menuItemRepository);
    }

    @Test
    public void getRestaurant(){
        Restaurant restaurant=restaurantService.getRestaurant(1007L);
        assertThat(restaurant.getId(),is(1007L));

        MenuItem menuItem=restaurant.getMenuItems().get(0);

        assertThat(menuItem.getName(),is("Kimchi"));
    }

    @Test
    public void getRestaurants(){
        List<Restaurant> restaurants= restaurantService.getRestaurants();

        Restaurant restaurant=restaurants.get(0);
        assertThat(restaurant.getId(),is(1007L));
    }
}