package com.miniFawry.couponapi.service.serviceImp;

import com.miniFawry.couponapi.mapper.ConsumptionHistoryMapper;
import com.miniFawry.couponapi.model.ConsumptionHistoryModel;
import com.miniFawry.couponapi.repository.ConsumptionHistoryRepository;
import com.miniFawry.couponapi.repository.CouponRepository;
import com.miniFawry.couponapi.service.ConsumptionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsumptionHistoryServiceImp implements ConsumptionHistoryService {

    @Autowired ConsumptionHistoryRepository consumptionHistoryRepository;
    @Autowired
    CouponRepository couponRepository;
    @Autowired ConsumptionHistoryMapper consumptionHistoryMapper;

    @Override
    public List<ConsumptionHistoryModel> viewConsumptionHistory() {
        return consumptionHistoryRepository.findAll()
                .stream()
                .map(consumptionHistoryMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<ConsumptionHistoryModel> viewConsumptionHistoryByCouponCode(String code) {
        return consumptionHistoryRepository.findAllByUsedCouponCode(code)
                .stream()
                .map(consumptionHistoryMapper::toModel)
                .collect(Collectors.toList());
    }
}
