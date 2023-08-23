package com.miniFawry.couponAPI.Exceptions.Handler;

import com.miniFawry.couponAPI.Excptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({
            CouponExpiredException.class,
            CouponInactiveException.class,
            CouponNotFoundException.class,
            CouponUsagesExceededException.class,
            MaxAllowedUsesException.class,
            CouponCodeLengthException.class,
            ValueException.class,
            HaveCodeWithSameNameException.class,
            ExpiryDateException.class
    })
    public ResponseEntity<Object> handleCustomException(RuntimeException ex) {

        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}