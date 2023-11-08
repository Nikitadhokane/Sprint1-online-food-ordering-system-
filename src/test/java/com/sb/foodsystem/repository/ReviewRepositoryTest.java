package com.sb.foodsystem.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sb.foodsystem.dao.ReviewRepository;
import com.sb.foodsystem.entity.Review;

public class ReviewRepositoryTest {
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Test
	public void testCreateReview() {
	    // Create a sample review
	    Review review = new Review();
	    // Set the necessary attributes for the review
	    review.setRating(5);
	    review.setComment("Excellent service!");

	    // Save the review
	    Review savedReview = reviewRepository.save(review);

	    // Assert that the saved review has an ID
	    assertNotNull(savedReview.getReviewId());
	}

	@Test
	public void testFindReviewById() {
	    // Create and save a sample review
	    Review review = new Review();
	    // Set the necessary attributes for the review
	    review.setRating(4);
	    review.setComment("Great food!");

	    // Save the review
	    Review savedReview = reviewRepository.save(review);

	    // Find the review by ID
	    Review foundReview = reviewRepository.findById(savedReview.getReviewId());

	    // Assert that the found review is not null
	    assertNotNull(foundReview);
	}

	@Test
	public void testUpdateReview() {
	    // Create and save a sample review
	    Review review = new Review();
	    // Set the necessary attributes for the review
	    review.setRating(4);
	    review.setComment("Good food!");

	    // Save the review
	    Review savedReview = reviewRepository.save(review);
	    assertNotNull(savedReview.getReviewId());

	    // Update the review
	    savedReview.setRating(5);
	    savedReview.setComment("Great food!");
	    Review updatedReview = reviewRepository.save(savedReview);

	    // Assert that the updated review has the new attributes
	    assertEquals(savedReview.getRating(), updatedReview.getRating());
	    assertEquals(savedReview.getComment(), updatedReview.getComment());
	}

	@Test
	public void testDeleteReview() {
	    // Create and save a sample review
	    Review review = new Review();
	    // Set the necessary attributes for the review
	    review.setRating(4);
	    review.setComment("Good food!");

	    // Save the review
	    Review savedReview = reviewRepository.save(review);
	    assertNotNull(savedReview.getReviewId());

	    // Delete the review
	    reviewRepository.delete(savedReview);

	    // Attempt to retrieve the review after deletion
	    Review deletedReview = reviewRepository.findById(savedReview.getReviewId());
	    assertNull(deletedReview);
	}
}