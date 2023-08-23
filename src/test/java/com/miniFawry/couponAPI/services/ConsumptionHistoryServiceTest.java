package com.miniFawry.couponAPI.services;

import com.miniFawry.couponAPI.entity.ConsumptionHistory;
import com.miniFawry.couponAPI.entity.Coupon;
import com.miniFawry.couponAPI.entity.entityRequest.UseCouponReq;
import com.miniFawry.couponAPI.mapper.ConsumptionHistoryMapper;
import com.miniFawry.couponAPI.mapper.CouponMapper;
import com.miniFawry.couponAPI.model.ConsumptionHistoryModel;
import com.miniFawry.couponAPI.model.CouponModel;
import com.miniFawry.couponAPI.repository.ConsumptionHistoryRepository;
import com.miniFawry.couponAPI.repository.CouponRepository;
import com.miniFawry.couponAPI.service.ConsumptionHistoryService;
import com.miniFawry.couponAPI.service.serviceImp.ConsumptionHistoryServiceImp;
import com.miniFawry.couponAPI.service.serviceImp.CouponsServiceImp;
import com.miniFawry.couponAPI.validation.CouponValidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

public class ConsumptionHistoryServiceTest {

    @Mock
    private ConsumptionHistoryRepository consumptionHistoryRepository;

    @Mock
    private ConsumptionHistoryMapper consumptionHistoryMapper;

    @InjectMocks
    private ConsumptionHistoryServiceImp consumptionHistoryService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testViewConsumptionHistory() {
        // Arrange
        List<ConsumptionHistory> consumptionHistoryList = new ArrayList<>();
        consumptionHistoryList.add(new ConsumptionHistory());
        consumptionHistoryList.add(new ConsumptionHistory());

        when(consumptionHistoryRepository.findAll()).thenReturn(consumptionHistoryList);
        when(consumptionHistoryMapper.toModel(any())).thenReturn(new ConsumptionHistoryModel());

        // Act
        List<ConsumptionHistoryModel> result = consumptionHistoryService.viewConsumptionHistory();

        // Assert
        assertEquals(consumptionHistoryList.size(), result.size());
    }

    @Test
    public void testViewConsumptionHistoryByCouponCode() {
        // Arrange
        String couponCode = "TEST123";
        List<ConsumptionHistory> consumptionHistoryList = new ArrayList<>();
        consumptionHistoryList.add(new ConsumptionHistory());
        consumptionHistoryList.add(new ConsumptionHistory());

        when(consumptionHistoryRepository.findAllByUsedCouponCode(couponCode)).thenReturn(consumptionHistoryList);
        when(consumptionHistoryMapper.toModel(any())).thenReturn(new ConsumptionHistoryModel());

        // Act
        List<ConsumptionHistoryModel> result = consumptionHistoryService.viewConsumptionHistoryByCouponCode(couponCode);

        // Assert
        assertEquals(consumptionHistoryList.size(), result.size());

    }

}
