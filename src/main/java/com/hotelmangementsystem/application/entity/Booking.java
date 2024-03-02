package com.hotelmangementsystem.application.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Date;

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
}
