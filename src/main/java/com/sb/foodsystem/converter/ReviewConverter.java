package com.sb.foodsystem.converter;

import org.springframework.stereotype.Component;

import com.sb.foodsystem.entity.Review;
import com.sb.foodsystem.model.ReviewDTO;

@Component
public class ReviewConverter {

    public ReviewDTO entityToDto(Review review) {
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setReviewId(review.getReviewId());
        reviewDTO.setUser(review.getUser());
        reviewDTO.setRestaurant(review.getRestaurant());
        reviewDTO.setMenu(review.getMenu());
        reviewDTO.setRating(review.getRating());
        reviewDTO.setComment(review.getComment());
        return reviewDTO;
    }

    public Review dtoToEntity(ReviewDTO reviewDTO) {
        Review review = new Review();
        review.setReviewId(reviewDTO.getReviewId());
        review.setUser(reviewDTO.getUser());
        review.setRestaurant(reviewDTO.getRestaurant());
        review.setMenu(reviewDTO.getMenu());
        review.setRating(reviewDTO.getRating());
        review.setComment(reviewDTO.getComment());
        return review;
    }
}