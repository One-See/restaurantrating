package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.demo.entities.RatingOrder;
import com.example.demo.entities.Restaurant;
import com.example.demo.entities.Review;
import com.example.demo.entities.User;
import com.example.demo.repositories.IRestaurantRepository;
import com.example.demo.repositories.IReviewRepository;
import com.example.demo.repositories.IUserRepository;

public class ReviewService {
    private IUserRepository userRepository;
    private IRestaurantRepository restaurantRepository;
    private IReviewRepository reviewRepository;


    public ReviewService(IUserRepository userRepository, IRestaurantRepository restaurantRepository, IReviewRepository reviewRepository) {
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
        this.reviewRepository = reviewRepository;
    }

    public Review addRating(int rating, long userId, long restaurantId) {
        Optional<User> user = this.userRepository.fetchById(userId);
        Optional<Restaurant> restaurant = this.restaurantRepository.fetchById(restaurantId);
        if (user.isPresent() && restaurant.isPresent()) {
            Optional<Review> review = this.reviewRepository.findReview(userId, restaurantId);
            if (review.isPresent()) {
                return this.reviewRepository.updateReview(new Review(user.get(), restaurant.get(), rating), review.get().getId());
            }
            return this.reviewRepository.save(new Review(user.get(), restaurant.get(), rating));
        }

        throw new RuntimeException("Unable to add rating");
    }

    public Review addReview(int rating, long userId, long restaurantId, List<String> dishes, String description) {
        Optional<User> user = this.userRepository.fetchById(userId);
        Optional<Restaurant> restaurant = this.restaurantRepository.fetchById(restaurantId);
        if (user.isPresent() && restaurant.isPresent()) {
            return this.reviewRepository.save(new Review(user.get(), restaurant.get(), rating, dishes, description));
        }

        throw new RuntimeException("Unable to add review");
    }

    public Restaurant describeRestaurant(long restaurantId) {
        Optional<Restaurant> restaurant = this.restaurantRepository.fetchById(restaurantId);
        if (restaurant.isPresent()) return restaurant.get();
        throw new RuntimeException("Unable to find restaurant");
    }

    public List<Review> getReviews(long restaurantId, RatingOrder order) {
        if (order == RatingOrder.RATING_ASC) {
            return this.reviewRepository.findAll().stream().filter(review -> review.getRestaurant().getId() == restaurantId).sorted((re1, re2) -> re1.getRating() - re2.getRating()).collect(Collectors.toList());
        } else {
            return this.reviewRepository.findAll().stream().filter(review -> review.getRestaurant().getId() == restaurantId).sorted((re2, re1) -> re1.getRating() - re2.getRating()).collect(Collectors.toList());
        }
    }

    public List<Review> getFilteredReviews(long restaurantId, int low, int high, RatingOrder order) {
        if (order == RatingOrder.RATING_ASC) {
            return this.reviewRepository.findAll().stream().filter(review -> (review.getRestaurant().getId() == restaurantId) && (review.getRating() >= low && review.getRating() <= high)).sorted((re1, re2) -> re1.getRating() - re2.getRating()).collect(Collectors.toList());
        } else {
            return this.reviewRepository.findAll().stream().filter(review -> (review.getRestaurant().getId() == restaurantId) && (review.getRating() >= low && review.getRating() <= high)).sorted((re2, re1) -> re1.getRating() - re2.getRating()).collect(Collectors.toList());
        }
    }
}
