package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.BookedPrice;
import com.hotelmangementsystem.application.entity.Booking;
import com.hotelmangementsystem.application.entity.Passenger;
import com.hotelmangementsystem.application.repository.BookedPriceRepository;
import com.hotelmangementsystem.application.repository.BookingRepository;
import com.hotelmangementsystem.application.repository.PassengerRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BookedPriceRepository bookedPriceRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
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
            bookingDB.setNoOfRooms(booking.getNoOfRooms());
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

    @Transactional
    @Override
    public Booking addBookedPriceToBooking(Long bookingId, Long bookedPriceId) {
        Booking booking = getBooking(bookingId);
        BookedPrice bookedPrice = bookedPriceRepository.findById(bookedPriceId).orElse(null);

        if(booking != null && bookedPrice != null){
//            booking.addBookedPrice(bookedPrice);
            bookedPrice.setBooking(booking);

            return booking;
        }
        return null;
    }

    @Transactional
    @Override
    public Booking removeBookedPriceFromBooking(Long bookingId, Long bookedPriceId) {
        Booking booking = getBooking(bookingId);
        BookedPrice bookedPrice = bookedPriceRepository.findById(bookedPriceId).orElse(null);

        if(booking != null && bookedPrice != null){
//            booking.removeBookedPrice(bookedPrice);
            bookedPrice.setBooking(null);

            return booking;
        }
        return null;
    }

    @Override
    public List<BookedPrice> getAllBookedPricesOfBooking(Long id) {
        Booking booking = getBooking(id);
        if(booking != null){
            return booking.getBookedPrices();
        }
        return null;
    }

    @Transactional
    @Override
    public Booking addPassengerToBooking(Long bookingId, Long passengerId) {
        Booking booking = getBooking(bookingId);
        Passenger passenger = passengerRepository.findById(passengerId).orElse(null);

        if(booking != null && passenger != null){
//            booking.addPassenger(passenger);
            passenger.setBooking(booking);

            return booking;
        }
        return null;
    }

    @Transactional
    @Override
    public Booking removePassengerFromBooking(Long bookingId, Long passengerId) {
        Booking booking = getBooking(bookingId);
        Passenger passenger = passengerRepository.findById(passengerId).orElse(null);

        if(booking != null && passenger != null){
//            booking.removePassenger(passenger);
            passenger.setBooking(null);

            return booking;
        }
        return null;
    }

    @Override
    public List<Passenger> getAllPassengersOfBooking(Long id) {
        Booking booking = getBooking(id);
        if(booking != null){
            return booking.getPassengers();
        }
        return null;
    }
}
