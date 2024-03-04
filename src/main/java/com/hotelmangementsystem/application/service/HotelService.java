package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Hotel;

import java.util.ArrayList;
import java.util.List;

public interface HotelService {
    public List<Hotel> getAllHotels();

    public Hotel getHotel(Long id);

    public Hotel addHotel(Hotel hotel);

    public Hotel updateHotel(Long id, Hotel hotel);

    public String deleteHotel(Long id);
}
