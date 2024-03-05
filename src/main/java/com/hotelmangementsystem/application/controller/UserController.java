package com.hotelmangementsystem.application.controller;

import com.hotelmangementsystem.application.entity.*;
import com.hotelmangementsystem.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user){
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        return userService.deleteUser(id);
    }

    @PutMapping("/{userId}/bookings/{bookingId}")
    public User addBookingToUser(@PathVariable("userId") Long userId, @PathVariable("bookingId") Long bookingId){
        return userService.addBookingToUser(userId, bookingId);
    }
    @DeleteMapping("/{userId}/bookings/{bookingId}")
    public User removeBookingFromuser(@PathVariable("userId") Long userId, @PathVariable("bookingId") Long bookingId){
        return userService.removeBookingFromUser(userId, bookingId);
    }

    @GetMapping("/{id}/bookings")
    public List<Booking> getAllBookingsOfUser(@PathVariable("id") Long id) {
        return userService.getAllBookingsOfUser(id);
    }

    @PutMapping("/{userId}/payments/{paymentId}")
    public User addPaymentToUser(@PathVariable("userId") Long userId, @PathVariable("paymentId") Long paymentId){
        return userService.addPaymentToUser(userId, paymentId);
    }
    @DeleteMapping("/{userId}/payments/{paymentId}")
    public User removePaymentFromuser(@PathVariable("userId") Long userId, @PathVariable("paymentId") Long paymentId){
        return userService.removePaymentFromUser(userId, paymentId);
    }

    @GetMapping("/{id}/payments")
    public List<Payment> getAllPaymentsOfUser(@PathVariable("id") Long id) {
        return userService.getAllPaymentsOfUser(id);
    }
}
