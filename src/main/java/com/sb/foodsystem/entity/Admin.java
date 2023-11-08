package com.sb.foodsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
@Entity
@Table(name="Admin_Details")
public class Admin {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Admin_id")
    private Long id;

    @NotNull
    @Size(min = 3, max = 50, message = "Name should have min 3 to max 50 characters")
    @Column(name = "Username")
    private String username;

    @NotNull
    @Size(min = 6, max = 8, message = "Password should have min 6 to max 8 characters")
    @Column(name = "Password")
    private String password;

    @NotNull
    @Email(message = "Enter proper email")
    @Column(name = "Email")
    private String email;

    @NotNull
    @Pattern(regexp = "^\\d{10}$", message = "Mobile number should be 10 digits")
    @Column(name = "Contact_Number")
    private String contact;

}