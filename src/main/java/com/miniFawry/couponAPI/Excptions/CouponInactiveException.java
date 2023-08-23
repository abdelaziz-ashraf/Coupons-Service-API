package com.miniFawry.couponAPI.Excptions;

public class CouponInactiveException extends RuntimeException {
    public CouponInactiveException(String code) {
        super("Coupon is inactive for coupon with code: " + code);
    }
}