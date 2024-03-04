package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Passenger;
import com.hotelmangementsystem.application.repository.PassengerRepository;
import jakarta.persistence.EntityNotFoundException;
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
        return passengerRepository.findById(id).orElse(null);
    }

    @Override
    public Passenger addPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    @Override
    public Passenger updatePassenger(Long id, Passenger passenger) {
        Passenger passengerDB = passengerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Passenger with id " + id + " does not exists"));

        if(passenger != null){
            passengerDB.setPhone(passenger.getPhone());
            passengerDB.setName(passenger.getName());
            return passengerRepository.save(passengerDB);
        }
        return null;

    }

    @Override
    public String deletePassenger(Long id) {
        boolean exists = passengerRepository.existsById(id);
        if(!exists){
            throw new EntityNotFoundException("Passenger with id " + id + " does not exists");
        }
        passengerRepository.deleteById(id);
        return "deleted";
    }
}
