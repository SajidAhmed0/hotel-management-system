package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.*;

import java.util.ArrayList;
import java.util.List;

public interface RoomTypeService {
    public List<RoomType> getAllRoomTypes();

    public RoomType getRoomType(Long id);

    public RoomType addRoomType(RoomType roomType);

    public RoomType updateRoomType(Long id, RoomType roomType);

    public String deleteRoomType(Long id);

    public RoomType addBookingToRoomType(Long roomtypeId, Long bookingId);

    public RoomType removeBookingFromRoomType(Long roomtypeId, Long bookingId);

    public List<Booking> getAllBookingsOfRoomType(Long id);

    public RoomType addRoomTypeFacilityToRoomType(Long roomtypeId, Long roomTypeFacilityId);

    public RoomType removeRoomTypeFacilityFromRoomType(Long roomtypeId, Long roomTypeFacilityId);

    public List<RoomTypeFacility> getAllRoomTypeFacilitiesOfRoomType(Long id);
}
