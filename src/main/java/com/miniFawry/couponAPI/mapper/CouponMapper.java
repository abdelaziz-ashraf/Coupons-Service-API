package com.miniFawry.couponAPI.mapper;

import com.miniFawry.couponAPI.entity.Coupon;
import com.miniFawry.couponAPI.model.CouponModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface CouponMapper {
    Coupon toEntity(CouponModel couponModel);
    CouponModel toModel(Coupon coupon);
}
