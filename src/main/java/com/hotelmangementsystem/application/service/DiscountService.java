package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Discount;

import java.util.ArrayList;
import java.util.List;

public interface DiscountService {
    public List<Discount> getAllDiscounts();

    public Discount getDiscount(Long id);

    public Discount addDiscount(Discount discount);

    public Discount updateDiscount(Long id, Discount discount);

    public String deleteDiscount(Long id);
}
