package com.hotelmangementsystem.application.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "client")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String phone;

    private String country;

    private String district;

    private String street;

    //TODO: create bookings and payments
    @OneToMany(
            mappedBy = "user",
            fetch = FetchType.LAZY
    )
    private List<Booking> bookings = new ArrayList<>();

    @OneToMany(
            mappedBy = "user",
            fetch = FetchType.LAZY
    )
    private List<Payment> payments = new ArrayList<>();

    public User() {
    }

    public User(String firstName, String lastName, String email, String password, String phone, String country, String district, String street) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.country = country;
        this.district = district;
        this.street = street;
    }

    public User(Long id, String firstName, String lastName, String email, String password, String phone, String country, String district, String street) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.country = country;
        this.district = district;
        this.street = street;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public void addBooking(Booking booking){
        this.bookings.add(booking);
    }

    public void removeBooking(Booking booking){
        this.bookings.remove(booking);
    }

    public void addPayment(Payment payment){
        this.payments.add(payment);
    }

    public void removePayment(Payment payment){
        this.payments.remove(payment);
    }
}
