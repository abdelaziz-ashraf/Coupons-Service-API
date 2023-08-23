package com.miniFawry.couponapi.service;

import com.miniFawry.couponapi.entity.Coupon;
import com.miniFawry.couponapi.entity.entityRequest.UseCouponReq;
import com.miniFawry.couponapi.model.CouponModel;

import java.util.List;

public interface CouponsService {
    void createCoupon(Coupon coupon);
    void deactivateCoupon(String code);
    CouponModel getCouponByCode(String code);
    List<CouponModel> viewAllCoupons();
    List<CouponModel> getActiveCoupons();

    void applyCoupon(String code, UseCouponReq useCouponReq);

}
