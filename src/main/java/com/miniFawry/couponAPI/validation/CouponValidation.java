package com.miniFawry.couponAPI.validation;

import com.miniFawry.couponAPI.Excptions.*;
import com.miniFawry.couponAPI.entity.Coupon;

import java.util.Date;

// TODO:: Clean Code
public class CouponValidation {


     public static void couponDateValidation(Coupon coupon) {

        if(coupon.getCode().length() < 5 || coupon.getCode().length() > 15){
            throw new CouponCodeLengthException();
        }

        if(coupon.getMaxAllowedUses() <= 0 || coupon.getMaxAllowedUses() > 1000){
            throw new MaxAllowedUsesException();
        }

        if(coupon.getType().toUpperCase().equals("PERCENTAGE") && (coupon.getValue() < 5 || coupon.getValue() > 100)) {
            throw new ValueException("1%", "100%");
        }

        if (coupon.getType().toUpperCase().equals("VALUE") && (coupon.getValue() < 10 || coupon.getValue() > 500)) {
            throw new ValueException("10$", "500$");
        }
    }

    public static boolean activeCoupon(Coupon coupon) {

        if(!coupon.isActive()){
            throw new CouponInactiveException(coupon.getCode());
        }

         if(coupon.getUsageNumber() >= coupon.getMaxAllowedUses()){
             coupon.setActive(false);
             throw new CouponUsagesExceededException(coupon.getCode());
        }

        if (coupon.getExpiryDate() != null && coupon.getExpiryDate().before(new Date())) {
            coupon.setActive(false);
            throw new CouponExpiredException(coupon.getCode());
        }

        return true;
    }

    public static boolean isActiveCoupon(Coupon coupon) {

        if(!coupon.isActive()){
            return false;
        }

        if(coupon.getUsageNumber() >= coupon.getMaxAllowedUses()){
            coupon.setActive(false);
            return false;
        }

        if (coupon.getExpiryDate() != null && coupon.getExpiryDate().before(new Date())) {
            coupon.setActive(false);
            return false;
        }

        return true;
    }

}
