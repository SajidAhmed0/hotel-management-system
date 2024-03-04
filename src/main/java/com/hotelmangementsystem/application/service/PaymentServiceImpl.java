package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Payment;
import com.hotelmangementsystem.application.repository.PaymentRepository;
import jakarta.persistence.EntityNotFoundException;
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
        return paymentRepository.findById(id).orElse(null);
    }

    @Override
    public Payment addPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment updatePayment(Long id, Payment payment) {
        Payment paymentDB = paymentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Payment with id " + id + " does not exists"));

        if(payment != null){
            paymentDB.setDate(payment.getDate());
            paymentDB.setAmount(payment.getAmount());
            paymentDB.setMethod(payment.getMethod());
            return paymentRepository.save(paymentDB);
        }
        return null;

    }

    @Override
    public String deletePayment(Long id) {
        boolean exists = paymentRepository.existsById(id);
        if(!exists){
            throw new EntityNotFoundException("Payment with id " + id + " does not exists");
        }
        paymentRepository.deleteById(id);
        return "deleted";
    }
}
