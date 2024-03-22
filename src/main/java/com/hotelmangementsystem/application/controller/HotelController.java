package com.hotelmangementsystem.application.controller;

import com.hotelmangementsystem.application.entity.*;
import com.hotelmangementsystem.application.service.HotelService;
import com.hotelmangementsystem.application.service.pricing.SeasonRoomTypePricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private SeasonRoomTypePricingService seasonRoomTypePricingService;

    @GetMapping
    public List<Hotel> getAllHotels(){
        return hotelService.getAllHotels();
    }

    @GetMapping("/{id}")
    public Hotel getHotel(@PathVariable("id") Long id) {
        return hotelService.getHotel(id);
    }

    @PostMapping
    public Hotel addHotel(@RequestBody Hotel hotel){
        return hotelService.addHotel(hotel);
    }

    @PutMapping("/{id}")
    public Hotel updateHotel(@PathVariable("id") Long id, @RequestBody Hotel hotel){
        return hotelService.updateHotel(id, hotel);
    }

    @DeleteMapping("/{id}")
    public String deleteHotel(@PathVariable("id") Long id){
        return hotelService.deleteHotel(id);
    }

    @PutMapping("/{hotelId}/contracts/{contractId}")
    public Hotel addContractFromHotel(@PathVariable("hotelId") Long hotelId, @PathVariable("contractId") Long contractId){
        return hotelService.addContractToHotel(hotelId, contractId);
    }

    @DeleteMapping("/{hotelId}/contracts/{contractId}")
    public Hotel removeContractFromHotel(@PathVariable("hotelId") Long hotelId, @PathVariable("contractId") Long contractId){
        return hotelService.removeContractFromHotel(hotelId, contractId);
    }

    @GetMapping("/{id}/contracts")
    public List<Contract> getAllContractsOfHotel(@PathVariable("id") Long id) {
        return hotelService.getAllContractsOfHotel(id);
    }

    @PutMapping("/{hotelId}/facilities/{facilityId}")
    public Hotel addFacilityToHotel(@PathVariable("hotelId") Long hotelId, @PathVariable("facilityId") Long facilityId){
        return hotelService.addFacilityToHotel(hotelId, facilityId);
    }

    @DeleteMapping("/{hotelId}/facilities/{facilityId}")
    public Hotel removeFacilityFromHotel(@PathVariable("hotelId") Long hotelId, @PathVariable("facilityId") Long facilityId){
        return hotelService.removeFacilityFromHotel(hotelId, facilityId);
    }

    @GetMapping("/{id}/facilities")
    public List<Facility> getAllFacilitiesOfHotel(@PathVariable("id") Long id) {
        return hotelService.getAllFacilitiesOfHotel(id);
    }

    @PutMapping("/{hotelId}/images/{imageId}")
    public Hotel addImageToHotel(@PathVariable("hotelId") Long hotelId, @PathVariable("imageId") Long imageId){
        return hotelService.addImageToHotel(hotelId, imageId);
    }

    @DeleteMapping("/{hotelId}/images/{imageId}")
    public Hotel removeImageFromHotel(@PathVariable("hotelId") Long hotelId, @PathVariable("imageId") Long imageId){
        return hotelService.removeImageFromHotel(hotelId, imageId);
    }

    @GetMapping("/{id}/images")
    public List<Image> getAllImagesOfHotel(@PathVariable("id") Long id) {
        return hotelService.getAllImagesOfHotel(id);
    }

    @PutMapping("/{hotelId}/roomtypes/{roomtypeId}")
    public Hotel addRoomTypeFromHotel(@PathVariable("hotelId") Long hotelId, @PathVariable("roomtypeId") Long roomtypeId){
        return hotelService.addRoomTypeToHotel(hotelId, roomtypeId);
    }

    @DeleteMapping("/{hotelId}/roomtypes/{roomtypeId}")
    public Hotel removeRoomTypeFromHotel(@PathVariable("hotelId") Long hotelId, @PathVariable("roomtypeId") Long roomtypeId){
        return hotelService.removeRoomTypeFromHotel(hotelId, roomtypeId);
    }

    @GetMapping("/{id}/roomtypes")
    public List<RoomType> getAllRoomTypesOfHotel(@PathVariable("id") Long id) {
        return hotelService.getAllRoomTypesOfHotel(id);
    }

    @PutMapping("/{hotelId}/supplements/{supplementId}")
    public Hotel addSupplementFromHotel(@PathVariable("hotelId") Long hotelId, @PathVariable("supplementId") Long supplementId){
        return hotelService.addSupplementToHotel(hotelId, supplementId);
    }

    @DeleteMapping("/{hotelId}/supplements/{supplementId}")
    public Hotel removeSupplementFromHotel(@PathVariable("hotelId") Long hotelId, @PathVariable("supplementId") Long supplementId){
        return hotelService.removeSupplementFromHotel(hotelId, supplementId);
    }

    @GetMapping("/{id}/supplements")
    public List<Supplement> getAllSupplementsOfHotel(@PathVariable("id") Long id) {
        return hotelService.getAllSupplementsOfHotel(id);
    }

    @GetMapping("/{id}/contracts/{contractId}/seasons/{seasonId}/roomtypes")
    public List<RoomType> getUnPricedRoomTypes(@PathVariable("id") Long id, @PathVariable("contractId") Long contractId, @PathVariable("seasonId") Long seasonId) {
        return seasonRoomTypePricingService.getUnPricedRoomTypes(id, contractId, seasonId);
    }
}
