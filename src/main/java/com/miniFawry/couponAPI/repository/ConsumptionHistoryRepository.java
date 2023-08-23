package com.miniFawry.couponAPI.repository;

import com.miniFawry.couponAPI.entity.ConsumptionHistory;
import com.miniFawry.couponAPI.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsumptionHistoryRepository extends JpaRepository<ConsumptionHistory, Long> {

    List<ConsumptionHistory> findAllByUsedCouponCode(String code);
    List<ConsumptionHistory> findAllByUsedCoupon(Coupon coupon);
}
