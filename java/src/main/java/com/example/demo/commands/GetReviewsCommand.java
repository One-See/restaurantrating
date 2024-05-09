package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.RatingOrder;
import com.example.demo.entities.Review;
import com.example.demo.services.ReviewService;

public class GetReviewsCommand implements ICommand {
    private ReviewService reviewService;

    public GetReviewsCommand(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @Override
    public void invoke(List<String> tokens) {
        List<Review> reviews = this.reviewService.getReviews(Long.valueOf(tokens.get(1)), RatingOrder.valueOf(tokens.get(2)));
        System.out.println(reviews);
    }
}
