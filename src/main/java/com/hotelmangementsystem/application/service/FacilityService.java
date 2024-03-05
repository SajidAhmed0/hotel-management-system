package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Discount;
import com.hotelmangementsystem.application.entity.Facility;

import java.util.List;

public interface FacilityService {
    public List<Facility> getAllFacilities();

    public Facility getFacility(Long id);

    public Facility addFacility(Facility facility);

    public Facility updateFacility(Long id, Facility facility);

    public String deleteFacility(Long id);
}
