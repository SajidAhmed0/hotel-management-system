package com.hotelmangementsystem.application.controller;

import com.hotelmangementsystem.application.entity.Facility;
import com.hotelmangementsystem.application.entity.RoomTypeFacility;
import com.hotelmangementsystem.application.service.RoomTypeFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("roomtypefacilities")
public class RoomTypeFacilityController {

    @Autowired
    private RoomTypeFacilityService roomTypeFacilityService;

    @GetMapping
    public List<RoomTypeFacility> getAllRoomTypeFacilities(){
        return roomTypeFacilityService.getAllRoomTypeFacilities();
    }

    @GetMapping("/{id}")
    public RoomTypeFacility getRoomTypeFacility(@PathVariable("id") Long id) {
        return roomTypeFacilityService.getRoomTypeFacility(id);
    }

    @PostMapping
    public RoomTypeFacility addRoomTypeFacility(@RequestBody RoomTypeFacility roomTypeFacility){
        return roomTypeFacilityService.addRoomTypeFacility(roomTypeFacility);
    }

    @PutMapping("/{id}")
    public RoomTypeFacility updateRoomTypeFacility(@PathVariable("id") Long id, @RequestBody RoomTypeFacility roomTypeFacility){
        return roomTypeFacilityService.updateRoomTypeFacility(id, roomTypeFacility);
    }

    @DeleteMapping("/{id}")
    public String deleteRoomTypeFacility(@PathVariable("id") Long id){
        return roomTypeFacilityService.deleteRoomTypeFacility(id);
    }
}
