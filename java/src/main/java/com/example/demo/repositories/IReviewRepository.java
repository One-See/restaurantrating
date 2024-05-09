package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.Review;

public interface IReviewRepository {
    Review save(Review review);
    boolean existsById(long id);
    Optional<Review> fetchById(long id);
    Optional<Review> findReview(long userId, long restaurantId);
    Review updateReview(Review review, long id);
    List<Review> findAll();
    void deleteById(long id);
    int count();
}
