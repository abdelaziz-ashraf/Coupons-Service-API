package com.miniFawry.couponapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CouponModel {
    Long id;
    String code; // name
    Long maxAllowedUses;
    Long usageNumber;
//    CouponType type;
    String type;
    Long value;
    boolean active;
    Date expiryDate;
}
