package com.hotelmangementsystem.application.service.pricing;

import com.hotelmangementsystem.application.entity.Contract;
import com.hotelmangementsystem.application.entity.RoomType;
import com.hotelmangementsystem.application.entity.Season;
import com.hotelmangementsystem.application.entity.Supplement;
import com.hotelmangementsystem.application.entity.pricing.SeasonRoomTypePricing;
import com.hotelmangementsystem.application.entity.pricing.SeasonSupplementPricing;
import com.hotelmangementsystem.application.key.SeasonRoomTypeKey;
import com.hotelmangementsystem.application.repository.ContractRepository;
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
import java.util.stream.Collectors;

@Service
public class SeasonRoomTypePricingServiceImpl implements SeasonRoomTypePricingService {

    @Autowired
    private SeasonRoomTypePricingRepository seasonRoomTypePricingRepository;

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private SeasonRepository seasonRepository;

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Transactional
    @Override
    public SeasonRoomTypePricing addSeasonRoomTypePricing(Long seasonId, Long roomtypeId, Long contractId, Double price, Integer noOfRooms) {
        Season season = seasonRepository.findById(seasonId).orElse(null);
        RoomType roomType = roomTypeRepository.findById(roomtypeId).orElse(null);
        Contract contract = contractRepository.findById(contractId).orElse(null);

        if(season != null && roomType != null && contract != null){
            SeasonRoomTypePricing seasonRoomTypePricing = new SeasonRoomTypePricing();
            seasonRoomTypePricing.setContract(contract);
            seasonRoomTypePricing.setSeason(season);
            seasonRoomTypePricing.setRoomType(roomType);
            seasonRoomTypePricing.setPrice(price);
            seasonRoomTypePricing.setNoOfRooms(noOfRooms);
            seasonRoomTypePricing.setId(new SeasonRoomTypeKey(seasonId, roomtypeId, contractId));

            return seasonRoomTypePricingRepository.save(seasonRoomTypePricing);
        }
        return null;
    }

    @Transactional
    @Override
    public SeasonRoomTypePricing updateRoomTypePricing(Long seasonId, Long roomtypeId, Long contractId, Double price, Integer noOfRooms) {
        SeasonRoomTypeKey key = new SeasonRoomTypeKey(seasonId, roomtypeId, contractId);
        SeasonRoomTypePricing seasonRoomTypePricing = seasonRoomTypePricingRepository.findById(key).orElse(null);

        if(seasonRoomTypePricing == null){
            throw new EntityNotFoundException("SeasonRoomTypePricing with id " + key + " does not exists");
        }
        seasonRoomTypePricing.setPrice(price);
        seasonRoomTypePricing.setNoOfRooms(noOfRooms);
        return seasonRoomTypePricing;
    }

    @Override
    public String deleteSeasonRoomTypePricing(Long seasonId, Long roomtypeId,  Long contractId) {
        SeasonRoomTypeKey key = new SeasonRoomTypeKey(seasonId, roomtypeId, contractId);
        boolean exists = seasonRoomTypePricingRepository.existsById(key);

        if(!exists){
            throw new EntityNotFoundException("SeasonRoomTypePricing with id " + key + " does not exists");
        }
        seasonRoomTypePricingRepository.deleteById(key);
        return "deleted";
    }

    @Override
    public List<RoomType> getAllRoomTypesOfSeasonInContract(Long seasonId, Long contractId) {
        Season season = seasonRepository.findById(seasonId).orElse(null);
        List<RoomType> roomTypes = new ArrayList<>();
        List<SeasonRoomTypePricing> pricing = season.getSeasonRoomTypePricings();

        pricing = pricing.stream().filter((price) -> {
            return price.getContract().getId() == contractId;
        }).collect(Collectors.toList());
        pricing.forEach((v) -> {
            roomTypes.add(v.getRoomType());
        });
        return roomTypes;
    }

    @Override
    public List<RoomType> getAllRoomTypesOfContract(Long contractId) {
        Contract contract = contractRepository.findById(contractId).orElse(null);
        List<RoomType> roomTypes = new ArrayList<>();

        List<SeasonRoomTypePricing> pricings = contract.getSeasonRoomTypePricings();

        pricings.forEach((v) -> {
            roomTypes.add(v.getRoomType());
        });
        return roomTypes;
    }

//    @Override
//    public List<Season> getAllSeasonsOfContract(Long contractId) {
//        Contract contract = contractRepository.findById(contractId).orElse(null);
//        List<Season> seasons = new ArrayList<>();
//
//        List<SeasonRoomTypePricing> pricing = contract.getSeasonRoomTypePricings();
//
//        pricing.forEach((v) -> {
//            seasons.add(v.getSeason());
//        });
//        return seasons;
//    }

    @Override
    public List<SeasonRoomTypePricing> getAllSeasonRoomTypePricingOfContract(Long contractId) {
        Contract contract = contractRepository.findById(contractId).orElse(null);

        List<SeasonRoomTypePricing> pricings = contract.getSeasonRoomTypePricings();

        return pricings;
    }
}
