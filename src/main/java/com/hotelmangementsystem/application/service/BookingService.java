package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Booking;

import java.util.ArrayList;

public interface BookingService {
    public ArrayList<Booking> getAllBookings();

    public Booking getBooking(Long id);

    public Booking addBooking(Booking booking);

    public Booking updateBooking(Long id, Booking booking);

    public String deleteBooking(Long id);
}
