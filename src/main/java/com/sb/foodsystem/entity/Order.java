package com.sb.foodsystem.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
@Table(name="Order_Table")
public class Order {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="order_id")
	private Long orderId;
	
	@ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name="restaurant_id")
	private Restaurant restaurant;
	
	@Column(name="Order_Date")
	private Date orderDate;
	
	@Column(name="Total_Amount")
	private int total_amount;
	
	 @Column(name = "User_ID", insertable = false, updatable = false)
	private Long userId;
	
	@Column(name="Order_Status")
	private String status;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetails> orderDetails;
	
	
	
	
	

}
