package com.andriiv.in100gram.payload.request;

import com.andriiv.in100gram.annotations.PasswordMatches;
import com.andriiv.in100gram.annotations.ValidEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Created by Roman Andriiv (27.04.2023 - 14:52)
 */
@Data
@PasswordMatches
public class SignupRequest {

    @Email(message = "It should have email format")
    @NotBlank(message = "Email is required")
    @ValidEmail
    private String email;

    @NotEmpty(message = "Please provide your name")
    private String firstName;

    @NotEmpty(message = "Please provide your lastname")
    private String lastName;

    @NotEmpty(message = "Please provide your username")
    private String username;

    @NotEmpty(message = "Password is required")
    @Size(min = 5)
    private String password;
    private String confirmPassword;
}
