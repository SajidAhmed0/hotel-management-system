package com.hotelmangementsystem.application.controller;

import com.hotelmangementsystem.application.entity.BookedDiscount;
import com.hotelmangementsystem.application.service.BookedDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookeddiscounts")
public class BookedDiscountController {

    @Autowired
    private BookedDiscountService bookedDiscountService;

    @GetMapping
    public List<BookedDiscount> getAllBookedDiscounts(){
        return bookedDiscountService.getAllBookedDiscounts();
    }

    @GetMapping("/{id}")
    public BookedDiscount getBookedDiscount(@PathVariable("id") Long id) {
        return bookedDiscountService.getBookedDiscount(id);
    }

    @PostMapping
    public BookedDiscount addBookedDiscount(@RequestBody BookedDiscount bookedDiscount){
        return bookedDiscountService.addBookedDiscount(bookedDiscount);
    }

    @PutMapping("/{id}")
    public BookedDiscount updateBookedDiscount(@PathVariable("id") Long id, @RequestBody BookedDiscount bookedDiscount){
        return bookedDiscountService.updateBookedDiscount(id, bookedDiscount);
    }

    @DeleteMapping("/{id}")
    public String deleteBookedDiscount(@PathVariable("id") Long id){
        return bookedDiscountService.deleteBookedDiscount(id);
    }
}
