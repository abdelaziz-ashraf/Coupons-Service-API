package com.miniFawry.couponapi.model;

import com.miniFawry.couponapi.entity.Coupon;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConsumptionHistoryModel {
    Long id;
    Long orderId;
    Long priceBefore;
    Long priceAfter;
    Coupon usedCoupon;

    Date consumedAt;
}
