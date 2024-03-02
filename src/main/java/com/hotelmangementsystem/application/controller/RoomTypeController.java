package com.hotelmangementsystem.application.controller;

import com.hotelmangementsystem.application.entity.RoomType;
import com.hotelmangementsystem.application.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/roomtypes")
public class RoomTypeController {

    @Autowired
    private RoomTypeService roomTypeService;

    @GetMapping
    public ArrayList<RoomType> getAllRoomTypes(){
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
}
