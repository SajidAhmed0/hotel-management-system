package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Hotel;
import com.hotelmangementsystem.application.repository.HotelRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HotelServiceTest {

    @Autowired
    private HotelService hotelService;

    @MockBean
    private HotelRepository hotelRepository;

    @BeforeEach
    void setUp() {
        Hotel hotel =
    }

    @Test
    void getAllHotels() {
    }

    @Test
    void getHotel() {
    }

    @Test
    void addHotel() {
    }

    @Test
    void updateHotel() {
    }

    @Test
    void deleteHotel() {
    }

    @Test
    void addContractToHotel() {
    }

    @Test
    void removeContractFromHotel() {
    }

    @Test
    void getAllContractsOfHotel() {
    }

    @Test
    void addFacilityToHotel() {
    }

    @Test
    void removeFacilityFromHotel() {
    }

    @Test
    void getAllFacilitiesOfHotel() {
    }

    @Test
    void addImageToHotel() {
    }

    @Test
    void removeImageFromHotel() {
    }

    @Test
    void getAllImagesOfHotel() {
    }
}