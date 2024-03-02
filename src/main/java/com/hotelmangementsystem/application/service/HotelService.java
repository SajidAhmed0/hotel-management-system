package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Hotel;

import java.util.ArrayList;

public interface HotelService {
    public ArrayList<Hotel> getAllHotels();

    public Hotel getHotel(Long id);

    public Hotel addHotel(Hotel hotel);

    public Hotel updateHotel(Long id, Hotel hotel);

    public String deleteHotel(Long id);
}
