package com.example.demo.services;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.demo.entities.Restaurant;
import com.example.demo.repositories.IRestaurantRepository;
import com.example.demo.repositories.IReviewRepository;

public class RestaurantService {
    private IRestaurantRepository restaurantRepository;
    private IReviewRepository reviewRepository;

    public RestaurantService(IRestaurantRepository restaurantRepository, IReviewRepository reviewRepository) {
        this.restaurantRepository = restaurantRepository;
        this.reviewRepository = reviewRepository;
    }

    public Restaurant registerRestaurant(String name) {
        return this.restaurantRepository.save(new Restaurant(name));
    }

    public double calculateRestaurantRating(long restaurantId) {
        Map<Integer, Integer> starMap = new HashMap<Integer, Integer>();
        starMap.put(1, 0);
        starMap.put(2, 0);
        starMap.put(3, 0);
        starMap.put(4, 0);
        starMap.put(5, 0);

        this.reviewRepository.findAll().stream().filter(review -> review.getRestaurant().getId() == restaurantId).forEach(review -> starMap.put(review.getRating(), starMap.get(review.getRating()) + 1));

        double numOfRatings = starMap.values().stream().mapToDouble(Double::valueOf).sum();
        double temp = starMap.entrySet().stream().map(m -> m.getKey() * m.getValue()).mapToDouble(Double::valueOf).sum();

        if (numOfRatings == 0) throw new RuntimeException("Unable to calculate rating");

        return temp / numOfRatings;

    }

    public List<Restaurant> listRestaurants() {
        return this.restaurantRepository.findAll().stream().sorted((r2, r1) -> Double.compare(calculateRestaurantRating(r1.getId()), calculateRestaurantRating(r2.getId()))).collect(Collectors.toList());
    }

    public String describeRestaurant(long restaurantId) {
        Optional<Restaurant> restaurant = this.restaurantRepository.fetchById(restaurantId);
        if (restaurant.isPresent()) return "Restaurant [id=" + restaurant.get().getId() + ", name=" + restaurant.get().getRestaurantName() + ", rating=" + new DecimalFormat("#.#").format(calculateRestaurantRating(restaurantId)) + "]";
        throw new RuntimeException("Unable to find restaurant");
    }
}
