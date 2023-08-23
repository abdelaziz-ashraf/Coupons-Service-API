package com.miniFawry.couponAPI.controller;

import com.miniFawry.couponAPI.model.ConsumptionHistoryModel;
import com.miniFawry.couponAPI.service.ConsumptionHistoryService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consumption-history")
public class ConsumptionHistoryController {
    @Autowired ConsumptionHistoryService consumptionHistoryService;

    @Operation(summary = "Get Consumption History")
    @GetMapping("/")
    List<ConsumptionHistoryModel> viewConsumptionHistory() {
        return consumptionHistoryService.viewConsumptionHistory();
    }

    @Operation(summary = "Get Consumption History By Coupon Code")
    @GetMapping("/{code}")
    List<ConsumptionHistoryModel> viewConsumptionHistoryByCode(@PathVariable String code) {
        System.out.println("-- " + code);
        return consumptionHistoryService.viewConsumptionHistoryByCouponCode(code);
    }

}
