package com.hotelmangementsystem.application.controller;

import com.hotelmangementsystem.application.entity.BookedSupplement;
import com.hotelmangementsystem.application.service.BookedSupplementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/bookedsupplements")
public class BookedSupplementController {

    @Autowired
    private BookedSupplementService bookedSupplementService;

    @GetMapping
    public List<BookedSupplement> getAllBookedSupplements(){
        return bookedSupplementService.getAllBookedSupplements();
    }

    @GetMapping("/{id}")
    public BookedSupplement getBookedSupplement(@PathVariable("id") Long id) {
        return bookedSupplementService.getBookedSupplement(id);
    }

    @PostMapping
    public BookedSupplement addBookedSupplement(@RequestBody BookedSupplement bookedSupplement){
        return bookedSupplementService.addBookedSupplement(bookedSupplement);
    }

    @PutMapping("/{id}")
    public BookedSupplement updateBookedSupplement(@PathVariable("id") Long id, @RequestBody BookedSupplement bookedSupplement){
        return bookedSupplementService.updateBookedSupplement(id, bookedSupplement);
    }

    @DeleteMapping("/{id}")
    public String deleteBookedSupplement(@PathVariable("id") Long id){
        return bookedSupplementService.deleteBookedSupplement(id);
    }
}
