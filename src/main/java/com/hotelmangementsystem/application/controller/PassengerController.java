package com.hotelmangementsystem.application.controller;

import com.hotelmangementsystem.application.entity.Passenger;
import com.hotelmangementsystem.application.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @GetMapping
    public List<Passenger> getAllPassengers(){
        return passengerService.getAllPassengers();
    }

    @GetMapping("/{id}")
    public Passenger getPassenger(@PathVariable("id") Long id) {
        return passengerService.getPassenger(id);
    }

    @PostMapping
    public Passenger addPassenger(@RequestBody Passenger passenger){
        return passengerService.addPassenger(passenger);
    }

    @PutMapping("/{id}")
    public Passenger updatePassenger(@PathVariable("id") Long id, @RequestBody Passenger passenger){
        return passengerService.updatePassenger(id, passenger);
    }

    @DeleteMapping("/{id}")
    public String deletePassenger(@PathVariable("id") Long id){
        return passengerService.deletePassenger(id);
    }
}
