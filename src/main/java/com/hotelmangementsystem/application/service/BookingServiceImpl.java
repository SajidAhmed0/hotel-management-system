package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Booking;
import com.hotelmangementsystem.application.repository.BookingRepository;
import jakarta.persistence.EntityNotFoundException;
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
        return bookingRepository.findById(id).orElse(null);
    }

    @Override
    public Booking addBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Booking updateBooking(Long id, Booking booking) {
        Booking bookingDB = bookingRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Booking with id " + id + " does not exists"));

        if(booking != null){
            bookingDB.setCheckInDate(booking.getCheckInDate());
            bookingDB.setCheckOutDate(booking.getCheckOutDate());
            bookingDB.setNoOfAdult(booking.getNoOfAdult());
            bookingDB.setStatus(booking.getStatus());
            bookingDB.setTotal(booking.getTotal());
            return bookingRepository.save(bookingDB);
        }
        return null;

    }

    @Override
    public String deleteBooking(Long id) {
        boolean exists = bookingRepository.existsById(id);
        if(!exists) {
            throw new EntityNotFoundException("Booking with id " + id + " does not exists");
        }
        bookingRepository.deleteById(id);
        return "deleted";
    }
}
