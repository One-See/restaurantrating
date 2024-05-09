package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.RatingOrder;
import com.example.demo.entities.Review;
import com.example.demo.services.ReviewService;

public class GetReviewsFilterOrderCommand implements ICommand {
    private ReviewService reviewService;

    public GetReviewsFilterOrderCommand(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @Override
    public void invoke(List<String> tokens) {
        List<Review> reviews = this.reviewService.getFilteredReviews(Long.valueOf(tokens.get(1)), Integer.valueOf(tokens.get(2)), Integer.valueOf(tokens.get(3)), RatingOrder.valueOf(tokens.get(4)));
        System.out.println(reviews);
    }
}
