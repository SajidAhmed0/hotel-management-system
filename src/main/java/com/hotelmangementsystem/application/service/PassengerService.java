package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Passenger;

import java.util.ArrayList;

public interface PassengerService {
    public ArrayList<Passenger> getAllPassengers();

    public Passenger getPassenger(Long id);

    public Passenger addPassenger(Passenger passenger);

    public Passenger updatePassenger(Long id, Passenger passenger);

    public String deletePassenger(Long id);
}
