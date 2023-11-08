package com.sb.foodsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
@Table(name="Menu_Type")
public class MenuType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="MenuType_id")
	private Long id;
	

	@ManyToOne
	//@JsonBackReference("user_reference")
	//@JoinColumn(name = "user_id")
	private User user;


	
	@Column(name="Name")
	private String type_name;
	
	@Column(name="Description")
	private String description;

    
   // @JsonBackReference
    @ManyToOne
   // @JoinColumn(name = "menu_id")// referencedColumnName = "menu_id")
    private Menu menu;
	
		
	

}
