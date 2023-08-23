package com.miniFawry.couponapi.service;

import com.miniFawry.couponapi.model.ConsumptionHistoryModel;

import java.util.List;

public interface ConsumptionHistoryService {
    List<ConsumptionHistoryModel> viewConsumptionHistory();

    List<ConsumptionHistoryModel> viewConsumptionHistoryByCouponCode(String code);

}
