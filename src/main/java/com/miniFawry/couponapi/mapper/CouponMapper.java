package com.miniFawry.couponapi.mapper;

import com.miniFawry.couponapi.entity.Coupon;
import com.miniFawry.couponapi.model.CouponModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface CouponMapper {
    Coupon toEntity(CouponModel couponModel);
    CouponModel toModel(Coupon coupon);
}
