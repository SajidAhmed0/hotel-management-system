package com.hotelmangementsystem.application.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class BookedRoomType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Integer noOfRooms;

    private Integer maxAdult;

    private String description;

    private Double price;

    private Long originalId;

    @JsonIgnore
    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "booking_id",
            referencedColumnName = "id"
    )
    private Booking booking;

    public BookedRoomType() {
    }

    public BookedRoomType(String name, Integer noOfRooms, Integer maxAdult, String description, Double price, Long originalId) {
        this.name = name;
        this.noOfRooms = noOfRooms;
        this.maxAdult = maxAdult;
        this.description = description;
        this.price = price;
        this.originalId = originalId;
    }

    public BookedRoomType(Long id, String name, Integer noOfRooms, Integer maxAdult, String description, Double price, Long originalId) {
        this.id = id;
        this.name = name;
        this.noOfRooms = noOfRooms;
        this.maxAdult = maxAdult;
        this.description = description;
        this.price = price;
        this.originalId = originalId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(Integer noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public Integer getMaxAdult() {
        return maxAdult;
    }

    public void setMaxAdult(Integer maxAdult) {
        this.maxAdult = maxAdult;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getOriginalId() {
        return originalId;
    }

    public void setOriginalId(Long originalId) {
        this.originalId = originalId;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
