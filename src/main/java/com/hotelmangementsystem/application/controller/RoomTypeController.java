package com.hotelmangementsystem.application.controller;

import com.hotelmangementsystem.application.entity.Booking;
import com.hotelmangementsystem.application.entity.Passenger;
import com.hotelmangementsystem.application.entity.RoomType;
import com.hotelmangementsystem.application.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/roomtypes")
public class RoomTypeController {

    @Autowired
    private RoomTypeService roomTypeService;

    @GetMapping
    public List<RoomType> getAllRoomTypes(){
        return roomTypeService.getAllRoomTypes();
    }

    @GetMapping("/{id}")
    public RoomType getRoomType(@PathVariable("id") Long id) {
        return roomTypeService.getRoomType(id);
    }

    @PostMapping
    public RoomType addRoomType(@RequestBody RoomType roomType){
        return roomTypeService.addRoomType(roomType);
    }

    @PutMapping("/{id}")
    public RoomType updateRoomType(@PathVariable("id") Long id, @RequestBody RoomType roomType){
        return roomTypeService.updateRoomType(id, roomType);
    }

    @DeleteMapping("/{id}")
    public String deleteRoomType(@PathVariable("id") Long id){
        return roomTypeService.deleteRoomType(id);
    }

    @PutMapping("/{roomtypeId}/bookings/{bookingId}")
    public RoomType addBookingToRoomType(@PathVariable("roomtypeId") Long roomtypeId, @PathVariable("bookingId") Long bookingId){
        return roomTypeService.addBookingToRoomType(roomtypeId, bookingId);
    }
    @DeleteMapping("/{roomtypeId}/bookings/{bookingId}")
    public RoomType removeBookingFromRoomType(@PathVariable("roomtypeId") Long roomtypeId, @PathVariable("bookingId") Long bookingId){
        return roomTypeService.removeBookingFromRoomType(roomtypeId, bookingId);
    }

    @GetMapping("/{id}/bookings")
    public List<Booking> getAllBookingsOfRoomType(@PathVariable("id") Long id) {
        return roomTypeService.getAllBookingsOfRoomType(id);
    }
}
