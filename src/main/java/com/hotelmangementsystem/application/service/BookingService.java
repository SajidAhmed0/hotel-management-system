package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.*;

import java.util.ArrayList;
import java.util.List;

public interface BookingService {
    public List<Booking> getAllBookings();

    public Booking getBooking(Long id);

    public Booking addBooking(Booking booking);

    public Booking updateBooking(Long id, Booking booking);

    public String deleteBooking(Long id);

    public Booking addBookedPriceToBooking(Long bookingId, Long bookedPriceId);

    public Booking removeBookedPriceFromBooking(Long bookingId, Long bookedPriceId);

    public List<BookedPrice> getAllBookedPricesOfBooking(Long id);

    public Booking addPassengerToBooking(Long bookingId, Long passengerId);

    public Booking removePassengerFromBooking(Long bookingId, Long passengerId);

    public List<Passenger> getAllPassengersOfBooking(Long id);

    public Booking addBookedRoomTypeToBooking(Long bookingId, Long bookedRoomTypeId);

    public Booking removeBookedRoomTypeFromBooking(Long bookingId, Long bookedRoomTypeId);

    public BookedRoomType getAllBookedRoomTypesOfBooking(Long id);

    public Booking addBookedDiscountToBooking(Long bookingId, Long bookedDiscountId);

    public Booking removeBookedDiscountFromBooking(Long bookingId, Long bookedDiscountId);

    public List<BookedDiscount> getAllBookedDiscountsOfBooking(Long id);

    public Booking addBookedSupplementToBooking(Long bookingId, Long bookedSupplementId);

    public Booking removeBookedSupplementFromBooking(Long bookingId, Long bookedSupplementId);

    public List<BookedSupplement> getAllBookedSupplementsOfBooking(Long id);
}
