package com.inditex.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class AmbiguityException extends RuntimeException {

    public AmbiguityException(String message) {
        super(message);
    }
}
