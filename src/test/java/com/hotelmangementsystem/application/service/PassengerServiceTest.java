package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Passenger;
import com.hotelmangementsystem.application.repository.PassengerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class PassengerServiceTest {

    @Autowired
    private PassengerService passengerService;

    @MockBean
    private PassengerRepository passengerRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getAllPassengers() {
        List<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger());
        passengers.add(new Passenger());

        when(passengerRepository.findAll()).thenReturn(passengers);

        // Test
        List<Passenger> result = passengerService.getAllPassengers();

        // Verify
        assertEquals(2, result.size());
    }

    @Test
    void getPassenger() {
        Passenger passenger = new Passenger();
        long id = 1L;

        when(passengerRepository.findById(id)).thenReturn(Optional.of(passenger));

        // Test
        Passenger result = passengerService.getPassenger(id);

        // Verify
        assertNotNull(result);
    }

    @Test
    void addPassenger() {
        Passenger passenger = new Passenger();

        when(passengerRepository.save(Mockito.any(Passenger.class))).thenReturn(passenger);

        // Test
        Passenger result = passengerService.addPassenger(passenger);

        // Verify
        assertNotNull(result);
    }

    @Test
    void updatePassenger() {
        long id = 1L;
        Passenger existingPassenger = new Passenger();
        existingPassenger.setId(id);
        existingPassenger.setName("Existing Passenger");

        Passenger updatedPassenger = new Passenger();
        updatedPassenger.setId(id);
        updatedPassenger.setName("Updated Passenger");

        when(passengerRepository.findById(id)).thenReturn(Optional.of(existingPassenger));
        when(passengerRepository.save(Mockito.any(Passenger.class))).thenReturn(updatedPassenger);

        // Test
        Passenger result = passengerService.updatePassenger(id, updatedPassenger);

        // Verify
        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals("Updated Passenger", result.getName());
    }

    @Test
    void deletePassenger() {
        long id = 1L;

        when(passengerRepository.existsById(id)).thenReturn(true);

        // Test
        String result = passengerService.deletePassenger(id);

        // Verify
        assertEquals("deleted", result);
    }
}