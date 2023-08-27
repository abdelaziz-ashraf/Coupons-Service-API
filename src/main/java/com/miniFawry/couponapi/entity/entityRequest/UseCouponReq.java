package com.miniFawry.couponapi.entity.entityRequest;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Schema(name = "Apply(use) Coupon Request Schema")
@Data
public class UseCouponReq {
    String orderCode;
    BigDecimal priceBefore;
    BigDecimal priceAfter;

}
