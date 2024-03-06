package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Facility;
import com.hotelmangementsystem.application.repository.FacilityRepository;
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
class FacilityServiceTest {

    @Autowired
    private FacilityService facilityService;

    @MockBean
    private FacilityRepository facilityRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getAllFacilities() {
        List<Facility> facilities = new ArrayList<>();
        facilities.add(new Facility());
        facilities.add(new Facility());

        when(facilityRepository.findAll()).thenReturn(facilities);

        // Test
        List<Facility> result = facilityService.getAllFacilities();

        // Verify
        assertEquals(2, result.size());
    }

    @Test
    void getFacility() {
        Facility facility = new Facility();
        long id = 1L;

        when(facilityRepository.findById(id)).thenReturn(Optional.of(facility));

        // Test
        Facility result = facilityService.getFacility(id);

        // Verify
        assertNotNull(result);
    }

    @Test
    void addFacility() {
        Facility facility = new Facility();

        when(facilityRepository.save(Mockito.any(Facility.class))).thenReturn(facility);

        // Test
        Facility result = facilityService.addFacility(facility);

        // Verify
        assertNotNull(result);
    }

    @Test
    void updateFacility() {
        long id = 1L;
        Facility existingFacility = new Facility();
        existingFacility.setId(id);
        existingFacility.setName("Existing Facility");

        Facility updatedFacility = new Facility();
        updatedFacility.setId(id);
        updatedFacility.setName("Updated Facility");

        when(facilityRepository.findById(id)).thenReturn(Optional.of(existingFacility));
        when(facilityRepository.save(Mockito.any(Facility.class))).thenReturn(updatedFacility);

        // Test
        Facility result = facilityService.updateFacility(id, updatedFacility);

        // Verify
        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals("Updated Facility", result.getName());
    }

    @Test
    void deleteFacility() {
        long id = 1L;

        when(facilityRepository.existsById(id)).thenReturn(true);

        // Test
        String result = facilityService.deleteFacility(id);

        // Verify
        assertEquals("deleted", result);
    }
}