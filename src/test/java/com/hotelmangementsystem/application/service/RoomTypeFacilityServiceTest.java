package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.RoomTypeFacility;
import com.hotelmangementsystem.application.repository.RoomTypeFacilityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
class RoomTypeFacilityServiceTest {

    @Autowired
    private RoomTypeFacilityService roomTypeFacilityService;

    @MockBean
    private RoomTypeFacilityRepository roomTypeFacilityRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getAllRoomTypeFacilities() {
        List<RoomTypeFacility> roomTypeFacilities = new ArrayList<>();
        roomTypeFacilities.add(new RoomTypeFacility());
        roomTypeFacilities.add(new RoomTypeFacility());

        when(roomTypeFacilityRepository.findAll()).thenReturn(roomTypeFacilities);

        // Test
        List<RoomTypeFacility> result = roomTypeFacilityService.getAllRoomTypeFacilities();

        // Verify
        assertEquals(2, result.size());
    }

    @Test
    void getRoomTypeFacility() {
        RoomTypeFacility roomTypeFacility = new RoomTypeFacility();
        long id = 1L;

        when(roomTypeFacilityRepository.findById(id)).thenReturn(Optional.of(roomTypeFacility));

        // Test
        RoomTypeFacility result = roomTypeFacilityService.getRoomTypeFacility(id);

        // Verify
        assertNotNull(result);
    }

    @Test
    void addRoomTypeFacility() {
        RoomTypeFacility roomTypeFacility = new RoomTypeFacility();

        when(roomTypeFacilityRepository.save(Mockito.any(RoomTypeFacility.class))).thenReturn(roomTypeFacility);

        // Test
        RoomTypeFacility result = roomTypeFacilityService.addRoomTypeFacility(roomTypeFacility);

        // Verify
        assertNotNull(result);
    }

    @Test
    void updateRoomTypeFacility() {
        long id = 1L;
        RoomTypeFacility existingRoomTypeFacility = new RoomTypeFacility();
        existingRoomTypeFacility.setId(id);
        existingRoomTypeFacility.setName("Existing Facility");

        RoomTypeFacility updatedRoomTypeFacility = new RoomTypeFacility();
        updatedRoomTypeFacility.setId(id);
        updatedRoomTypeFacility.setName("Updated Facility");

        when(roomTypeFacilityRepository.findById(id)).thenReturn(Optional.of(existingRoomTypeFacility));
        when(roomTypeFacilityRepository.save(Mockito.any(RoomTypeFacility.class))).thenReturn(updatedRoomTypeFacility);

        // Test
        RoomTypeFacility result = roomTypeFacilityService.updateRoomTypeFacility(id, updatedRoomTypeFacility);

        // Verify
        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals("Updated Facility", result.getName());
    }

    @Test
    void deleteRoomTypeFacility() {
        long id = 1L;

        when(roomTypeFacilityRepository.existsById(id)).thenReturn(true);

        // Test
        String result = roomTypeFacilityService.deleteRoomTypeFacility(id);

        // Verify
        assertEquals("deleted", result);
    }
}