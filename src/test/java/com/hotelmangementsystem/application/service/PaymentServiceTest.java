package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Payment;
import com.hotelmangementsystem.application.repository.PassengerRepository;
import com.hotelmangementsystem.application.repository.PaymentRepository;
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
class PaymentServiceTest {

    @Autowired
    private PaymentService paymentService;

    @MockBean
    private PaymentRepository paymentRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getAllPayments() {
        List<Payment> payments = new ArrayList<>();
        payments.add(new Payment());
        payments.add(new Payment());

        when(paymentRepository.findAll()).thenReturn(payments);

        // Test
        List<Payment> result = paymentService.getAllPayments();

        // Verify
        assertEquals(2, result.size());
    }

    @Test
    void getPayment() {
        Payment payment = new Payment();
        long id = 1L;

        when(paymentRepository.findById(id)).thenReturn(Optional.of(payment));

        // Test
        Payment result = paymentService.getPayment(id);

        // Verify
        assertNotNull(result);

    }

    @Test
    void addPayment() {
        Payment payment = new Payment();

        when(paymentRepository.save(Mockito.any(Payment.class))).thenReturn(payment);

        // Test
        Payment result = paymentService.addPayment(payment);

        // Verify
        assertNotNull(result);
    }

    @Test
    void updatePayment() {
        long id = 1L;
        Payment existingPayment = new Payment();
        existingPayment.setId(id);
        existingPayment.setAmount(100.00);

        Payment updatedPayment = new Payment();
        updatedPayment.setId(id);
        updatedPayment.setAmount(200.00);

        when(paymentRepository.findById(id)).thenReturn(Optional.of(existingPayment));
        when(paymentRepository.save(Mockito.any(Payment.class))).thenReturn(updatedPayment);

        // Test
        Payment result = paymentService.updatePayment(id, updatedPayment);

        // Verify
        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals(200.00, result.getAmount());
    }

    @Test
    void deletePayment() {
        long id = 1L;

        when(paymentRepository.existsById(id)).thenReturn(true);

        // Test
        String result = paymentService.deletePayment(id);

        // Verify
        assertEquals("deleted", result);
    }
}