package com.toyproject.restaurant.application;

import com.toyproject.restaurant.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

class RestaurantServiceTest {

    private RestaurantService restaurantService;

    @Mock
    private RestaurantRepository restaurantRepostitory;

    @Mock
    private MenuItemRepository menuItemRepository;

    @BeforeEach
    public void setup(){
       MockitoAnnotations.initMocks(this);

        mockRestaurantRepository();
        mockMenuItemRepository();

        restaurantService=new RestaurantService(restaurantRepostitory,menuItemRepository);
    }

    private void mockRestaurantRepository() {
        List<Restaurant> restaurants=new ArrayList<>();
        Restaurant restaurant=new Restaurant(1007L,"Bob zip","Seoul");
        restaurants.add(restaurant);

        given(restaurantRepostitory.findAll()).willReturn(restaurants);
        given(restaurantRepostitory.findById(1007L)).willReturn(restaurant);
    }

    private void mockMenuItemRepository() {
        List<MenuItem> menuItems =new ArrayList<>();
        menuItems.add(new MenuItem("Kimchi"));

        given(menuItemRepository.findAllByRestaurantId(1007L)).willReturn(menuItems);
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