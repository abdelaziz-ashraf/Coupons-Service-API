package com.miniFawry.couponapi.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Schema(name = "Consumption History Schema")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConsumptionHistory implements Serializable {


    public ConsumptionHistory(Long orderId, Long priceBefore, Long priceAfter, Coupon usedCoupon) {
        this.orderId = orderId;
        this.priceBefore = priceBefore;
        this.priceAfter = priceAfter;
        this.usedCoupon = usedCoupon;
        this.consumedAt = new Date();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, updatable = false)
    Long orderId;
    @Column(nullable = false, updatable = false)
    Long priceBefore;
    @Column(nullable = false, updatable = false)
    Long priceAfter;

    @ManyToOne
    @JoinColumn(name = "coupon_id", referencedColumnName = "id")
    Coupon usedCoupon;

    private Date consumedAt;
}
