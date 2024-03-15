package com.hotelmangementsystem.application.service.pricing;

import com.hotelmangementsystem.application.entity.RoomType;
import com.hotelmangementsystem.application.entity.Season;
import com.hotelmangementsystem.application.entity.Supplement;
import com.hotelmangementsystem.application.entity.pricing.SeasonRoomTypePricing;
import com.hotelmangementsystem.application.entity.pricing.SeasonSupplementPricing;
import com.hotelmangementsystem.application.key.SeasonSupplementKey;

import java.util.List;

public interface SeasonSupplementPricingService {

    public SeasonSupplementPricing addSeasonSupplementPricing(Long seasonId, Long supplementId, Long contractId, Double price);

    public SeasonSupplementPricing updateSupplementPricing(Long seasonId, Long supplementId, Long contractId, Double price);

    public String deleteSeasonSupplementPricing(Long seasonId, Long supplementId, Long contractId);

    public List<Supplement> getAllSupplementsOfSeasonInContract(Long seasonId,  Long contractId);

    public List<Supplement> getAllSupplementsOfContract(Long contractId);

//    public List<Season> getAllSeasonsOfContract(Long contractId);

    public List<SeasonSupplementPricing> getAllSeasonSupplementPricingOfContract(Long contractId);
}
