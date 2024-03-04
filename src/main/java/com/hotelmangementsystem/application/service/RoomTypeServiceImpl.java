package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.RoomType;
import com.hotelmangementsystem.application.repository.RoomTypeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomTypeServiceImpl implements RoomTypeService{

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Override
    public List<RoomType> getAllRoomTypes() {
        return roomTypeRepository.findAll();
    }

    @Override
    public RoomType getRoomType(Long id) {
        return roomTypeRepository.findById(id).orElse(null);
    }

    @Override
    public RoomType addRoomType(RoomType roomType) {
        return roomTypeRepository.save(roomType);
    }

    @Override
    public RoomType updateRoomType(Long id, RoomType roomType) {
        RoomType roomTypeDB = roomTypeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("RoomType with id " + id + " does not exists"));

        if(roomType != null){
            roomTypeDB.setName(roomType.getName());
            roomTypeDB.setNoOfRooms(roomType.getNoOfRooms());
            roomTypeDB.setMaxAdult(roomType.getMaxAdult());
            roomTypeDB.setDescription(roomType.getDescription());
            roomTypeDB.setFacilities(roomType.getFacilities());
            roomTypeDB.setPrice(roomType.getPrice());
            return roomTypeRepository.save(roomTypeDB);
        }
        return null;

    }

    @Override
    public String deleteRoomType(Long id) {
        boolean exists = roomTypeRepository.existsById(id);
        if(!exists){
            throw new EntityNotFoundException("RoomType with id " + id + " does not exists");
        }
        roomTypeRepository.deleteById(id);
        return "deleted";
    }
}
