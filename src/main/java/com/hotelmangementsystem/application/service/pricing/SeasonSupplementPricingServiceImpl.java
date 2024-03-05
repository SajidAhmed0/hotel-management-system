package com.hotelmangementsystem.application.service.pricing;

import com.hotelmangementsystem.application.entity.Season;
import com.hotelmangementsystem.application.entity.Supplement;
import com.hotelmangementsystem.application.entity.pricing.SeasonSupplementPricing;
import com.hotelmangementsystem.application.key.SeasonSupplementKey;
import com.hotelmangementsystem.application.repository.SeasonRepository;
import com.hotelmangementsystem.application.repository.SupplementRepository;
import com.hotelmangementsystem.application.repository.pricing.SeasonSupplementPricingRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeasonSupplementPricingServiceImpl implements SeasonSupplementPricingService{

    @Autowired
    private SeasonSupplementPricingRepository seasonSupplementPricingRepository;

    @Autowired
    private SeasonRepository seasonRepository;

    @Autowired
    private SupplementRepository supplementRepository;

    @Transactional
    @Override
    public SeasonSupplementPricing addSeasonSupplementPricing(Long seasonId, Long supplementId, Double price) {
        Season season = seasonRepository.findById(seasonId).orElse(null);
        Supplement supplement = supplementRepository.findById(supplementId).orElse(null);

        if(season != null && supplement != null){
            SeasonSupplementPricing seasonSupplementPricing = new SeasonSupplementPricing();
            seasonSupplementPricing.setSeason(season);
            seasonSupplementPricing.setSupplement(supplement);
            seasonSupplementPricing.setPrice(price);
            seasonSupplementPricing.setId(new SeasonSupplementKey(seasonId, supplementId));
            return seasonSupplementPricingRepository.save(seasonSupplementPricing);
        }
        return null;
    }

    @Transactional
    @Override
    public SeasonSupplementPricing updateSupplementPricing(Long seasonId, Long supplementId, Double price) {
        SeasonSupplementKey key = new SeasonSupplementKey(seasonId, supplementId);
        SeasonSupplementPricing seasonSupplementPricing = seasonSupplementPricingRepository.findById(key).orElse(null);

        if(seasonSupplementPricing == null){
            throw new EntityNotFoundException("SeasonSupplementPricing with id " + key + " does not exists");
        }
        seasonSupplementPricing.setPrice(price);
        return seasonSupplementPricing;
    }

    @Override
    public String deleteSeasonSupplementPricing(Long seasonId, Long supplementId) {
        SeasonSupplementKey key = new SeasonSupplementKey(seasonId, supplementId);
        boolean exists = seasonSupplementPricingRepository.existsById(key);

       if(!exists){
           throw new EntityNotFoundException("SeasonSupplementPricing with id " + key + " does not exists");
       }
        seasonSupplementPricingRepository.deleteById(key);
        return "deleted";
    }

    @Override
    public List<Supplement> getAllSupplementsOfSeason(Long seasonId) {
        Season season = seasonRepository.findById(seasonId).orElse(null);
        List<Supplement> supplements = new ArrayList<>();
        List<SeasonSupplementPricing> pricing = season.getSeasonSupplementPricings();
        pricing.forEach((v) -> {
            supplements.add(v.getSupplement());
        });
        return supplements;
    }
}
