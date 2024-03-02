package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Payment;
import com.hotelmangementsystem.application.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public ArrayList<Payment> getAllPayments() {
        return (ArrayList<Payment>) paymentRepository.findAll();
    }

    @Override
    public Payment getPayment(Long id) {
        return paymentRepository.findById(id).get();
    }

    @Override
    public Payment addPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment updatePayment(Long id, Payment payment) {
        Payment paymentDB = paymentRepository.findById(id).get();
        paymentDB.setAmount(payment.getAmount());
        return paymentRepository.save(paymentDB);
    }

    @Override
    public String deletePayment(Long id) {
        paymentRepository.deleteById(id);
        return "deleted";
    }
}
