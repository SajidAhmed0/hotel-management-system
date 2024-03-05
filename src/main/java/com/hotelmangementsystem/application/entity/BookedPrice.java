package com.hotelmangementsystem.application.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.jmx.export.annotation.ManagedAttribute;

@Entity
public class BookedPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String type;

    private String name;

    private Double price;

    //TODO: create booking

    @JsonIgnore
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "booking_id",
            referencedColumnName = "id"
    )
    private Booking booking;

    public BookedPrice() {
    }

    public BookedPrice(String type, String name, Double price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public BookedPrice(Long id, String type, String name, Double price) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
