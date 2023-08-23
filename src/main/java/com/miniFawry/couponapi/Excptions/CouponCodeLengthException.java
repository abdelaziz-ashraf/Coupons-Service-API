package com.miniFawry.couponapi.Excptions;

public class CouponCodeLengthException extends RuntimeException {
    public CouponCodeLengthException() {
        super("coupon name must be between 5 and 15 chars.");
    }
}
