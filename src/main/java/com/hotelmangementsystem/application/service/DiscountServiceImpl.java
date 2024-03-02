package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Discount;
import com.hotelmangementsystem.application.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DiscountServiceImpl implements DiscountService{

    @Autowired
    private DiscountRepository discountRepository;

    @Override
    public ArrayList<Discount> getAllDiscounts() {
        return (ArrayList<Discount>) discountRepository.findAll();
    }

    @Override
    public Discount getDiscount(Long id) {
        return discountRepository.findById(id).get();
    }

    @Override
    public Discount addDiscount(Discount discount) {
        return discountRepository.save(discount);
    }

    @Override
    public Discount updateDiscount(Long id, Discount discount) {
        Discount discountDB = discountRepository.findById(id).get();
        discountDB.setPercentage(discount.getPercentage());
        return discountRepository.save(discountDB);
    }

    @Override
    public String deleteDiscount(Long id) {
        discountRepository.deleteById(id);
        return "deleted";
    }
}
