package com.hotelmangementsystem.application.service.pricing;

import com.hotelmangementsystem.application.entity.RoomType;
import com.hotelmangementsystem.application.entity.Supplement;
import com.hotelmangementsystem.application.entity.pricing.SeasonRoomTypePricing;
import com.hotelmangementsystem.application.entity.pricing.SeasonSupplementPricing;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface SeasonRoomTypePricingService {
    public SeasonRoomTypePricing addSeasonRoomTypePricing(Long seasonId, Long roomtypeId, Double price);

    public SeasonRoomTypePricing updateRoomTypePricing(Long seasonId, Long roomtypeId, Double price);

    public String deleteSeasonRoomTypePricing(Long seasonId, Long roomtypeId);

    public List<RoomType> getAllRoomTypesOfSeason(Long seasonId);
}
