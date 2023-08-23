package com.miniFawry.couponapi.repository;

import com.miniFawry.couponapi.entity.ConsumptionHistory;
import com.miniFawry.couponapi.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsumptionHistoryRepository extends JpaRepository<ConsumptionHistory, Long> {

    List<ConsumptionHistory> findAllByUsedCouponCode(String code);
    List<ConsumptionHistory> findAllByUsedCoupon(Coupon coupon);
}
