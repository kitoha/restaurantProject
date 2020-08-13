package com.toyproject.restaurant.domain;

import lombok.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Restaurant {

    private final Long id;
    private final String name;
    private final String address;
    private List<MenuItem> menuItems=new ArrayList<MenuItem>();

    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    public void setMenuItem(List<MenuItem> menuItems ) {
        for(MenuItem menuItem: menuItems){
            addMenuItem(menuItem);
        }
    }
}
