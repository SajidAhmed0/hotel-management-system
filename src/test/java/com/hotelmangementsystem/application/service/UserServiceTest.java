package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Booking;
import com.hotelmangementsystem.application.entity.Payment;
import com.hotelmangementsystem.application.entity.User;
import com.hotelmangementsystem.application.repository.BookingRepository;
import com.hotelmangementsystem.application.repository.PaymentRepository;
import com.hotelmangementsystem.application.repository.UserRepository;
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
class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private BookingRepository bookingRepository;

    @MockBean
    private PaymentRepository paymentRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getAllUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());

        when(userRepository.findAll()).thenReturn(users);

        // Test
        List<User> result = userService.getAllUsers();

        // Verify
        assertEquals(2, result.size());
    }

    @Test
    void getUser() {
        long userId = 1L;
        User user = new User();
        user.setId(userId);

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        // Test
        User result = userService.getUser(userId);

        // Verify
        assertNotNull(result);
        assertEquals(userId, result.getId());
    }

    @Test
    void addUser() {
        User user = new User();

        when(userRepository.findUserByEmail(Mockito.any())).thenReturn(Optional.empty());
        when(userRepository.save(Mockito.any())).thenReturn(user);

        // Test
        User result = userService.addUser(user);

        // Verify
        assertNotNull(result);
    }

    @Test
    void updateUser() {
        long userId = 1L;
        User existingUser = new User();
        existingUser.setId(userId);
        existingUser.setEmail("old_email@example.com");

        User updatedUser = new User();
        updatedUser.setEmail("new_email@example.com");

        when(userRepository.findById(userId)).thenReturn(Optional.of(existingUser));
        when(userRepository.save(Mockito.any())).thenReturn(updatedUser);

        // Test
        User result = userService.updateUser(userId, updatedUser);

        // Verify
        assertNotNull(result);
        assertEquals(updatedUser.getEmail(), result.getEmail());
    }

    @Test
    void deleteUser() {
        long userId = 1L;
        User user = new User();
        user.setId(userId);

        when(userRepository.existsById(userId)).thenReturn(true);

        // Test
        assertDoesNotThrow(() -> userService.deleteUser(userId));
    }

    @Test
    void addBookingToUser() {
        long userId = 1L;
        long bookingId = 1L;

        User user = new User();
        user.setId(userId);

        Booking booking = new Booking();
        booking.setId(bookingId);

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(bookingRepository.findById(bookingId)).thenReturn(Optional.of(booking));

        // Test
        assertDoesNotThrow(() -> userService.addBookingToUser(userId, bookingId));

        // Verify
        assertEquals(user, booking.getUser());
    }

    @Test
    void removeBookingFromUser() {
        long userId = 1L;
        long bookingId = 1L;

        User user = new User();
        user.setId(userId);

        Booking booking = new Booking();
        booking.setId(bookingId);
        booking.setUser(user);

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(bookingRepository.findById(bookingId)).thenReturn(Optional.of(booking));

        // Test
        assertDoesNotThrow(() -> userService.removeBookingFromUser(userId, bookingId));

        // Verify
        assertNull(booking.getUser());
    }

    @Test
    void getAllBookingsOfUser() {
        long userId = 1L;
        User user = new User();
        user.setId(userId);
        List<Booking> bookings = new ArrayList<>();
        bookings.add(new Booking());
        bookings.add(new Booking());
        user.setBookings(bookings);

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        // Test
        List<Booking> result = userService.getAllBookingsOfUser(userId);

        // Verify
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    void addPaymentToUser() {
        long userId = 1L;
        long paymentId = 1L;

        User user = new User();
        user.setId(userId);

        Payment payment = new Payment();
        payment.setId(paymentId);

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(paymentRepository.findById(paymentId)).thenReturn(Optional.of(payment));

        // Test
        assertDoesNotThrow(() -> userService.addPaymentToUser(userId, paymentId));

        // Verify
        assertEquals(user, payment.getUser());

    }

    @Test
    void removePaymentFromUser() {
        long userId = 1L;
        long paymentId = 1L;

        User user = new User();
        user.setId(userId);

        Payment payment = new Payment();
        payment.setId(paymentId);
        payment.setUser(user);

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(paymentRepository.findById(paymentId)).thenReturn(Optional.of(payment));

        // Test
        assertDoesNotThrow(() -> userService.removePaymentFromUser(userId, paymentId));

        // Verify
        assertNull(payment.getUser());
    }

    @Test
    void getAllPaymentsOfUser() {
        long userId = 1L;
        User user = new User();
        user.setId(userId);
        List<Payment> payments = new ArrayList<>();
        payments.add(new Payment());
        payments.add(new Payment());
        user.setPayments(payments);

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        // Test
        List<Payment> result = userService.getAllPaymentsOfUser(userId);

        // Verify
        assertNotNull(result);
        assertEquals(2, result.size());
    }
}