package com.miniFawry.couponapi.Excptions;

public class CouponExpiredException extends RuntimeException {
    public CouponExpiredException(String code) {
        super("Coupon expired for coupon with code: " + code);
    }
}