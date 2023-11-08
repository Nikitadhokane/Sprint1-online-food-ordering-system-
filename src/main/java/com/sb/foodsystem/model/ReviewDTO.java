package com.sb.foodsystem.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.sb.foodsystem.entity.Menu;
import com.sb.foodsystem.entity.Restaurant;
import com.sb.foodsystem.entity.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewDTO {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int reviewId;
	
	@NotNull(message = "User cannot be null")
    private User user;

    @NotNull(message = "Restaurant cannot be null")
    private Restaurant restaurant;

    private Menu menu;

    @NotNull(message = "Rating cannot be null")
    @Min(value = 1, message = "Rating should not be less than 1")
    @Max(value = 5, message = "Rating should not be greater than 5")
    private int rating;

    @NotEmpty(message = "Comment cannot be empty")
    @Size(max = 255, message = "Comment must be less than or equal to 255 characters")
    private String comment;
	
	
	

}
