package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Payment;
import com.hotelmangementsystem.application.repository.PaymentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
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
            paymentDB.setCardNumber(payment.getCardNumber());
            paymentDB.setExpiration(payment.getExpiration());
            paymentDB.setCvv(payment.getCvv());
            paymentDB.setStreetAddress(payment.getStreetAddress());
            paymentDB.setCity(payment.getCity());
            paymentDB.setZipCode(payment.getZipCode());
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
