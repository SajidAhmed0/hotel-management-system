package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Booking;
import com.hotelmangementsystem.application.entity.RoomType;

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
}
