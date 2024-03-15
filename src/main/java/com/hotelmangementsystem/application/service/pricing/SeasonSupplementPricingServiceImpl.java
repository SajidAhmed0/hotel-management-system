package com.hotelmangementsystem.application.service.pricing;

import com.hotelmangementsystem.application.entity.Contract;
import com.hotelmangementsystem.application.entity.Season;
import com.hotelmangementsystem.application.entity.Supplement;
import com.hotelmangementsystem.application.entity.pricing.SeasonSupplementPricing;
import com.hotelmangementsystem.application.key.SeasonSupplementKey;
import com.hotelmangementsystem.application.repository.ContractRepository;
import com.hotelmangementsystem.application.repository.SeasonRepository;
import com.hotelmangementsystem.application.repository.SupplementRepository;
import com.hotelmangementsystem.application.repository.pricing.SeasonSupplementPricingRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeasonSupplementPricingServiceImpl implements SeasonSupplementPricingService{

    @Autowired
    private SeasonSupplementPricingRepository seasonSupplementPricingRepository;

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private SeasonRepository seasonRepository;

    @Autowired
    private SupplementRepository supplementRepository;

    @Transactional
    @Override
    public SeasonSupplementPricing addSeasonSupplementPricing(Long seasonId, Long supplementId, Long contractId, Double price) {
        Season season = seasonRepository.findById(seasonId).orElse(null);
        Supplement supplement = supplementRepository.findById(supplementId).orElse(null);
        Contract contract = contractRepository.findById(contractId).orElse(null);

        if(season != null && supplement != null && contract != null){
            SeasonSupplementPricing seasonSupplementPricing = new SeasonSupplementPricing();
            seasonSupplementPricing.setSeason(season);
            seasonSupplementPricing.setSupplement(supplement);
            seasonSupplementPricing.setContract(contract);
            seasonSupplementPricing.setPrice(price);
            seasonSupplementPricing.setId(new SeasonSupplementKey(seasonId, supplementId, contractId));
            return seasonSupplementPricingRepository.save(seasonSupplementPricing);
        }
        return null;
    }

    @Transactional
    @Override
    public SeasonSupplementPricing updateSupplementPricing(Long seasonId, Long supplementId, Long contractId, Double price) {
        SeasonSupplementKey key = new SeasonSupplementKey(seasonId, supplementId, contractId);
        SeasonSupplementPricing seasonSupplementPricing = seasonSupplementPricingRepository.findById(key).orElse(null);

        if(seasonSupplementPricing == null){
            throw new EntityNotFoundException("SeasonSupplementPricing with id " + key + " does not exists");
        }
        seasonSupplementPricing.setPrice(price);
        return seasonSupplementPricing;
    }

    @Override
    public String deleteSeasonSupplementPricing(Long seasonId, Long supplementId, Long contractId) {
        SeasonSupplementKey key = new SeasonSupplementKey(seasonId, supplementId, contractId);
        boolean exists = seasonSupplementPricingRepository.existsById(key);

       if(!exists){
           throw new EntityNotFoundException("SeasonSupplementPricing with id " + key + " does not exists");
       }
        seasonSupplementPricingRepository.deleteById(key);
        return "deleted";
    }

    @Override
    public List<Supplement> getAllSupplementsOfSeasonInContract(Long seasonId, Long contractId) {
        Season season = seasonRepository.findById(seasonId).orElse(null);
        List<Supplement> supplements = new ArrayList<>();
        List<SeasonSupplementPricing> pricing = season.getSeasonSupplementPricings();

        pricing = pricing.stream().filter((price) -> {
            return price.getContract().getId() == contractId;
        }).collect(Collectors.toList());

        pricing.forEach((v) -> {
            supplements.add(v.getSupplement());
        });
        return supplements;
    }

    @Override
    public List<Supplement> getAllSupplementsOfContract(Long contractId) {
        Contract contract = contractRepository.findById(contractId).orElse(null);
        List<Supplement> supplements = new ArrayList<>();

        List<SeasonSupplementPricing> pricings = contract.getSeasonSupplementPricings();

        pricings.forEach((v) -> {
            supplements.add(v.getSupplement());
        });
        return supplements;
    }

    @Override
    public List<SeasonSupplementPricing> getAllSeasonSupplementPricingOfContract(Long contractId) {
        Contract contract = contractRepository.findById(contractId).orElse(null);
        List<SeasonSupplementPricing> pricings = contract.getSeasonSupplementPricings();
        return pricings;
    }
}
