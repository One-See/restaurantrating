package com.example.demo.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.demo.entities.Review;

public class ReviewRepository implements IReviewRepository {
    private Map<Long, Review> reviewMap = new HashMap<Long, Review>();
    private long autoIncrementId = 1L;

    @Override
    public Review save(Review review) {
        Review r = new Review(review.getUser(), review.getRestaurant(), review.getRating(), review.getDishes(), review.getDescription(), autoIncrementId);
        reviewMap.put(autoIncrementId, r);
        autoIncrementId++;
        return r;
    }

    @Override
    public Review updateReview(Review review, long id) {
        reviewMap.put(id, review);
        return review;
    }

    @Override
    public boolean existsById(long id) {
        return reviewMap.containsKey(id);
    }

    @Override
    public Optional<Review> findReview(long userId, long restaurantId) {
        return reviewMap.values().stream().filter(review -> review.getUser().getId() == userId && review.getRestaurant().getId() == restaurantId).findAny();
    }

    @Override
    public Optional<Review> fetchById(long id) {
        return Optional.of(reviewMap.get(id));
    }

    @Override
    public List<Review> findAll() {
        return reviewMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public void deleteById(long id) {
        reviewMap.remove(id);
        
    }

    @Override
    public int count() {
        return reviewMap.size();
    }
    
}
