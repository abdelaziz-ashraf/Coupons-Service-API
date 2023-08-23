package com.miniFawry.couponAPI.Excptions;

public class CouponNotFoundException extends RuntimeException {

    public CouponNotFoundException(String code) {
        super("Coupon not found with code " + code);
    }

}