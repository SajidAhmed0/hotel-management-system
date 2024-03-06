package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Booking;
import com.hotelmangementsystem.application.entity.RoomType;
import com.hotelmangementsystem.application.entity.RoomTypeFacility;
import com.hotelmangementsystem.application.repository.BookingRepository;
import com.hotelmangementsystem.application.repository.RoomTypeFacilityRepository;
import com.hotelmangementsystem.application.repository.RoomTypeRepository;
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
class RoomTypeServiceTest {

    @Autowired
    private RoomTypeService roomTypeService;

    @MockBean
    private RoomTypeRepository roomTypeRepository;

    @MockBean
    private BookingRepository bookingRepository;

    @MockBean
    private RoomTypeFacilityRepository roomTypeFacilityRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getAllRoomTypes() {
        List<RoomType> roomTypes = new ArrayList<>();
        roomTypes.add(new RoomType());
        roomTypes.add(new RoomType());

        when(roomTypeRepository.findAll()).thenReturn(roomTypes);

        // Test
        List<RoomType> result = roomTypeService.getAllRoomTypes();

        // Verify
        assertEquals(2, result.size());
    }

    @Test
    void getRoomType() {
        RoomType roomType = new RoomType();
        long id = 1L;

        when(roomTypeRepository.findById(id)).thenReturn(Optional.of(roomType));

        // Test
        RoomType result = roomTypeService.getRoomType(id);

        // Verify
        assertNotNull(result);
    }

    @Test
    void addRoomType() {
        RoomType roomType = new RoomType();

        when(roomTypeRepository.save(Mockito.any(RoomType.class))).thenReturn(roomType);

        // Test
        RoomType result = roomTypeService.addRoomType(roomType);

        // Verify
        assertNotNull(result);
    }

    @Test
    void updateRoomType() {
        long id = 1L;
        RoomType existingRoomType = new RoomType();
        existingRoomType.setId(id);
        existingRoomType.setName("Existing Room Type");

        RoomType updatedRoomType = new RoomType();
        updatedRoomType.setId(id);
        updatedRoomType.setName("Updated Room Type");

        when(roomTypeRepository.findById(id)).thenReturn(Optional.of(existingRoomType));
        when(roomTypeRepository.save(Mockito.any(RoomType.class))).thenReturn(updatedRoomType);

        // Test
        RoomType result = roomTypeService.updateRoomType(id, updatedRoomType);

        // Verify
        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals("Updated Room Type", result.getName());
    }

    @Test
    void deleteRoomType() {
        long id = 1L;

        when(roomTypeRepository.existsById(id)).thenReturn(true);

        // Test
        String result = roomTypeService.deleteRoomType(id);

        // Verify
        assertEquals("deleted", result);
    }

    @Test
    void addBookingToRoomType() {
        long roomTypeId = 1L;
        long bookingId = 1L;
        RoomType roomType = new RoomType();
        Booking booking = new Booking();

        when(roomTypeRepository.findById(roomTypeId)).thenReturn(Optional.of(roomType));
        when(bookingRepository.findById(bookingId)).thenReturn(Optional.of(booking));

        // Test
        RoomType result = roomTypeService.addBookingToRoomType(roomTypeId, bookingId);

        // Verify
        assertNotNull(result);
        assertEquals(roomType, booking.getRoomType());
    }

    @Test
    void removeBookingFromRoomType() {
        long roomTypeId = 1L;
        long bookingId = 1L;
        RoomType roomType = new RoomType();
        Booking booking = new Booking();
        booking.setRoomType(roomType);

        when(roomTypeRepository.findById(roomTypeId)).thenReturn(Optional.of(roomType));
        when(bookingRepository.findById(bookingId)).thenReturn(Optional.of(booking));

        // Test
        RoomType result = roomTypeService.removeBookingFromRoomType(roomTypeId, bookingId);

        // Verify
        assertNotNull(result);
        assertNull(booking.getRoomType());
    }

    @Test
    void getAllBookingsOfRoomType() {
        long roomTypeId = 1L;
        RoomType roomType = new RoomType();
        List<Booking> bookings = new ArrayList<>();
        bookings.add(new Booking());
        bookings.add(new Booking());

        roomType.setBookings(bookings);

        when(roomTypeRepository.findById(roomTypeId)).thenReturn(Optional.of(roomType));

        // Test
        List<Booking> result = roomTypeService.getAllBookingsOfRoomType(roomTypeId);

        // Verify
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    void addRoomTypeFacilityToRoomType() {
        long roomTypeId = 1L;
        long roomTypeFacilityId = 1L;
        RoomType roomType = new RoomType();
        RoomTypeFacility roomTypeFacility = new RoomTypeFacility();

        when(roomTypeRepository.findById(roomTypeId)).thenReturn(Optional.of(roomType));
        when(roomTypeFacilityRepository.findById(roomTypeFacilityId)).thenReturn(Optional.of(roomTypeFacility));

        // Test
        RoomType result = roomTypeService.addRoomTypeFacilityToRoomType(roomTypeId, roomTypeFacilityId);

        // Verify
        assertNotNull(result);
//        assertTrue(result.getRoomTypeFacilities().contains(roomTypeFacility));
        assertTrue(roomTypeFacility.getRoomType() == result);
    }

    @Test
    void removeRoomTypeFacilityFromRoomType() {
        long roomTypeId = 1L;
        long roomTypeFacilityId = 1L;
        RoomType roomType = new RoomType();
        RoomTypeFacility roomTypeFacility = new RoomTypeFacility();
        roomType.getRoomTypeFacilities().add(roomTypeFacility);

        when(roomTypeRepository.findById(roomTypeId)).thenReturn(Optional.of(roomType));
        when(roomTypeFacilityRepository.findById(roomTypeFacilityId)).thenReturn(Optional.of(roomTypeFacility));

        // Test
        RoomType result = roomTypeService.removeRoomTypeFacilityFromRoomType(roomTypeId, roomTypeFacilityId);

        // Verify
        assertNotNull(result);
//        assertFalse(result.getRoomTypeFacilities().contains(roomTypeFacility));
        assertTrue(roomTypeFacility.getRoomType() == null);
    }

    @Test
    void getAllRoomTypeFacilitiesOfRoomType() {
        long roomTypeId = 1L;
        RoomType roomType = new RoomType();
        List<RoomTypeFacility> roomTypeFacilities = new ArrayList<>();
        roomTypeFacilities.add(new RoomTypeFacility());
        roomTypeFacilities.add(new RoomTypeFacility());

        roomType.setRoomTypeFacilities(roomTypeFacilities);

        when(roomTypeRepository.findById(roomTypeId)).thenReturn(Optional.of(roomType));

        // Test
        List<RoomTypeFacility> result = roomTypeService.getAllRoomTypeFacilitiesOfRoomType(roomTypeId);

        // Verify
        assertNotNull(result);
        assertEquals(2, result.size());
    }
}