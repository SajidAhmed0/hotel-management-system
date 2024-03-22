package com.hotelmangementsystem.application.controller;

import com.hotelmangementsystem.application.entity.BookedPrice;
import com.hotelmangementsystem.application.service.BookedPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/bookedprices")
public class BookedPriceController {

    @Autowired
    private BookedPriceService bookedPriceService;

    @GetMapping
    public List<BookedPrice> getAllBookedPrices(){
        return bookedPriceService.getAllBookedPrices();
    }

    @GetMapping("/{id}")
    public BookedPrice getBookedPrice(@PathVariable("id") Long id) {
        return bookedPriceService.getBookedPrice(id);
    }

    @PostMapping
    public BookedPrice addBookedPrice(@RequestBody BookedPrice bookedPrice){
        return bookedPriceService.addBookedPrice(bookedPrice);
    }

    @PutMapping("/{id}")
    public BookedPrice updateBookedPrice(@PathVariable("id") Long id, @RequestBody BookedPrice bookedPrice){
        return bookedPriceService.updateBookedPrice(id, bookedPrice);
    }

    @DeleteMapping("/{id}")
    public String deleteBookedPrice(@PathVariable("id") Long id){
        return bookedPriceService.deleteBookedPrice(id);
    }
}
