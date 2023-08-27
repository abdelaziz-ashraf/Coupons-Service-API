package com.miniFawry.couponapi.entity.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class CouponRes {
    String code;
    String type;
    BigDecimal value;
}
