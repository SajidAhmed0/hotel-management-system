package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Passenger;
import com.hotelmangementsystem.application.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PassengerServiceImpl implements PassengerService{

    @Autowired
    private PassengerRepository passengerRepository;

    @Override
    public ArrayList<Passenger> getAllPassengers() {
        return (ArrayList<Passenger>) passengerRepository.findAll();
    }

    @Override
    public Passenger getPassenger(Long id) {
        return passengerRepository.findById(id).get();
    }

    @Override
    public Passenger addPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    @Override
    public Passenger updatePassenger(Long id, Passenger passenger) {
        Passenger passengerDB = passengerRepository.findById(id).get();
        passengerDB.setName(passenger.getName());
        return passengerRepository.save(passengerDB);
    }

    @Override
    public String deletePassenger(Long id) {
        passengerRepository.deleteById(id);
        return "deleted";
    }
}
