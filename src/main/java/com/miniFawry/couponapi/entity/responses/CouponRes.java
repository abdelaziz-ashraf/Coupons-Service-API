package com.miniFawry.couponapi.entity.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CouponRes {
    Long id;
    String code;
    String type;
    Long value;
    boolean active;
}
