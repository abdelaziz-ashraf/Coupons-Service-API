package com.miniFawry.couponapi.entity.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CouponRes {
    String code;
    String type;
    double value;
}
