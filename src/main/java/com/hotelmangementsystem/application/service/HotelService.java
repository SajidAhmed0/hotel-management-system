package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Contract;
import com.hotelmangementsystem.application.entity.Hotel;

import java.util.ArrayList;
import java.util.List;

public interface HotelService {
    public List<Hotel> getAllHotels();

    public Hotel getHotel(Long id);

    public Hotel addHotel(Hotel hotel);

    public Hotel updateHotel(Long id, Hotel hotel);

    public String deleteHotel(Long id);

    public Hotel addContractToHotel(Long hotelId, Long contractId);

    public Hotel removeContractFromHotel(Long hotelId, Long contractId);

    public List<Contract> getAllContractsOfHotel(Long id);
}
