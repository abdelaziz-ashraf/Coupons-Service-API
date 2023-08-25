package com.miniFawry.couponapi.entity.entityRequest;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(name = "Apply(use) Coupon Request Schema")
@Data
public class UseCouponReq {
    String orderCode;
    double priceBefore;
    double priceAfter;

}
