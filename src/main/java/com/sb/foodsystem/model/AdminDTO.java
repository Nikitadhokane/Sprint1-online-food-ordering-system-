package com.sb.foodsystem.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDTO {
    private Long id;

    @NotNull
    @Size(min = 3, max = 50, message = "Name should have min 3 to max 50 characters")
    private String username;

    @NotNull
    @Size(min = 6, max = 8, message = "Password should have min 6 to max 8 characters")
    private String password;

    @NotNull
    @Email(message = "Enter proper email")
    private String email;

    @NotNull
    @Pattern(regexp = "^\\d{10}$", message = "Mobile number should be 10 digits")
    private String contact;
}