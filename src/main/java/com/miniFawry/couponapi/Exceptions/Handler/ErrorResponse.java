package com.miniFawry.couponapi.Exceptions.Handler;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {
    private String errorCode;
    private String errorMessage;
    private LocalDateTime timestamp;


    public ErrorResponse(String message) {
        this.errorMessage = message;
    }
}