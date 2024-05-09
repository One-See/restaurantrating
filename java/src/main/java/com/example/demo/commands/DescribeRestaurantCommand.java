package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.RestaurantService;

public class DescribeRestaurantCommand implements ICommand {
    private RestaurantService restaurantService;

    public DescribeRestaurantCommand(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @Override
    public void invoke(List<String> tokens) {
        String description = this.restaurantService.describeRestaurant(Long.valueOf(tokens.get(1)));
        System.out.println(description);
    }
}
