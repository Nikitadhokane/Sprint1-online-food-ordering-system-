package com.sb.foodsystem.service;

import com.sb.foodsystem.model.ReviewDTO;

public interface ReviewService {

    ReviewDTO createReview(ReviewDTO reviewDTO);

    ReviewDTO getReviewById(int id);

    ReviewDTO updateReview(int id, ReviewDTO reviewDTO);

    String deleteReview(int id);
}