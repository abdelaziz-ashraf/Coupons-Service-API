package com.miniFawry.couponAPI.Excptions;


public class CouponUsagesExceededException extends RuntimeException {
    public CouponUsagesExceededException(String code) {
        super("Coupon with code " + code + " has exceeded its maximum number of usages");
    }
}