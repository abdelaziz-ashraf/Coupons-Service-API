package com.miniFawry.couponAPI.service;

import com.miniFawry.couponAPI.entity.Coupon;
import com.miniFawry.couponAPI.entity.entityRequest.UseCouponReq;
import com.miniFawry.couponAPI.model.CouponModel;

import java.util.List;

public interface CouponsService {
    void createCoupon(Coupon coupon);
    void deactivateCoupon(String code);
    CouponModel getCouponByCode(String code);
    List<CouponModel> viewAllCoupons();
    List<CouponModel> getActiveCoupons();

    void applyCoupon(String code, UseCouponReq useCouponReq);

}
