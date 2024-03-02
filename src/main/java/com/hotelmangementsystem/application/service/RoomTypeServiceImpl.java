package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.RoomType;
import com.hotelmangementsystem.application.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RoomTypeServiceImpl implements RoomTypeService{

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Override
    public ArrayList<RoomType> getAllRoomTypes() {
        return (ArrayList<RoomType>) roomTypeRepository.findAll();
    }

    @Override
    public RoomType getRoomType(Long id) {
        return roomTypeRepository.findById(id).get();
    }

    @Override
    public RoomType addRoomType(RoomType roomType) {
        return roomTypeRepository.save(roomType);
    }

    @Override
    public RoomType updateRoomType(Long id, RoomType roomType) {
        RoomType roomTypeDB = roomTypeRepository.findById(id).get();
        roomTypeDB.setName(roomType.getName());
        return roomTypeRepository.save(roomTypeDB);
    }

    @Override
    public String deleteRoomType(Long id) {
        roomTypeRepository.deleteById(id);
        return "deleted";
    }
}
