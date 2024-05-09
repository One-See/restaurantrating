package com.example.demo.commands;

import java.util.Arrays;
import java.util.List;
import com.example.demo.entities.Review;
import com.example.demo.services.ReviewService;

public class AddRatingCommand implements ICommand {
    private ReviewService reviewService;

    public AddRatingCommand(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @Override
    public void invoke(List<String> tokens) {
        if (tokens.size() == 4) {
            Review review = this.reviewService.addRating(Integer.valueOf(tokens.get(1)),Long.valueOf(tokens.get(2)), Long.valueOf(tokens.get(3)));
            System.out.println(review + " added successfully for " + review.getRestaurant() + " by " + review.getUser() + "!");
        } else {
            List<String> dishes = Arrays.asList(tokens.get(4).split(" "));
            Review review = this.reviewService.addReview(Integer.valueOf(tokens.get(1)),Long.valueOf(tokens.get(2)), Long.valueOf(tokens.get(3)), dishes, tokens.get(5));
            System.out.println(review + " added successfully for " + review.getRestaurant() + " by " + review.getUser() + "!");
        }
    }
}
