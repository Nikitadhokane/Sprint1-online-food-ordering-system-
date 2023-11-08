package com.sb.foodsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="Restaurant_Details")
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	@Column(name="Restaurant_Id")
	private Long id;
	
	@Column(name="Restaurant_Name")
	private String name;
	
	@Column(name="Restaurant_Address")
	private String address;
	
	@Column(name="Contact")
	private String contact;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="Opening_Hours")
	private String openingHours;
	
	
	
	
	

}
