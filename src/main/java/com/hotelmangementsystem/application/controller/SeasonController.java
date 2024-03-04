package com.hotelmangementsystem.application.controller;

import com.hotelmangementsystem.application.entity.Season;
import com.hotelmangementsystem.application.service.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
