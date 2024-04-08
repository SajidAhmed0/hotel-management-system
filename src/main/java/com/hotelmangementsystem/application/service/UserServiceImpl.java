package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Booking;
import com.hotelmangementsystem.application.entity.Payment;
import com.hotelmangementsystem.application.entity.User;
import com.hotelmangementsystem.application.repository.BookingRepository;
import com.hotelmangementsystem.application.repository.PaymentRepository;
import com.hotelmangementsystem.application.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public UserDetailsService userDetailsService(){
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return userRepository.findUserByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User addUser(User user) {
        Optional<User> userByEmail = userRepository.findUserByEmail(user.getEmail());
        if(userByEmail.isPresent()){
            throw new IllegalStateException("Email exists");
        }

        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        User userDB = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User with id " + id + " does not exists"));

        if(user != null){
            userDB.setFirstName(user.getFirstName());
            userDB.setLastName(user.getLastName());
            userDB.setEmail(user.getEmail());
            userDB.setPassword(user.getPassword());
            userDB.setPhone(user.getPhone());
            userDB.setCountry(user.getCountry());
            userDB.setDistrict(user.getDistrict());
            userDB.setStreet(user.getStreet());
            return userRepository.save(userDB);
        }
        return null;

    }

    @Override
    public String deleteUser(Long id) {
        boolean exists = userRepository.existsById(id);
        if(!exists){
            throw new EntityNotFoundException("User with id " + id + " does not exists");
        }
        userRepository.deleteById(id);
        return "deleted";
    }

    @Transactional
    @Override
    public User addBookingToUser(Long userId, Long bookingId) {
        User user = getUser(userId);
        Booking booking = bookingRepository.findById(bookingId).orElse(null);

        if(user != null && booking != null){
//            user.addBooking(booking);
            booking.setUser(user);
            return user;
        }

        return null;
    }

    @Transactional
    @Override
    public User removeBookingFromUser(Long userId, Long bookingId) {
        User user = getUser(userId);
        Booking booking = bookingRepository.findById(bookingId).orElse(null);

        if(user != null && booking != null){
//            user.removeBooking(booking);
            booking.setUser(null);
            return user;
        }

        return null;
    }

    @Override
    public List<Booking> getAllBookingsOfUser(Long userId) {
        User user = getUser(userId);
        if(user != null){
            return user.getBookings();
        }
        return null;
    }

    @Transactional
    @Override
    public User addPaymentToUser(Long userId, Long paymentId) {
        User user = getUser(userId);
        Payment payment = paymentRepository.findById(paymentId).orElse(null);

        if(user != null && payment != null){
//            user.addPayment(payment);
            payment.setUser(user);

            return user;
        }

        return  null;
    }

    @Transactional
    @Override
    public User removePaymentFromUser(Long userId, Long paymentId) {
        User user = getUser(userId);
        Payment payment = paymentRepository.findById(paymentId).orElse(null);

        if(user != null && payment != null){
//            user.removePayment(payment);
            payment.setUser(null);

            return user;
        }

        return  null;
    }

    @Override
    public List<Payment> getAllPaymentsOfUser(Long userId) {
        User user = getUser(userId);
        if (user != null) {
            return user.getPayments();
        }
        return null;
    }
}
