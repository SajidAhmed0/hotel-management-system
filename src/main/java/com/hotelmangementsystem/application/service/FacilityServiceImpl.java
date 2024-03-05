package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Discount;
import com.hotelmangementsystem.application.entity.Facility;
import com.hotelmangementsystem.application.repository.FacilityRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityServiceImpl implements FacilityService{

    @Autowired
    private FacilityRepository facilityRepository;

    @Override
    public List<Facility> getAllFacilities() {
        return facilityRepository.findAll();
    }

    @Override
    public Facility getFacility(Long id) {
        return facilityRepository.findById(id).orElse(null);
    }

    @Override
    public Facility addFacility(Facility facility) {
        return facilityRepository.save(facility);
    }

    @Override
    public Facility updateFacility(Long id, Facility facility) {
        Facility facilityDB = facilityRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Facility with id " + id + " does not exists"));

        if(facility != null){
            facilityDB.setName(facility.getName());
            facilityDB.setDescription(facility.getDescription());
            return facilityRepository.save(facilityDB);
        }
        return null;
    }

    @Override
    public String deleteFacility(Long id) {
        boolean exists = facilityRepository.existsById(id);
        if(!exists) {
            throw new EntityNotFoundException("Facility with id " + id + " does not exists");
        }
        facilityRepository.deleteById(id);
        return "deleted";
    }
}
