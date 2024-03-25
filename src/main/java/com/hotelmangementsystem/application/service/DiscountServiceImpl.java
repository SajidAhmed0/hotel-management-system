package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Discount;
import com.hotelmangementsystem.application.repository.DiscountRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiscountServiceImpl implements DiscountService{

    @Autowired
    private DiscountRepository discountRepository;

    @Override
    public List<Discount> getAllDiscounts() {
        return discountRepository.findAll();
    }

    @Override
    public Discount getDiscount(Long id) {
        return discountRepository.findById(id).orElse(null);
    }

    @Override
    public Discount addDiscount(Discount discount) {
        return discountRepository.save(discount);
    }

    @Override
    public Discount updateDiscount(Long id, Discount discount) {
        Discount discountDB = discountRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Discount with id " + id + " does not exists"));

        if(discount != null){
            discountDB.setName(discount.getName());
            discountDB.setDescription(discount.getDescription());
            discountDB.setPercentage(discount.getPercentage());
            discountDB.setDaysPriorToArrival(discount.getDaysPriorToArrival());
            return discountRepository.save(discountDB);
        }
        return null;

    }

    @Override
    public String deleteDiscount(Long id) {
        boolean exists = discountRepository.existsById(id);
        if(!exists) {
            throw new EntityNotFoundException("Discount with id " + id + " does not exists");
        }
        discountRepository.deleteById(id);
        return "deleted";
    }
}
