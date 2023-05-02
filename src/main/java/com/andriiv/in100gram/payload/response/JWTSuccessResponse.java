package com.andriiv.in100gram.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Roman Andriiv (01.05.2023 - 13:20)
 */
@Data
@AllArgsConstructor
public class JWTSuccessResponse {
    private boolean success;
    private String token;
}
