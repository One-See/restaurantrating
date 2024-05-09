package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Restaurant;
import com.example.demo.services.RestaurantService;

public class RegisterRestaurantCommand implements ICommand {

    private RestaurantService restaurantService;

    public RegisterRestaurantCommand(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @Override
    public void invoke(List<String> tokens) {
        Restaurant restaurant = this.restaurantService.registerRestaurant(tokens.get(1));
        System.out.println(restaurant);
    }
    
}
