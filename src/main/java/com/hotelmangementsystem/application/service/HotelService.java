package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.*;

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

    public Hotel addFacilityToHotel(Long hotelId, Long facilityId);

    public Hotel removeFacilityFromHotel(Long hotelId, Long facilityId);

    public List<Facility> getAllFacilitiesOfHotel(Long id);

    public Hotel addImageToHotel(Long hotelId, Long imageId);

    public Hotel removeImageFromHotel(Long hotelId, Long imageId);

    public List<Image> getAllImagesOfHotel(Long id);

    public Hotel addRoomTypeToHotel(Long hotelId, Long roomTypeId);

    public Hotel removeRoomTypeFromHotel(Long hotelId, Long roomTypeId);

    public List<RoomType> getAllRoomTypesOfHotel(Long id);

    public Hotel addSupplementToHotel(Long hotelId, Long supplementId);

    public Hotel removeSupplementFromHotel(Long hotelId, Long supplementId);

    public List<Supplement> getAllSupplementsOfHotel(Long id);
}
