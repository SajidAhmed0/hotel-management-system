package com.hotelmangementsystem.application.controller;

import com.hotelmangementsystem.application.entity.Booking;
import com.hotelmangementsystem.application.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping
    public ArrayList<Booking> getAllBookings(){
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public Booking getBooking(@PathVariable("id") Long id) {
        return bookingService.getBooking(id);
    }

    @PostMapping
    public Booking addBooking(@RequestBody Booking booking){
        return bookingService.addBooking(booking);
    }

    @PutMapping("/{id}")
    public Booking updateBooking(@PathVariable("id") Long id, @RequestBody Booking booking){
        return bookingService.updateBooking(id, booking);
    }

    @DeleteMapping("/{id}")
    public String deleteBooking(@PathVariable("id") Long id){
        return bookingService.deleteBooking(id);
    }
}
