package com.hotelmangementsystem.application.controller;

import com.hotelmangementsystem.application.entity.*;
import com.hotelmangementsystem.application.entity.pricing.SeasonRoomTypePricing;
import com.hotelmangementsystem.application.entity.pricing.SeasonSupplementPricing;
import com.hotelmangementsystem.application.service.ContractService;
import com.hotelmangementsystem.application.service.pricing.SeasonRoomTypePricingService;
import com.hotelmangementsystem.application.service.pricing.SeasonSupplementPricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/contracts")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @Autowired
    private SeasonRoomTypePricingService seasonRoomTypePricingService;

    @Autowired
    private SeasonSupplementPricingService seasonSupplementPricingService;

    @GetMapping
    public List<Contract> getAllContracts(){
        return contractService.getAllContracts();
    }

    @GetMapping("/{id}")
    public Contract getContract(@PathVariable("id") Long id) {
        return contractService.getContract(id);
    }

    @PostMapping
    public Contract addContract(@RequestBody Contract contract){
        return contractService.addContract(contract);
    }

    @PutMapping("/{id}")
    public Contract updateContract(@PathVariable("id") Long id, @RequestBody Contract contract){
        return contractService.updateContract(id, contract);
    }

//    @PutMapping("/{contractId}/hotels/{hotelId}")
//    public Hotel addContractFromHotel(@PathVariable("hotelId") Long hotelId, @PathVariable("contractId") Long contractId){
//        return contractService.addContractToHotel(contractId, hotelId);
//    }
//    @DeleteMapping("/{contractId}/hotels/{hotelId}")
//    public Hotel removeContractFromHotel(@PathVariable("hotelId") Long hotelId, @PathVariable("contractId") Long contractId){
//        return contractService.addContractToHotel(contractId, hotelId);
//    }


    @DeleteMapping("/{id}")
    public String deleteContract(@PathVariable("id") Long id){
        return contractService.deleteContract(id);
    }


//    @PutMapping("/{contractId}/supplements/{supplementId}")
//    public Contract addSupplementToContract(@PathVariable("contractId") Long contractId, @PathVariable("supplementId") Long supplementId){
//        return contractService.addSupplementToContract(contractId, supplementId);
//    }
//    @DeleteMapping("/{contractId}/supplements/{supplementId}")
//    public Contract removeSupplementFromContract(@PathVariable("contractId") Long contractId, @PathVariable("supplementId") Long supplementId){
//        return contractService.removeSupplementToContract(contractId, supplementId);
//    }

    @PutMapping("/{contractId}/seasons/{seasonId}")
    public Contract addSeasonToContract(@PathVariable("contractId") Long contractId, @PathVariable("seasonId") Long seasonId){
        return contractService.addSeasonToContract(contractId, seasonId);
    }
    @DeleteMapping("/{contractId}/seasons/{seasonId}")
    public Contract removeSeasonFromContract(@PathVariable("contractId") Long contractId, @PathVariable("seasonId") Long seasonId){
        return contractService.removeSeasonToContract(contractId, seasonId);
    }

//    @PutMapping("/{contractId}/roomtypes/{roomtypeId}")
//    public Contract addRoomTypeToContract(@PathVariable("contractId") Long contractId, @PathVariable("roomtypeId") Long roomtypeId){
//        return contractService.addRoomTypeToContract(contractId, roomtypeId);
//    }
//    @DeleteMapping("/{contractId}/roomtypes/{roomtypeId}")
//    public Contract removeRoomTypeFromContract(@PathVariable("contractId") Long contractId, @PathVariable("roomtypeId") Long roomtypeId){
//        return contractService.removeRoomTypeToContract(contractId, roomtypeId);
//    }

    @PutMapping("/{contractId}/discounts/{discountId}")
    public Contract addDiscountToContract(@PathVariable("contractId") Long contractId, @PathVariable("discountId") Long discountId){
        return contractService.addDiscountToContract(contractId, discountId);
    }
    @DeleteMapping("/{contractId}/discounts/{discountId}")
    public Contract removeDiscountFromContract(@PathVariable("contractId") Long contractId, @PathVariable("discountId") Long discountId){
        return contractService.removeDiscountToContract(contractId, discountId);
    }

//    @GetMapping("/{id}/supplements")
//    public List<Supplement> getAllSupplementsOfContract(@PathVariable("id") Long id) {
//        return contractService.getAllSupplementsOfContract(id);
//    }

    @GetMapping("/{id}/seasons")
    public List<Season> getAllSeasonsOfContract(@PathVariable("id") Long id) {
        return contractService.getAllSeasonsOfContract(id);
    }

