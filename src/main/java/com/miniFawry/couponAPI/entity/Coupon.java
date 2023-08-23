package com.miniFawry.couponAPI.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.miniFawry.couponAPI.Excptions.ExpiryDateException;
import com.miniFawry.couponAPI.entity.enums.CouponType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Schema(name = "Coupon Schema")
@Entity
@Table(name = "coupons")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Coupon implements Serializable {

    // ToDo::  @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    @NotEmpty(message = "Code cannot be empty or null")
    private String code; // name
    private Long maxAllowedUses;
    private Long usageNumber;
    private String type; // ToDo:: Enum
    private Long value;
    private boolean active = true;
    @Temporal(TemporalType.DATE)
    private Date expiryDate;
    @PrePersist
    @PreUpdate
    private void validateExpiryDate() {
        if (expiryDate != null && expiryDate.before(new Date())) {
            throw new ExpiryDateException();
        }
    }

}
