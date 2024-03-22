package com.hotelmangementsystem.application.controller;

import com.hotelmangementsystem.application.entity.Payment;
import com.hotelmangementsystem.application.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public List<Payment> getAllPayments(){
        return paymentService.getAllPayments();
    }

    @GetMapping("/{id}")
    public Payment getPayment(@PathVariable("id") Long id) {
        return paymentService.getPayment(id);
    }

    @PostMapping
    public Payment addPayment(@RequestBody Payment payment){
        return paymentService.addPayment(payment);
    }

    @PutMapping("/{id}")
    public Payment updatePayment(@PathVariable("id") Long id, @RequestBody Payment payment){
        return paymentService.updatePayment(id, payment);
    }

    @DeleteMapping("/{id}")
    public String deletePayment(@PathVariable("id") Long id){
        return paymentService.deletePayment(id);
    }
}
