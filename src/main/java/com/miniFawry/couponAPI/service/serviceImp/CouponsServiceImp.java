package com.miniFawry.couponAPI.service.serviceImp;

import com.miniFawry.couponAPI.Excptions.CouponNotFoundException;
import com.miniFawry.couponAPI.Excptions.HaveCodeWithSameNameException;
import com.miniFawry.couponAPI.entity.ConsumptionHistory;
import com.miniFawry.couponAPI.entity.Coupon;
import com.miniFawry.couponAPI.entity.entityRequest.UseCouponReq;
import com.miniFawry.couponAPI.mapper.CouponMapper;
import com.miniFawry.couponAPI.model.CouponModel;
import com.miniFawry.couponAPI.repository.ConsumptionHistoryRepository;
import com.miniFawry.couponAPI.repository.CouponRepository;
import com.miniFawry.couponAPI.service.CouponsService;
import com.miniFawry.couponAPI.validation.CouponValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CouponsServiceImp implements CouponsService {

    @Autowired CouponRepository couponRepository;
    @Autowired CouponMapper couponMapper;
    @Autowired ConsumptionHistoryRepository consumptionHistoryRepository;


    @Override
    public void createCoupon(Coupon coupon) {

        if (!couponRepository.findByCode(coupon.getCode()).isEmpty()) {
            throw new HaveCodeWithSameNameException();
        }

        CouponValidation.couponDateValidation(coupon);
        coupon.setActive(true);
        coupon.setUsageNumber(0L);
        couponRepository.save(coupon);
    }

    @Override
    public void deactivateCoupon(String code) {
        Coupon existingCoupon = couponRepository.findByCode(code)
                .orElseThrow(() -> new CouponNotFoundException(code));
        existingCoupon.setActive(false);
        couponRepository.save(existingCoupon);
    }

    @Override
    public CouponModel getCouponByCode(String code) {

        Coupon coupon = couponRepository.findByCode(code)
                .orElseThrow(() -> new CouponNotFoundException(code));

        CouponValidation.activeCoupon(coupon);
        return couponMapper.toModel(coupon);
    }

    @Override
    public List<CouponModel> viewAllCoupons() {
        return couponRepository.findAll()
                .stream()
                .map(couponMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<CouponModel> getActiveCoupons() {
        return couponRepository.findAllByActiveTrue()
                .stream()
                .filter(CouponValidation::isActiveCoupon)
                .map(couponMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public void applyCoupon(String code, UseCouponReq useCouponReq) {

        Coupon coupon = couponRepository.findByCode(code)
                .orElseThrow(() -> new CouponNotFoundException(code));

        CouponValidation.activeCoupon(coupon);
        coupon.setUsageNumber(coupon.getUsageNumber() + 1);
        if(coupon.isActive() && coupon.getMaxAllowedUses() == coupon.getUsageNumber()){
            coupon.setActive(false);
        }

        couponRepository.save(coupon);

        ConsumptionHistory consumptionHistory = new ConsumptionHistory(
                useCouponReq.getOrderId(),
                useCouponReq.getPriceBefore(),
                useCouponReq.getPriceAfter(),
                coupon
        );

        consumptionHistoryRepository.save(consumptionHistory);
    }
}
