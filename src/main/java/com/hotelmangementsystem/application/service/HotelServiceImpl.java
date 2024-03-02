package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Hotel;
import com.hotelmangementsystem.application.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public ArrayList<Hotel> getAllHotels() {
        return (ArrayList<Hotel>) hotelRepository.findAll();
    }

    @Override
    public Hotel getHotel(Long id) {
        return hotelRepository.findById(id).get();
    }

    @Override
    public Hotel addHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel updateHotel(Long id, Hotel hotel) {
        Hotel hotelDB = hotelRepository.findById(id).get();
        hotelDB.setCountry(hotel.getCountry());
        return hotelRepository.save(hotelDB);
    }

    @Override
    public String deleteHotel(Long id) {
        hotelRepository.deleteById(id);
        return "deleted";
    }
}
