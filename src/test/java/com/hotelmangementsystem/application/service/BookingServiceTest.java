package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.BookedPrice;
import com.hotelmangementsystem.application.entity.Booking;
import com.hotelmangementsystem.application.entity.Passenger;
import com.hotelmangementsystem.application.repository.BookedPriceRepository;
import com.hotelmangementsystem.application.repository.BookingRepository;
import com.hotelmangementsystem.application.repository.PassengerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class BookingServiceTest {

    @Autowired
    private BookingService bookingService;

    @MockBean
    private BookingRepository bookingRepository;

    @MockBean
    private BookedPriceRepository bookedPriceRepository;

    @MockBean
    private PassengerRepository passengerRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getAllBookings() {
        List<Booking> bookings = new ArrayList<>();
        bookings.add(new Booking());
        bookings.add(new Booking());
        bookings.add(new Booking());

        when(bookingRepository.findAll()).thenReturn(bookings);

        // Test
        List<Booking> result = bookingService.getAllBookings();

        // Verify
        assertNotNull(result);
        assertEquals(3, result.size());
    }

    @Test
    void getBooking() {
        long bookingId = 1L;
        Booking booking = new Booking();
        booking.setId(bookingId);

        when(bookingRepository.findById(bookingId)).thenReturn(Optional.of(booking));

        // Test
        Booking result = bookingService.getBooking(bookingId);

        // Verify
        assertNotNull(result);
        assertEquals(bookingId, result.getId());
    }

    @Test
    void addBooking() {
        Booking booking = new Booking();

        when(bookingRepository.save(Mockito.any(Booking.class))).thenReturn(booking);

        // Test
        Booking result = bookingService.addBooking(booking);

        // Verify
        assertNotNull(result);
    }

    @Test
    void updateBooking() {
        long bookingId = 1L;
        Booking booking = new Booking();
        booking.setId(bookingId);

        when(bookingRepository.findById(bookingId)).thenReturn(Optional.of(booking));
        when(bookingRepository.save(Mockito.any(Booking.class))).thenReturn(booking);

        // Test
        Booking result = bookingService.updateBooking(bookingId, booking);

        // Verify
        assertNotNull(result);
        assertEquals(bookingId, result.getId());

    }

    @Test
    void deleteBooking() {
        long bookingId = 1L;
        Booking booking = new Booking();
        booking.setId(bookingId);

        when(bookingRepository.existsById(bookingId)).thenReturn(true);

        // Test
        assertDoesNotThrow(() -> bookingService.deleteBooking(bookingId));
    }

    @Test
    void addBookedPriceToBooking() {
        Booking booking = new Booking();
        BookedPrice bookedPrice = new BookedPrice();

        // Mock the behavior of the bookedPriceRepository.findById method
        when(bookedPriceRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(bookedPrice));
        // Mock the behavior of the bookingRepository.findById method
        when(bookingRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(booking));

        Long bookingId = 1l;
        Long bookedPriceId = 1l;

        // Call the service method to add the booked price to the booking
        Booking updatedBooking = bookingService.addBookedPriceToBooking(bookingId, bookedPriceId);

        // Verify that the booked price was added to the booking
        assertNotNull(updatedBooking);
        assertTrue(bookedPrice.getBooking() != null);
    }

    @Test
    void removeBookedPriceFromBooking() {Booking booking = new Booking();
        BookedPrice bookedPrice = new BookedPrice();
        // Add the booked price to the booking
        booking.addBookedPrice(bookedPrice);

        // Mock the behavior of the bookedPriceRepository.findById method
        when(bookedPriceRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(bookedPrice));
        // Mock the behavior of the bookingRepository.findById method
        when(bookingRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(booking));

        Long bookingId = 1l;
        Long bookedPriceId = 1l;

        // Call the service method to remove the booked price from the booking
        Booking updatedBooking = bookingService.removeBookedPriceFromBooking(bookingId, bookedPriceId);

        // Verify that the booked price was removed from the booking
        assertNotNull(updatedBooking);
        assertFalse(bookedPrice.getBooking() != null);

    }

    @Test
    void getAllBookedPricesOfBooking() {
        Booking booking = new Booking();
        BookedPrice bookedPrice1 = new BookedPrice();
        BookedPrice bookedPrice2 = new BookedPrice();
        booking.addBookedPrice(bookedPrice1);
        booking.addBookedPrice(bookedPrice2);

        // Mock the behavior of the bookingRepository.findById method
        when(bookingRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(booking));
        Long bookingId = 1l;
        // Call the service method to get all booked prices of the booking
        List<BookedPrice> bookedPrices = bookingService.getAllBookedPricesOfBooking(bookingId);

        // Verify that the returned list contains all booked prices of the booking
        assertNotNull(bookedPrices);
        assertEquals(2, bookedPrices.size());
        assertTrue(bookedPrices.contains(bookedPrice1));
        assertTrue(bookedPrices.contains(bookedPrice2));
    }

    @Test
    void addPassengerToBooking() {
        Booking booking = new Booking();
        Passenger passenger = new Passenger();

        // Mock the behavior of the passengerRepository.findById method
        when(passengerRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(passenger));
        // Mock the behavior of the bookingRepository.findById method
        when(bookingRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(booking));

        Long bookingId = 1l;
        Long passengerId = 1l;

        // Call the service method to add the passenger to the booking
        Booking updatedBooking = bookingService.addPassengerToBooking(bookingId, passengerId);

        // Verify that the passenger was added to the booking
        assertNotNull(updatedBooking);
        assertTrue(passenger.getBooking() != null);
    }

    @Test
    void removePassengerFromBooking() {
        Booking booking = new Booking();
        Passenger passenger = new Passenger();
        // Add the passenger to the booking
        booking.addPassenger(passenger);

        // Mock the behavior of the passengerRepository.findById method
        when(passengerRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(passenger));
        // Mock the behavior of the bookingRepository.findById method
        when(bookingRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(booking));

        Long bookingId = 1l;
        Long passengerId = 1l;

        // Call the service method to remove the passenger from the booking
        Booking updatedBooking = bookingService.removePassengerFromBooking(bookingId, passengerId);

        // Verify that the passenger was removed from the booking
        assertNotNull(updatedBooking);
        assertFalse(passenger.getBooking() != null);
    }

    @Test
    void getAllPassengersOfBooking() {
        Booking booking = new Booking();
        Passenger passenger1 = new Passenger();
        Passenger passenger2 = new Passenger();
        booking.addPassenger(passenger1);
        booking.addPassenger(passenger2);

        // Mock the behavior of the bookingRepository.findById method
        when(bookingRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(booking));

        Long bookingId = 1l;

        // Call the service method to get all passengers of the booking
        List<Passenger> passengers = bookingService.getAllPassengersOfBooking(bookingId);

        // Verify that the returned list contains all passengers of the booking
        assertNotNull(passengers);
        assertEquals(2, passengers.size());
        assertTrue(passengers.contains(passenger1));
        assertTrue(passengers.contains(passenger2));
    }
}