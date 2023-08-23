package com.miniFawry.couponapi.services;

import com.miniFawry.couponapi.entity.ConsumptionHistory;
import com.miniFawry.couponapi.mapper.ConsumptionHistoryMapper;
import com.miniFawry.couponapi.model.ConsumptionHistoryModel;
import com.miniFawry.couponapi.repository.ConsumptionHistoryRepository;
import com.miniFawry.couponapi.service.serviceImp.ConsumptionHistoryServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
