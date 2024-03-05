package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Booking;
import com.hotelmangementsystem.application.entity.Payment;
import com.hotelmangementsystem.application.entity.User;

import java.util.ArrayList;
import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public User getUser(Long id);

    public User addUser(User user);

    public User updateUser(Long id, User user);

    public String deleteUser(Long id);

    public User addBookingToUser(Long userId, Long bookingId);

    public User removeBookingFromUser(Long userId, Long bookingId);

    public List<Booking> getAllBookingsOfUser(Long userId);

    public User addPaymentToUser(Long userId, Long paymentId);

    public User removePaymentFromUser(Long userId, Long paymentId);

    public List<Payment> getAllPaymentsOfUser(Long userId);
}
