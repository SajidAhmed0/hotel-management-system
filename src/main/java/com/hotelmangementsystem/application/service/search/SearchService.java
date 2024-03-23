package com.hotelmangementsystem.application.service.search;

import com.hotelmangementsystem.application.entity.Hotel;
import com.hotelmangementsystem.application.entity.search.DetailedHotelResult;
import com.hotelmangementsystem.application.entity.search.HotelSearch;
import com.hotelmangementsystem.application.entity.search.SummaryResult;

import java.util.List;

public interface SearchService {

    public List<Hotel> searchHotels(String search, HotelSearch hotelSearch);

    public List<SummaryResult> searchHotelsSummary(String search, HotelSearch hotelSearch);

    public DetailedHotelResult getHotelDetails(Long hotelId, HotelSearch hotelSearch);
}
