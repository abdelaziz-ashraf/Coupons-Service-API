package com.miniFawry.couponAPI.controller;

import com.miniFawry.couponAPI.entity.Coupon;
import com.miniFawry.couponAPI.entity.entityRequest.UseCouponReq;
import com.miniFawry.couponAPI.model.CouponModel;
import com.miniFawry.couponAPI.service.CouponsService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coupons")
public class CouponsController {
    @Autowired CouponsService couponsService;

    @Operation(summary = "Get All Coupons")
    @GetMapping("/")
    public List<CouponModel> viewAllCoupons() {
        return couponsService.viewAllCoupons();
    }

    @Operation(summary = "Get Active Coupons")
    @GetMapping("/active-coupons")
    public List<CouponModel> getActiveCoupons() {
        return couponsService.getActiveCoupons();
    }

    @Operation(summary = "Get Coupon By Code(name)")
    @GetMapping("/{code}")
    public CouponModel checkCoupon(@PathVariable String code){
        return  couponsService.getCouponByCode(code);

    }

    @Operation(summary = "Create New Coupon")
    @PostMapping("/")
    public void createCoupon(@RequestBody Coupon coupon) {
        couponsService.createCoupon(coupon);
    }

    @Operation(summary = "deactivate Coupon By code")
    @PutMapping("/{code}/deactivate")
    public void deactivateCoupon(@PathVariable String code) {
        couponsService.deactivateCoupon(code);
    }

    @Operation(summary = "Use Coupon")
    @PostMapping("/{code}/useCoupon")
    public void applyCoupon(@PathVariable String code, @RequestBody UseCouponReq useCouponReq) {
        couponsService.applyCoupon(code, useCouponReq);
    }
}
