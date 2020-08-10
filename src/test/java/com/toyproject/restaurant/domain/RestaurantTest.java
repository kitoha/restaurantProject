package com.toyproject.restaurant.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RestaurantTest {

    @Test
    public void creation(){
        Restaurant restaurant=new Restaurant(1007L,"Bob zip","Seoul");

        assertThat(restaurant.getId(),is(1007L));
        assertThat(restaurant.getName(),is("Bob zip"));
        assertThat(restaurant.getAddress(),is("Seoul"));
    }
}