package com.sb.foodsystem.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.foodsystem.converter.ReviewConverter;
import com.sb.foodsystem.dao.ReviewRepository;
import com.sb.foodsystem.entity.Review;
import com.sb.foodsystem.model.ReviewDTO;
import com.sb.foodsystem.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
    private ReviewRepository reviewRepository;
	
	@Autowired
    private ReviewConverter reviewConverter;

    public ReviewServiceImpl(ReviewRepository reviewRepository, ReviewConverter reviewConverter)
    {
        this.reviewRepository = reviewRepository;
        this.reviewConverter = reviewConverter;
    }

    @Override
    public ReviewDTO createReview(ReviewDTO reviewDTO) 
    {
        Review review = reviewConverter.dtoToEntity(reviewDTO);
        review = reviewRepository.save(review);
        return reviewConverter.entityToDto(review);
    }

    @Override
    public ReviewDTO getReviewById(int id) 
    {
        Review review = reviewRepository.findById(id);
        return reviewConverter.entityToDto(review);
    }

    @Override
    public ReviewDTO updateReview(int id, ReviewDTO reviewDTO)
    {
        Review review = reviewConverter.dtoToEntity(reviewDTO);
        review.setReviewId(id); // Assuming reviewId is part of the ReviewDTO
        review = reviewRepository.save(review);
        return reviewConverter.entityToDto(review);
    }

    @Override
    public String deleteReview(int id) 
    {
        reviewRepository.deleteById(id);
        return "Review with ID " + id + " has been deleted successfully.";
    }
}