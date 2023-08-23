package com.miniFawry.couponAPI.Excptions;

public class HaveCodeWithSameNameException extends RuntimeException {
    public HaveCodeWithSameNameException() {
        super("There is an active coupon with the same name");
    }
}
