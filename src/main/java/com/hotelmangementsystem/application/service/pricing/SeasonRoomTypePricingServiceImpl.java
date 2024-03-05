package com.hotelmangementsystem.application.service.pricing;

import com.hotelmangementsystem.application.entity.RoomType;
import com.hotelmangementsystem.application.entity.Season;
import com.hotelmangementsystem.application.entity.Supplement;
import com.hotelmangementsystem.application.entity.pricing.SeasonRoomTypePricing;
import com.hotelmangementsystem.application.entity.pricing.SeasonSupplementPricing;
import com.hotelmangementsystem.application.key.SeasonRoomTypeKey;
import com.hotelmangementsystem.application.repository.RoomTypeRepository;
import com.hotelmangementsystem.application.repository.SeasonRepository;
import com.hotelmangementsystem.application.repository.SupplementRepository;
import com.hotelmangementsystem.application.repository.pricing.SeasonRoomTypePricingRepository;
import com.hotelmangementsystem.application.repository.pricing.SeasonSupplementPricingRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeasonRoomTypePricingServiceImpl implements SeasonRoomTypePricingService {

    @Autowired
    private SeasonRoomTypePricingRepository seasonRoomTypePricingRepository;

    @Autowired
    private SeasonRepository seasonRepository;

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Transactional
    @Override
    public SeasonRoomTypePricing addSeasonRoomTypePricing(Long seasonId, Long roomtypeId, Double price) {
        Season season = seasonRepository.findById(seasonId).orElse(null);
        RoomType roomType = roomTypeRepository.findById(roomtypeId).orElse(null);

        if(season != null && roomType != null){
            SeasonRoomTypePricing seasonRoomTypePricing = new SeasonRoomTypePricing();
            seasonRoomTypePricing.setSeason(season);
            seasonRoomTypePricing.setRoomType(roomType);
            seasonRoomTypePricing.setPrice(price);
            seasonRoomTypePricing.setId(new SeasonRoomTypeKey(seasonId, roomtypeId));

            return seasonRoomTypePricingRepository.save(seasonRoomTypePricing);
        }
        return null;
    }

    @Transactional
    @Override
    public SeasonRoomTypePricing updateRoomTypePricing(Long seasonId, Long roomtypeId, Double price) {
        SeasonRoomTypeKey key = new SeasonRoomTypeKey(seasonId, roomtypeId);
        SeasonRoomTypePricing seasonRoomTypePricing = seasonRoomTypePricingRepository.findById(key).orElse(null);

        if(seasonRoomTypePricing == null){
            throw new EntityNotFoundException("SeasonRoomTypePricing with id " + key + " does not exists");
        }
        seasonRoomTypePricing.setPrice(price);
        return seasonRoomTypePricing;
    }

    @Override
    public String deleteSeasonRoomTypePricing(Long seasonId, Long roomtypeId) {
        SeasonRoomTypeKey key = new SeasonRoomTypeKey(seasonId, roomtypeId);
        boolean exists = seasonRoomTypePricingRepository.existsById(key);

        if(!exists){
            throw new EntityNotFoundException("SeasonRoomTypePricing with id " + key + " does not exists");
        }
        seasonRoomTypePricingRepository.deleteById(key);
        return "deleted";
    }

    @Override
    public List<RoomType> getAllRoomTypesOfSeason(Long seasonId) {
        Season season = seasonRepository.findById(seasonId).orElse(null);
        List<RoomType> roomTypes = new ArrayList<>();
        List<SeasonRoomTypePricing> pricing = season.getSeasonRoomTypePricings();
        pricing.forEach((v) -> {
            roomTypes.add(v.getRoomType());
        });
        return roomTypes;
    }
}
