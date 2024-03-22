package com.hotelmangementsystem.application.controller;

import com.hotelmangementsystem.application.entity.*;
import com.hotelmangementsystem.application.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping
    public List<Booking> getAllBookings(){
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

    @PutMapping("/{bookingId}/bookedprices/{bookedpriceId}")
    public Booking addBookedPriceToBooking(@PathVariable("bookingId") Long bookingId, @PathVariable("bookedpriceId") Long bookedpriceId){
        return bookingService.addBookedPriceToBooking(bookingId, bookedpriceId);
    }
    @DeleteMapping("/{bookingId}/bookedprices/{bookedpriceId}")
    public Booking removeBookedPriceFromBooking(@PathVariable("bookingId") Long bookingId, @PathVariable("bookedpriceId") Long bookedpriceId){
        return bookingService.removeBookedPriceFromBooking(bookingId, bookedpriceId);
    }

    @GetMapping("/{id}/bookedprices")
    public List<BookedPrice> getAllBookedPricesOfBooking(@PathVariable("id") Long id) {
        return bookingService.getAllBookedPricesOfBooking(id);
    }

    @PutMapping("/{bookingId}/passengers/{passengerId}")
    public Booking addPassengeroBooking(@PathVariable("bookingId") Long bookingId, @PathVariable("passengerId") Long passengerId){
        return bookingService.addPassengerToBooking(bookingId, passengerId);
    }
    @DeleteMapping("/{bookingId}/passengers/{passengerId}")
    public Booking removePassengerFromBooking(@PathVariable("bookingId") Long bookingId, @PathVariable("passengerId") Long passengerId){
        return bookingService.removePassengerFromBooking(bookingId, passengerId);
    }

    @GetMapping("/{id}/passengers")
    public List<Passenger> getAllPassengersOfBooking(@PathVariable("id") Long id) {
        return bookingService.getAllPassengersOfBooking(id);
    }

    @PutMapping("/{bookingId}/bookedroomtypes/{bookedroomtypeId}")
    public Booking addBookedRoomTypeToBooking(@PathVariable("bookingId") Long bookingId, @PathVariable("bookedroomtypeId") Long bookedroomtypeId){
        return bookingService.addBookedRoomTypeToBooking(bookingId, bookedroomtypeId);
    }
    @DeleteMapping("/{bookingId}/bookedroomtypes/{bookedroomtypeId}")
    public Booking removeBookedRoomTypeFromBooking(@PathVariable("bookingId") Long bookingId, @PathVariable("bookedroomtypeId") Long bookedroomtypeId){
        return bookingService.removeBookedRoomTypeFromBooking(bookingId, bookedroomtypeId);
    }

    @GetMapping("/{id}/bookedroomtypes")
    public BookedRoomType getAllBookedRoomTypesOfBooking(@PathVariable("id") Long id) {
        return bookingService.getAllBookedRoomTypesOfBooking(id);
    }

    @PutMapping("/{bookingId}/bookeddiscounts/{bookeddiscountId}")
    public Booking addBookedDiscountToBooking(@PathVariable("bookingId") Long bookingId, @PathVariable("bookeddiscountId") Long bookeddiscountId){
        return bookingService.addBookedDiscountToBooking(bookingId, bookeddiscountId);
    }
    @DeleteMapping("/{bookingId}/bookeddiscounts/{bookeddiscountId}")
    public Booking removeBookedDiscountFromBooking(@PathVariable("bookingId") Long bookingId, @PathVariable("bookeddiscountId") Long bookeddiscountId){
        return bookingService.removeBookedDiscountFromBooking(bookingId, bookeddiscountId);
    }

    @GetMapping("/{id}/bookeddiscounts")
    public List<BookedDiscount> getAllBookedDiscountsOfBooking(@PathVariable("id") Long id) {
        return bookingService.getAllBookedDiscountsOfBooking(id);
    }

    @PutMapping("/{bookingId}/bookedsupplements/{bookedsupplementId}")
    public Booking addBookedSupplementToBooking(@PathVariable("bookingId") Long bookingId, @PathVariable("bookedsupplementId") Long bookedsupplementId){
        return bookingService.addBookedSupplementToBooking(bookingId, bookedsupplementId);
    }
    @DeleteMapping("/{bookingId}/bookedsupplements/{bookedsupplementId}")
    public Booking removeBookedSupplementFromBooking(@PathVariable("bookingId") Long bookingId, @PathVariable("bookedsupplementId") Long bookedsupplementId){
        return bookingService.removeBookedSupplementFromBooking(bookingId, bookedsupplementId);
    }

    @GetMapping("/{id}/bookedsupplements")
    public List<BookedSupplement> getAllBookedSupplementsOfBooking(@PathVariable("id") Long id) {
        return bookingService.getAllBookedSupplementsOfBooking(id);
    }
}