//    @GetMapping("/{id}/roomtypes")
//    public List<RoomType> getAllRoomTypesOfContract(@PathVariable("id") Long id) {
//        return contractService.getAllRoomTypesOfContract(id);
//    }

    @GetMapping("/{id}/discounts")
    public List<Discount> getAllDisocuntsOfContract(@PathVariable("id") Long id) {
        return contractService.getAllDiscountsOfContract(id);
    }

    // FOR: pricing roomtype
    @PostMapping("/{contractId}/seasons/{seasonId}/roomtypes/{roomtypeId}")
    public SeasonRoomTypePricing addSeasonRoomTypePricing(@PathVariable("seasonId") Long seasonId, @PathVariable("roomtypeId") Long roomtypeId, @PathVariable("contractId") Long contractId, @RequestBody SeasonRoomTypePricing price){
        return seasonRoomTypePricingService.addSeasonRoomTypePricing(seasonId, roomtypeId, contractId, price.getPrice(), price.getNoOfRooms());
    }

    @PutMapping("/{contractId}/seasons/{seasonId}/roomtypes/{roomtypeId}")
    public SeasonRoomTypePricing updateSeasonRoomTypePricing(@PathVariable("seasonId") Long seasonId, @PathVariable("roomtypeId") Long roomtypeId, @PathVariable("contractId") Long contractId, @RequestBody SeasonRoomTypePricing price){
        return seasonRoomTypePricingService.updateRoomTypePricing(seasonId, roomtypeId, contractId, price.getPrice(), price.getNoOfRooms());
    }

    @DeleteMapping("/{contractId}/seasons/{seasonId}/roomtypes/{roomtypeId}")
    public String deleteSeasonRoomTypePricing(@PathVariable("seasonId") Long seasonId, @PathVariable("roomtypeId") Long roomtypeId, @PathVariable("contractId") Long contractId){
        return seasonRoomTypePricingService.deleteSeasonRoomTypePricing(seasonId, roomtypeId, contractId);
    }

    @GetMapping("/{contractId}/seasons/{seasonId}/roomtypes")
    public List<RoomType> getAllRoomTypesOfSeasonInContract(@PathVariable("seasonId") Long seasonId, @PathVariable("contractId") Long contractId){
        return seasonRoomTypePricingService.getAllRoomTypesOfSeasonInContract(seasonId, contractId);
    }

    @GetMapping("/{contractId}/roomtypes")
    public List<RoomType> getAllRoomTypesOfContract(@PathVariable("contractId") Long contractId){
        return seasonRoomTypePricingService.getAllRoomTypesOfContract(contractId);
    }

//    @GetMapping("/{contractId}/seasonpricings")
//    public List<Season> getAllSeasonsPricingsOfContract(@PathVariable("contractId") Long contractId){
//        return seasonRoomTypePricingService.getAllSeasonsOfContract(contractId);
//    }

    @GetMapping("/{contractId}/seasonroomtypepricings")
    public List<SeasonRoomTypePricing> getAllSeasonRoomTypePricingOfContract(@PathVariable("contractId") Long contractId){
        return seasonRoomTypePricingService.getAllSeasonRoomTypePricingOfContract(contractId);
    }

    @GetMapping("/{contractId}/seasons/{seasonId}/roomtypes/{roomtypeId}")
    public SeasonRoomTypePricing getAllSeasonsPricingsOfContract(@PathVariable("seasonId") Long seasonId, @PathVariable("roomtypeId") Long roomtypeId, @PathVariable("contractId") Long contractId){
        return seasonRoomTypePricingService.getRoomTypePricing(seasonId, roomtypeId, contractId);
    }

    // FOR: pricing supplement
    @PostMapping("/{contractId}/seasons/{seasonId}/supplements/{supplementId}")
    public SeasonSupplementPricing addSeasonSupplementPricing(@PathVariable("seasonId") Long seasonId, @PathVariable("supplementId") Long supplementId, @PathVariable("contractId") Long contractId, @RequestBody SeasonSupplementPricing price){
        return seasonSupplementPricingService.addSeasonSupplementPricing(seasonId, supplementId, contractId, price.getPrice());
    }

    @PutMapping("/{contractId}/seasons/{seasonId}/supplements/{supplementId}")
    public SeasonSupplementPricing updateSeasonSupplementPricing(@PathVariable("seasonId") Long seasonId, @PathVariable("supplementId") Long supplementId, @PathVariable("contractId") Long contractId, @RequestBody SeasonSupplementPricing price){
        return seasonSupplementPricingService.updateSupplementPricing(seasonId, supplementId, contractId, price.getPrice());
    }

    @DeleteMapping("/{contractId}/seasons/{seasonId}/supplements/{supplementId}")
    public String deleteSeasonSupplementPricing(@PathVariable("seasonId") Long seasonId, @PathVariable("supplementId") Long supplementId, @PathVariable("contractId") Long contractId){
        return seasonSupplementPricingService.deleteSeasonSupplementPricing(seasonId, supplementId, contractId);
    }

    @GetMapping("/{contractId}/seasons/{seasonId}/supplements")
    public List<Supplement> getAllSupplementsOfSeason(@PathVariable("seasonId") Long seasonId, @PathVariable("contractId") Long contractId){
        return seasonSupplementPricingService.getAllSupplementsOfSeasonInContract(seasonId, contractId);
    }

    @GetMapping("/{contractId}/supplements")
    public List<Supplement> getAllSupplementsOfContract(@PathVariable("contractId") Long contractId){
        return seasonSupplementPricingService.getAllSupplementsOfContract(contractId);
    }

    @GetMapping("/{contractId}/seasonsupplementpricings")
    public List<SeasonSupplementPricing> getAllSeasonSupplementPricingOfContract(@PathVariable("contractId") Long contractId){
        return seasonSupplementPricingService.getAllSeasonSupplementPricingOfContract(contractId);
    }
}











