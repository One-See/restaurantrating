package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.Restaurant;

public interface IRestaurantRepository {
    Restaurant save(Restaurant restaurant);
    boolean checkIfExists(long id);
    Optional<Restaurant> fetchById(long id);
    List<Restaurant> findAll();
    void deleteById(long id);
    int count();
}
