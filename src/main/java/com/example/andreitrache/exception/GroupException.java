package com.example.andreitrache.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GroupException extends RuntimeException {

    public GroupException(String message) {
        super(message);
    }

}
