package com.hotelmangementsystem.application.controller;

import com.hotelmangementsystem.application.entity.Discount;
import com.hotelmangementsystem.application.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/discounts")
public class DiscountController {

    @Autowired
    private DiscountService discountService;

    @GetMapping
    public List<Discount> getAllDiscounts(){
        return discountService.getAllDiscounts();
    }

    @GetMapping("/{id}")
    public Discount getDiscount(@PathVariable("id") Long id) {
        return discountService.getDiscount(id);
    }

    @PostMapping
    public Discount addDiscount(@RequestBody Discount discount){
        return discountService.addDiscount(discount);
    }

    @PutMapping("/{id}")
    public Discount updateDiscount(@PathVariable("id") Long id, @RequestBody Discount discount){
        return discountService.updateDiscount(id, discount);
    }

    @DeleteMapping("/{id}")
    public String deleteDiscount(@PathVariable("id") Long id){
        return discountService.deleteDiscount(id);
    }
}
