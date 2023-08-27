package com.miniFawry.couponapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.miniFawry.couponapi.Excptions.ExpiryDateException;
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
    @SequenceGenerator(
            name = "coupons_id_seq",
            sequenceName = "coupons_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coupons_id_seq")

    private Long id;
    @Column(unique = true)
    @NotEmpty(message = "Code cannot be empty or null")
    private String code; // name
    private Long maxAllowedUses;
    private Long usageNumber;
    private String type; // ToDo:: Enum
    private double value;

    @Column(columnDefinition = "BOOLEAN DEFAULT true")
    private boolean active;
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date expiryDate;
    @PrePersist
    @PreUpdate
    private void validateExpiryDate() {
        if (expiryDate != null && expiryDate.before(new Date())) {
            throw new ExpiryDateException();
        }
    }

}
