package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Facility;
import com.hotelmangementsystem.application.entity.RoomTypeFacility;
import com.hotelmangementsystem.application.repository.RoomTypeFacilityRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomTypeFacilityServiceImpl implements RoomTypeFacilityService {

    @Autowired
    private RoomTypeFacilityRepository roomTypeFacilityRepository;

    @Override
    public List<RoomTypeFacility> getAllRoomTypeFacilities() {
        return roomTypeFacilityRepository.findAll();
    }

    @Override
    public RoomTypeFacility getRoomTypeFacility(Long id) {
        return roomTypeFacilityRepository.findById(id).orElse(null);
    }

    @Override
    public RoomTypeFacility addRoomTypeFacility(RoomTypeFacility roomTypeFacility) {
        return roomTypeFacilityRepository.save(roomTypeFacility);
    }


    @Override
    public RoomTypeFacility updateRoomTypeFacility(Long id, RoomTypeFacility roomTypeFacility) {
        RoomTypeFacility roomTypeFacilityDB = roomTypeFacilityRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("RoomTypeFacility with id " + id + " does not exists"));

        if(roomTypeFacility != null){
            roomTypeFacilityDB.setName(roomTypeFacility.getName());
            roomTypeFacilityDB.setDescription(roomTypeFacility.getDescription());
            return roomTypeFacilityRepository.save(roomTypeFacilityDB);
        }
        return null;
    }

    @Override
    public String deleteRoomTypeFacility(Long id) {
        boolean exists = roomTypeFacilityRepository.existsById(id);
        if(!exists) {
            throw new EntityNotFoundException("RoomTypeFacility with id " + id + " does not exists");
        }
        roomTypeFacilityRepository.deleteById(id);
        return "deleted";
    }
}
