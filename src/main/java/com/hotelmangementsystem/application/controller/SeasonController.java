package com.hotelmangementsystem.application.controller;

import com.hotelmangementsystem.application.entity.RoomType;
import com.hotelmangementsystem.application.entity.Season;
import com.hotelmangementsystem.application.entity.Supplement;
import com.hotelmangementsystem.application.entity.pricing.SeasonRoomTypePricing;
import com.hotelmangementsystem.application.entity.pricing.SeasonSupplementPricing;
import com.hotelmangementsystem.application.service.SeasonService;
import com.hotelmangementsystem.application.service.pricing.SeasonRoomTypePricingService;
import com.hotelmangementsystem.application.service.pricing.SeasonSupplementPricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/seasons")
public class SeasonController {

    @Autowired
    private SeasonService seasonService;

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

}
