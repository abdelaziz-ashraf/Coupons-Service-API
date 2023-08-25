package com.miniFawry.couponapi.services;

import com.miniFawry.couponapi.Excptions.CouponNotFoundException;
import com.miniFawry.couponapi.Excptions.HaveCodeWithSameNameException;
import com.miniFawry.couponapi.entity.ConsumptionHistory;
import com.miniFawry.couponapi.entity.Coupon;
import com.miniFawry.couponapi.entity.entityRequest.UseCouponReq;
import com.miniFawry.couponapi.entity.responses.CouponRes;
import com.miniFawry.couponapi.mapper.CouponMapper;
import com.miniFawry.couponapi.model.CouponModel;
import com.miniFawry.couponapi.repository.ConsumptionHistoryRepository;
import com.miniFawry.couponapi.repository.CouponRepository;
import com.miniFawry.couponapi.service.serviceImp.CouponsServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
public class CouponServiceTest {
    @Mock
    private CouponRepository couponRepository;

    @Mock
    private ConsumptionHistoryRepository consumptionHistoryRepository;

    @Mock
    private CouponMapper couponMapper;

    @InjectMocks
    private CouponsServiceImp couponsService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateCoupon() {
        // Arrange
        Coupon coupon = new Coupon();
        coupon.setCode("TEST123");
        coupon.setMaxAllowedUses(50L);
        coupon.setType("VALUE");
        coupon.setValue(50L);

        when(couponRepository.findByCode("TEST123")).thenReturn(Optional.empty());

        // Act
        couponsService.createCoupon(coupon);

        // Assert / Verify
        verify(couponRepository, times(1)).save(coupon);
    }

    @Test
    public void testCreateCoupon_WithExistingCode () {
        // Arrange
        Coupon coupon = new Coupon();
        coupon.setCode("TEST123");

        when(couponRepository.findByCode(any())).thenReturn(Optional.of(coupon));

//        // Act
//        couponsService.createCoupon(coupon);
//
//        // Assert
        assertThrows(HaveCodeWithSameNameException.class, () -> couponsService.createCoupon(coupon));
    }

    @Test
    public void testDeactivateCoupon() {
        // Arrange
        String couponCode = "TEST123";
        Coupon existingCoupon = new Coupon();
        existingCoupon.setCode(couponCode);

        when(couponRepository.findByCode(couponCode)).thenReturn(Optional.of(existingCoupon));

        // Act
        couponsService.deactivateCoupon(couponCode);

        // Assert / Verify
        verify(couponRepository, times(1)).save(existingCoupon);
        assertFalse(existingCoupon.isActive());
    }

    @Test
    public void testDeactivateCoupon_WithNotExistingCode () {

        when(couponRepository.findByCode(any())).thenThrow(CouponNotFoundException.class);

        assertThrows(CouponNotFoundException.class, () -> couponsService.deactivateCoupon("TEST123"));
    }

    @Test
    public void testGetCouponByCode() {
        // Arrange
        String couponCode = "TEST123";
        Coupon coupon = new Coupon();
        coupon.setCode(couponCode);
        coupon.setUsageNumber(2L);
        coupon.setMaxAllowedUses(50L);
        coupon.setType("VALUE");
        coupon.setValue(50L);

        when(couponRepository.findByCode(couponCode)).thenReturn(Optional.of(coupon));
        when(couponMapper.toModel(coupon)).thenReturn(new CouponModel(
                1L,
                "TEST123",
                50L,
                2L,
                "VALUE",
                50L,
                true,
                new Date()
                ));

        // Act
        CouponRes result = couponsService.getCouponByCode(couponCode);

        // Assert
        assertEquals(couponCode, result.getCode());
        verify(couponRepository, times(1)).findByCode(couponCode);
    }

    @Test
    public void testGetCouponByCode_WithNotExistingCode () {

        when(couponRepository.findByCode(any())).thenThrow(CouponNotFoundException.class);

        assertThrows(CouponNotFoundException.class, () -> couponsService.getCouponByCode("TEST123"));
    }

    @Test
    public void testViewAllCoupons() {
        // Arrange
        List<Coupon> coupons = new ArrayList<>();
        coupons.add(new Coupon());
        coupons.add(new Coupon());
        when(couponRepository.findAll()).thenReturn(coupons);

        // Act
        List<CouponModel> result = couponsService.viewAllCoupons();

        // Assert
        assertEquals(coupons.size(), result.size());
        verify(couponRepository, times(1)).findAll();
    }

    @Test
    public void testGetActiveCoupons() {
        // Arrange
        List<Coupon> activeCoupons = new ArrayList<>();
        activeCoupons.add(new Coupon(1L, "TEST123", 10L, 0L, "VALUE", 50L, true, new Date(2050, 12, 12)));
        activeCoupons.add(new Coupon(2L, "TEST123", 10L, 0L, "VALUE", 50L, true, new Date(2050, 12, 12)));


        when(couponRepository.findAllByActiveTrue()).thenReturn(activeCoupons);

        // Act
        List<CouponModel> result = couponsService.getActiveCoupons();

        // Arrange
        assertEquals(activeCoupons.size(), result.size());
        verify(couponRepository, times(1)).findAllByActiveTrue();
    }

    @Test
    public void testApplyCoupon() {
        // Arrange
        String couponCode = "TEST123";
        UseCouponReq useCouponReq = new UseCouponReq();
        Coupon coupon = new Coupon();
        coupon.setCode(couponCode);
        coupon.setUsageNumber(0L);
        coupon.setActive(true);
        coupon.setMaxAllowedUses(10L);

        when(couponRepository.findByCode(couponCode)).thenReturn(Optional.of(coupon));

        // Act
        couponsService.applyCoupon(couponCode, useCouponReq);

        // Assert
        verify(couponRepository, times(1)).findByCode(couponCode);
        verify(consumptionHistoryRepository, times(1)).save(any(ConsumptionHistory.class));
        assertEquals(1L, coupon.getUsageNumber());
    }

    @Test
    public void testApplyCoupon_WithNotExistingCode () {

        when(couponRepository.findByCode(any())).thenThrow(CouponNotFoundException.class);

        assertThrows(CouponNotFoundException.class, () -> couponsService.applyCoupon("TEST123", new UseCouponReq()));
    }



}
