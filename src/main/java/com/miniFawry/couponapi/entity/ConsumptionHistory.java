package com.miniFawry.couponapi.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Schema(name = "Consumption History Schema")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConsumptionHistory implements Serializable {


    public ConsumptionHistory(String orderCode, BigDecimal priceBefore, BigDecimal priceAfter, Coupon usedCoupon) {
        this.orderCode = orderCode;
        this.priceBefore = priceBefore;
        this.priceAfter = priceAfter;
        this.usedCoupon = usedCoupon;
        this.consumedAt = new Date();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String orderCode;
    @Column(nullable = false)
    BigDecimal priceBefore;
    @Column(nullable = false)
    BigDecimal priceAfter;

    @ManyToOne
    @JoinColumn(name = "coupon_id", referencedColumnName = "id")
    Coupon usedCoupon;

    Date consumedAt;
}
