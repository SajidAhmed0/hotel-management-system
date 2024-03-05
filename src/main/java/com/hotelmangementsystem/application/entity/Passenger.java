package com.hotelmangementsystem.application.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String phone;

    private String name;

    //TODO: create booking
    @JsonIgnore
    @ManyToOne
    @JoinColumn(
            name = "booking_id",
            referencedColumnName = "id"
    )
    private Booking booking;

    public Passenger() {
    }

    public Passenger(String phone, String name) {
        this.phone = phone;
        this.name = name;
    }

    public Passenger(Long id, String phone, String name) {
        this.id = id;
        this.phone = phone;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
