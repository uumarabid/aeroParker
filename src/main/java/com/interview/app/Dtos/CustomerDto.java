package com.interview.app.Dtos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private Long id;

    @NotEmpty(message = "Email address is required.")
    @Size(max = 255, message = "The field must be at most 255 characters long.")
    @Email
    private String emailAddress;

    @NotEmpty(message = "Title is required.")
    @Size(max = 5, message = "The field must be at most 5 characters long.")
    private String title;

    @NotEmpty(message = "First name is required.")
    @Size(max = 50, message = "The field must be at most 50 characters long.")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "First name should only contain alphabets.")
    private String firstName;

    @NotEmpty(message = "Last name is required.")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Last name should only contain alphabets.")
    @Size(max = 50, message = "The field must be at most 50 characters long.")
    private String lastName;

    @NotEmpty(message = "Address is required.")
    @Size(max = 255, message = "The field must be at most 255 characters long.")
    private String addressLine1;

    @Size(max = 255, message = "The field must be at most 255 characters long.")
    private String addressLine2;

    @Size(max = 255, message = "The field must be at most 255 characters long.")
    private String city;

    @NotEmpty(message = "Postcode is required.")
    @Size(max = 255, message = "The field must be at most 255 characters long.")
    private String postcode;

    @Size(max = 20, message = "The field must be at most 255 characters long.")
    private String phoneNumber;

}
