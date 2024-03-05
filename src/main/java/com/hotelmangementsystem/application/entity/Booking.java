package com.hotelmangementsystem.application.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date checkInDate;

    private Date checkOutDate;

    private Integer noOfAdult;

    private String Status;

    private Double total;

    //TODO: create discounts, bookedprices, and passengers
    @OneToMany(
            mappedBy = "booking",
            fetch = FetchType.LAZY
    )
    private List<BookedPrice> bookedPrices = new ArrayList<>();

    @OneToMany(
            mappedBy = "booking",
            fetch = FetchType.LAZY
    )
    private List<Passenger> passengers = new ArrayList<>();

    @JsonIgnore
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id"
    )
    private User user;

    public Booking() {
    }

    public Booking(Date checkInDate, Date checkOutDate, Integer noOfAdult, String status, Double total) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.noOfAdult = noOfAdult;
        Status = status;
        this.total = total;
    }

    public Booking(Long id, Date checkInDate, Date checkOutDate, Integer noOfAdult, String status, Double total) {
        this.id = id;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.noOfAdult = noOfAdult;
        Status = status;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Integer getNoOfAdult() {
        return noOfAdult;
    }

    public void setNoOfAdult(Integer noOfAdult) {
        this.noOfAdult = noOfAdult;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<BookedPrice> getBookedPrices() {
        return bookedPrices;
    }

    public void setBookedPrices(List<BookedPrice> bookedPrices) {
        this.bookedPrices = bookedPrices;
    }

    public void addBookedPrice(BookedPrice bookedPrice){
        this.bookedPrices.add(bookedPrice);
    }

    public void removeBookedPrice(BookedPrice bookedPrice){
        this.bookedPrices.remove(bookedPrice);
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public void addPassenger(Passenger passenger){
        this.passengers.add(passenger);
    }

    public void removePassenger(Passenger passenger){
        this.passengers.remove(passenger);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
