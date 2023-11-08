package com.sb.foodsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Review_Details")
public class Review {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Review_Id")
    private int reviewId;
	
    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "restaurantID")
    private Restaurant restaurant;
    
    @ManyToOne
    @JoinColumn(name = "menuId")
    private Menu menu;
    
    @Column(name = "Review_Rating")
    private int rating;
    
    @Column(name = "Review_Comment")
    private String comment;


}
