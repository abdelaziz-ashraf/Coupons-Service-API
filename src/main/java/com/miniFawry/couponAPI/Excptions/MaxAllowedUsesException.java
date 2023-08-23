package com.miniFawry.couponAPI.Excptions;

public class MaxAllowedUsesException extends RuntimeException{
    public MaxAllowedUsesException() {
        super("Max allowed uses must be between 1 and 1000.");
    }

}
