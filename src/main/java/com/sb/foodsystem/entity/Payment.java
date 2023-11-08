package com.sb.foodsystem.entity;

import java.sql.Time;

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
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
@Table(name="Payment_Details")
public class Payment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	@Column(name="Payment_Id")
	private Long id;
	
	@ManyToOne
    @JoinColumn(name="Order_id")
	private Order order;
	
	@Column(name="Amount")
	private int amount;
	
	@Column(name="Payment_Time")
	private Time time;
	
	
	
	
	
	

}
