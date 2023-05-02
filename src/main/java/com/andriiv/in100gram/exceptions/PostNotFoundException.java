package com.andriiv.in100gram.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Roman Andriiv (02.05.2023 - 13:50)
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException(String msg) {
        super(msg);
    }
}
