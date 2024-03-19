package com.hotelmangementsystem.application.service.pricing;

import com.hotelmangementsystem.application.entity.RoomType;
import com.hotelmangementsystem.application.entity.Season;
import com.hotelmangementsystem.application.entity.Supplement;
import com.hotelmangementsystem.application.entity.pricing.SeasonRoomTypePricing;
import com.hotelmangementsystem.application.entity.pricing.SeasonSupplementPricing;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface SeasonRoomTypePricingService {
    public SeasonRoomTypePricing addSeasonRoomTypePricing(Long seasonId, Long roomtypeId, Long contractId, Double price, Integer noOfRooms);

    public SeasonRoomTypePricing updateRoomTypePricing(Long seasonId, Long roomtypeId, Long contractId, Double price, Integer noOfRooms);

    public String deleteSeasonRoomTypePricing(Long seasonId, Long roomtypeId,  Long contractId);

    public List<RoomType> getAllRoomTypesOfSeasonInContract(Long seasonId, Long contractId);

    public List<RoomType> getAllRoomTypesOfContract(Long contractId);

//    public List<Season> getAllSeasonsOfContract(Long contractId);

    public List<SeasonRoomTypePricing> getAllSeasonRoomTypePricingOfContract(Long contractId);
}
