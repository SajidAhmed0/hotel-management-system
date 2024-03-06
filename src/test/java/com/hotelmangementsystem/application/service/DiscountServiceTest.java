package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Discount;
import com.hotelmangementsystem.application.repository.DiscountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class DiscountServiceTest {

    @Autowired
    private DiscountService discountService;

    @MockBean
    private DiscountRepository discountRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getAllDiscounts() {
        List<Discount> discounts = new ArrayList<>();
        discounts.add(new Discount());
        discounts.add(new Discount());

        when(discountRepository.findAll()).thenReturn(discounts);

        // Test
        List<Discount> result = discountService.getAllDiscounts();

        // Verify
        assertEquals(2, result.size());
    }

    @Test
    void getDiscount() {
        Discount discount = new Discount();
        long id = 1L;

        when(discountRepository.findById(id)).thenReturn(Optional.of(discount));

        // Test
        Discount result = discountService.getDiscount(id);

        // Verify
        assertNotNull(result);
    }

    @Test
    void addDiscount() {
        Discount discount = new Discount();

        when(discountRepository.save(Mockito.any(Discount.class))).thenReturn(discount);

        // Test
        Discount result = discountService.addDiscount(discount);

        // Verify
        assertNotNull(result);
    }

    @Test
    void updateDiscount() {
        long id = 1L;
        Discount existingDiscount = new Discount();
        existingDiscount.setId(id);
        existingDiscount.setName("Existing Discount");

        Discount updatedDiscount = new Discount();
        updatedDiscount.setId(id);
        updatedDiscount.setName("Updated Discount");

        when(discountRepository.findById(id)).thenReturn(Optional.of(existingDiscount));
        when(discountRepository.save(Mockito.any(Discount.class))).thenReturn(updatedDiscount);

        // Test
        Discount result = discountService.updateDiscount(id, updatedDiscount);

        // Verify
        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals("Updated Discount", result.getName());
    }

    @Test
    void deleteDiscount() {
        long id = 1L;

        when(discountRepository.existsById(id)).thenReturn(true);

        // Test
        String result = discountService.deleteDiscount(id);

        // Verify
        assertEquals("deleted", result);
    }
}