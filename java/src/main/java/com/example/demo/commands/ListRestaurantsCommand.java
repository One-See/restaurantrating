package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Restaurant;
import com.example.demo.services.RestaurantService;

public class ListRestaurantsCommand implements ICommand {
    private RestaurantService restaurantService;

    public ListRestaurantsCommand(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @Override
    public void invoke(List<String> tokens) {
        List<Restaurant> restaurants = this.restaurantService.listRestaurants();
        System.out.println(restaurants);
    }
}
