package com.hotelmangementsystem.application.controller;

import com.hotelmangementsystem.application.entity.Hotel;
import com.hotelmangementsystem.application.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping
    public ArrayList<Hotel> getAllHotels(){
        return hotelService.getAllHotels();
    }

    @GetMapping("/{id}")
    public Hotel getHotel(@PathVariable("id") Long id) {
        return hotelService.getHotel(id);
    }

    @PostMapping
    public Hotel addHotel(@RequestBody Hotel hotel){
        return hotelService.addHotel(hotel);
    }

    @PutMapping("/{id}")
    public Hotel updateHotel(@PathVariable("id") Long id, @RequestBody Hotel hotel){
        return hotelService.updateHotel(id, hotel);
    }

    @DeleteMapping("/{id}")
    public String deleteHotel(@PathVariable("id") Long id){
        return hotelService.deleteHotel(id);
    }
}
