package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.RoomTypeFacility;

import java.util.List;

public interface RoomTypeFacilityService {
    public List<RoomTypeFacility> getAllRoomTypeFacilities();

    public RoomTypeFacility getRoomTypeFacility(Long id);

    public RoomTypeFacility addRoomTypeFacility(RoomTypeFacility roomTypeFacility);

    public RoomTypeFacility updateRoomTypeFacility(Long id, RoomTypeFacility roomTypeFacility);

    public String deleteRoomTypeFacility(Long id);
}
