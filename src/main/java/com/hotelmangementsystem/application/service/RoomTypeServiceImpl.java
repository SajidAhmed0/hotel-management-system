package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Booking;
import com.hotelmangementsystem.application.entity.RoomType;
import com.hotelmangementsystem.application.entity.RoomTypeFacility;
import com.hotelmangementsystem.application.repository.BookingRepository;
import com.hotelmangementsystem.application.repository.RoomTypeFacilityRepository;
import com.hotelmangementsystem.application.repository.RoomTypeRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoomTypeServiceImpl implements RoomTypeService{

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RoomTypeFacilityRepository roomTypeFacilityRepository;

    @Override
    public List<RoomType> getAllRoomTypes() {
        return roomTypeRepository.findAll();
    }

    @Override
    public RoomType getRoomType(Long id) {
        return roomTypeRepository.findById(id).orElse(null);
    }

    @Override
    public RoomType addRoomType(RoomType roomType) {
        return roomTypeRepository.save(roomType);
    }

    @Override
    public RoomType updateRoomType(Long id, RoomType roomType) {
        RoomType roomTypeDB = roomTypeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("RoomType with id " + id + " does not exists"));

        if(roomType != null){
            roomTypeDB.setName(roomType.getName());
            roomTypeDB.setNoOfRooms(roomType.getNoOfRooms());
            roomTypeDB.setMaxAdult(roomType.getMaxAdult());
            roomTypeDB.setDescription(roomType.getDescription());
            return roomTypeRepository.save(roomTypeDB);
        }
        return null;

    }

    @Override
    public String deleteRoomType(Long id) {
        boolean exists = roomTypeRepository.existsById(id);
        if(!exists){
            throw new EntityNotFoundException("RoomType with id " + id + " does not exists");
        }
        roomTypeRepository.deleteById(id);
        return "deleted";
    }

    @Transactional
    @Override
    public RoomType addBookingToRoomType(Long roomtypeId, Long bookingId) {
        RoomType roomType = getRoomType(roomtypeId);
        Booking booking = bookingRepository.findById(bookingId).orElse(null);

        if(roomType != null && booking != null){
//            roomType.addBooking(booking);
            booking.setRoomType(roomType);
            return roomType;
        }

        return null;
    }

    @Transactional
    @Override
    public RoomType removeBookingFromRoomType(Long roomtypeId, Long bookingId) {
        RoomType roomType = getRoomType(roomtypeId);
        Booking booking = bookingRepository.findById(bookingId).orElse(null);

        if(roomType != null && booking != null){
//            roomType.removeBooking(booking);
            booking.setRoomType(null);
            return roomType;
        }

        return null;
    }

    @Override
    public List<Booking> getAllBookingsOfRoomType(Long id) {
        RoomType roomType = getRoomType(id);

        if(roomType != null){
            return roomType.getBookings();
        }
        return null;
    }

    @Transactional
    @Override
    public RoomType addRoomTypeFacilityToRoomType(Long roomtypeId, Long roomTypeFacilityId) {
        RoomType roomType = getRoomType(roomtypeId);
        RoomTypeFacility roomTypeFacility = roomTypeFacilityRepository.findById(roomTypeFacilityId).orElse(null);

        if(roomType != null && roomTypeFacility != null){
            roomTypeFacility.setRoomType(roomType);
            return roomType;
        }
        return null;
    }

    @Transactional
    @Override
    public RoomType removeRoomTypeFacilityFromRoomType(Long roomtypeId, Long roomTypeFacilityId) {
        RoomType roomType = getRoomType(roomtypeId);
        RoomTypeFacility roomTypeFacility = roomTypeFacilityRepository.findById(roomTypeFacilityId).orElse(null);

        if(roomType != null && roomTypeFacility != null){
            roomTypeFacility.setRoomType(null);
            return roomType;
        }
        return null;
    }

    @Override
    public List<RoomTypeFacility> getAllRoomTypeFacilitiesOfRoomType(Long id) {
        RoomType roomType = getRoomType(id);

        if(roomType != null){
            return roomType.getRoomTypeFacilities();
        }
        return null;
    }
}
