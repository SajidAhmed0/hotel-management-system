package com.hotelmangementsystem.application.controller;

import com.hotelmangementsystem.application.entity.Hotel;
import com.hotelmangementsystem.application.entity.search.HotelSearch;
import com.hotelmangementsystem.application.service.search.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("searches")
public class SearchController {

    @Autowired
    private SearchService searchService;
    @PostMapping
    public List<Hotel> searchHotels(@RequestParam("search") String search, @RequestBody HotelSearch hotelSearch){
        return searchService.searchHotels(search, hotelSearch);
    }
}
