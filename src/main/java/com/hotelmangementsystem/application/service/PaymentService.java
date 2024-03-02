package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Payment;

import java.util.ArrayList;

public interface PaymentService {
    public ArrayList<Payment> getAllPayments();

    public Payment getPayment(Long id);

    public Payment addPayment(Payment payment);

    public Payment updatePayment(Long id, Payment payment);

    public String deletePayment(Long id);
}
