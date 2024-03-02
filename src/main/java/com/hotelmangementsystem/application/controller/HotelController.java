package com.hotelmangementsystem.application.controller;

import com.hotelmangementsystem.application.entity.Hotel;
import com.hotelmangementsystem.application.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping
    public ArrayList<Hotel> getAllHotels(){
        return hotelService.getAllHotels();
    }

    @GetMapping("/{hotelId}")
    public Hotel getHotel(@PathVariable("hotelId") Long hotelId) {
        return hotelService.getHotel(hotelId);
    }

    @PostMapping
    public Hotel addHotel(@RequestBody Hotel hotel){
        return hotelService.addHotel(hotel);
    }

    @PutMapping("/{hotelId}")
    public Hotel updateHotel(@PathVariable("hotelId") Long hotelId, @RequestBody Hotel hotel){
        return hotelService.updateHotel(hotelId, hotel);
    }

    @DeleteMapping("/{hotelId}")
    public String deleteHotel(@PathVariable("hotelId") Long hotelId){
        return hotelService.deleteHotel(hotelId);
    }
}
