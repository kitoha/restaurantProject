package com.toyproject.restaurant.controller;

import com.toyproject.restaurant.application.RestaurantService;
import com.toyproject.restaurant.domain.MenuItem;
import com.toyproject.restaurant.domain.MenuItemRepositoryImpl;
import com.toyproject.restaurant.domain.Restaurant;
import com.toyproject.restaurant.domain.RestaurantRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(RestaurantController.class)
class RestaurantControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private RestaurantService restaurantService;

    @Test
    public void list() throws Exception {
        List<Restaurant> restaurants=new ArrayList<>();
        restaurants.add(new Restaurant(1007L,"Bob zip","Seoul"));

        given(restaurantService.getRestaurants()).willReturn(restaurants);

        mvc.perform(get("/restaurants"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"id\":1007")))
                .andExpect(content().string(containsString("\"name\":\"Bob zip\"")));
    }

    @Test
    public void detail() throws Exception{
        Restaurant restaurants=new Restaurant(1007L,"Bob zip","Seoul");
        restaurants.addMenuItem(new MenuItem("Kimchi"));
        given(restaurantService.getRestaurant(1007L)).willReturn(restaurants);

        mvc.perform(get("/restaurants/1007"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"id\":1007")))
                .andExpect(content().string(containsString("\"name\":\"Bob zip\"")))
                .andExpect(content().string(containsString("Kimchi")));
    }

}