package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Booking;
import com.hotelmangementsystem.application.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public ArrayList<Booking> getAllBookings() {
        return (ArrayList<Booking>) bookingRepository.findAll();
    }

    @Override
    public Booking getBooking(Long id) {
        return bookingRepository.findById(id).get();
    }

    @Override
    public Booking addBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Booking updateBooking(Long id, Booking booking) {
        Booking bookingDB = bookingRepository.findById(id).get();
        bookingDB.setStatus(booking.getStatus());
        return bookingRepository.save(bookingDB);
    }

    @Override
    public String deleteBooking(Long id) {
        bookingRepository.deleteById(id);
        return "deleted";
    }
}
