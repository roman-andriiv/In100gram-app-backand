package com.andriiv.in100gram.payload.response;

import lombok.Getter;

/**
 * Created by Roman Andriiv (27.04.2023 - 11:46)
 */
@Getter
public class InvalidLoginResponse {
    private String username;
    private String password;

    public InvalidLoginResponse() {
        this.username = "Invalid username";
        this.password = "Invalid password";
    }
}
