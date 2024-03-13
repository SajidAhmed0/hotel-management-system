package com.hotelmangementsystem.application.controller;

import com.hotelmangementsystem.application.entity.Discount;
import com.hotelmangementsystem.application.entity.Facility;
import com.hotelmangementsystem.application.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/facilities")
public class FacilityController {

    @Autowired
    private FacilityService facilityService;

    @GetMapping
    public List<Facility> getAllFacilities(){
        return facilityService.getAllFacilities();
    }

    @GetMapping("/{id}")
    public Facility getFacility(@PathVariable("id") Long id) {
        return facilityService.getFacility(id);
    }

    @PostMapping
    public Facility addFacility(@RequestBody Facility facility){
        return facilityService.addFacility(facility);
    }

    @PutMapping("/{id}")
    public Facility updateFacility(@PathVariable("id") Long id, @RequestBody Facility facility){
        return facilityService.updateFacility(id, facility);
    }

    @DeleteMapping("/{id}")
    public String deleteFacility(@PathVariable("id") Long id){
        return facilityService.deleteFacility(id);
    }

}
