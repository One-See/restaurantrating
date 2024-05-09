package com.example.demo.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.demo.entities.Restaurant;

public class RestaurantRepository implements IRestaurantRepository {
    private Map<Long, Restaurant> restaurantMap = new HashMap<Long, Restaurant>();
    private long autoIncrementId = 1L;

    @Override
    public Restaurant save(Restaurant restaurant) {
        Restaurant u = new Restaurant(restaurant.getRestaurantName(), autoIncrementId);
        restaurantMap.put(autoIncrementId, u);
        autoIncrementId++;
        return u;
    }

    @Override
    public boolean checkIfExists(long id) {
        return restaurantMap.containsKey(id);
    }

    @Override
    public Optional<Restaurant> fetchById(long id) {
        return Optional.of(restaurantMap.get(id));
    }

    @Override
    public List<Restaurant> findAll() {
        return restaurantMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public void deleteById(long id) {
        restaurantMap.remove(id);
    }

    @Override
    public int count() {
        return restaurantMap.size();
    }
}
