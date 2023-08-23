package com.miniFawry.couponAPI.entity.entityRequest;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(name = "Apply(use) Coupon Request Schema")
@Data
public class UseCouponReq {
    Long orderId;
    Long priceBefore;
    Long priceAfter;

}
