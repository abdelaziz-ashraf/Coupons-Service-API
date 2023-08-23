package com.miniFawry.couponAPI.service;

import com.miniFawry.couponAPI.model.ConsumptionHistoryModel;

import java.util.List;

public interface ConsumptionHistoryService {
    List<ConsumptionHistoryModel> viewConsumptionHistory();

    List<ConsumptionHistoryModel> viewConsumptionHistoryByCouponCode(String code);

}
