package com.hotelmangementsystem.application.service.pricing;

import com.hotelmangementsystem.application.entity.Supplement;
import com.hotelmangementsystem.application.entity.pricing.SeasonSupplementPricing;
import com.hotelmangementsystem.application.key.SeasonSupplementKey;

import java.util.List;

public interface SeasonSupplementPricingService {

    public SeasonSupplementPricing addSeasonSupplementPricing(Long seasonId, Long supplementId, Double price);

    public SeasonSupplementPricing updateSupplementPricing(Long seasonId, Long supplementId, Double price);

    public String deleteSeasonSupplementPricing(Long seasonId, Long supplementId);

    public List<Supplement> getAllSupplementsOfSeason(Long seasonId);
}
