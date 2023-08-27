package com.miniFawry.couponapi.model;

import com.miniFawry.couponapi.entity.Coupon;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConsumptionHistoryModel implements Serializable {
    Long id;
    String orderCode;
    BigDecimal priceBefore;
    BigDecimal priceAfter;
    Coupon usedCoupon;

    Date consumedAt;
}
