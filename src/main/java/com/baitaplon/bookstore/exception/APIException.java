package com.baitaplon.bookstore.exception;

import org.springframework.http.HttpStatus;

public class APIException extends RuntimeException{
    private HttpStatus status;
    private String message;

    public APIException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }


}
