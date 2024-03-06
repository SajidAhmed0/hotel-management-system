package com.hotelmangementsystem.application.entity.search;

import java.sql.Date;

public class HotelSearch {

    private String location;
    private Date checkInDate;

    private Date checkOutDate;

    private Integer noOfAdults;

    private Integer noOfRooms;

    public HotelSearch() {
    }

    public HotelSearch(String location, Date checkInDate, Date chectOutDate, Integer noOfAdults, Integer noOfRooms) {
        this.location = location;
        this.checkInDate = checkInDate;
        this.checkOutDate = chectOutDate;
        this.noOfAdults = noOfAdults;
        this.noOfRooms = noOfRooms;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public Integer getNoOfAdults() {
        return noOfAdults;
    }

    public void setNoOfAdults(Integer noOfAdults) {
        this.noOfAdults = noOfAdults;
    }

    public Integer getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(Integer noOfRooms) {
        this.noOfRooms = noOfRooms;
    }
}
