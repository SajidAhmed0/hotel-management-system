package com.hotelmangementsystem.application.controller;

import com.hotelmangementsystem.application.entity.Season;
import com.hotelmangementsystem.application.entity.Supplement;
import com.hotelmangementsystem.application.entity.pricing.SeasonSupplementPricing;
import com.hotelmangementsystem.application.service.SeasonService;
import com.hotelmangementsystem.application.service.pricing.SeasonSupplementPricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/seasons")
public class SeasonController {

    @Autowired
    private SeasonService seasonService;

    @Autowired
    private SeasonSupplementPricingService seasonSupplementPricingService;

    @GetMapping
    public List<Season> getAllSeasons(){
        return seasonService.getAllSeasons();
    }

    @GetMapping("/{id}")
    public Season getSeason(@PathVariable("id") Long id) {
        return seasonService.getSeason(id);
    }

    @PostMapping
    public Season addSeason(@RequestBody Season season){
        return seasonService.addSeason(season);
    }

    @PutMapping("/{id}")
    public Season updateSeason(@PathVariable("id") Long id, @RequestBody Season season){
        return seasonService.updateSeason(id, season);
    }

    @DeleteMapping("/{id}")
    public String deleteSeason(@PathVariable("id") Long id){
        return seasonService.deleteSeason(id);
    }


    // FOR: pricing
    @PostMapping("/{seasonId}/supplements/{supplementId}")
    public SeasonSupplementPricing addSeasonSupplementPricing(@PathVariable("seasonId") Long seasonId, @PathVariable("supplementId") Long supplementId, @RequestBody SeasonSupplementPricing price){
        return seasonSupplementPricingService.addSeasonSupplementPricing(seasonId, supplementId, price.getPrice());
    }

    @PutMapping("/{seasonId}/supplements/{supplementId}")
    public SeasonSupplementPricing updateSeasonSupplementPricing(@PathVariable("seasonId") Long seasonId, @PathVariable("supplementId") Long supplementId, @RequestBody SeasonSupplementPricing price){
        return seasonSupplementPricingService.updateSupplementPricing(seasonId, supplementId, price.getPrice());
    }

    @DeleteMapping("/{seasonId}/supplements/{supplementId}")
    public String deleteSeasonSupplementPricing(@PathVariable("seasonId") Long seasonId, @PathVariable("supplementId") Long supplementId){
        return seasonSupplementPricingService.deleteSeasonSupplementPricing(seasonId, supplementId);
    }

    @GetMapping("/{seasonId}/supplements")
    public List<Supplement> getAllSupplementsOfSeason(@PathVariable("seasonId") Long id){
        return seasonSupplementPricingService.getAllSupplementsOfSeason(id);
    }
}
