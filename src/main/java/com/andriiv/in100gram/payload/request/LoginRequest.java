package com.andriiv.in100gram.payload.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * Created by Roman Andriiv (27.04.2023 - 14:43)
 */
@Data
public class LoginRequest {

    @NotEmpty(message = "Username cannot be empty")
    private String username;

    @NotEmpty(message = "Password cannot be empty")
    private String password;
}
