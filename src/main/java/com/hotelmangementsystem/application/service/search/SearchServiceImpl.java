package com.hotelmangementsystem.application.service.search;

import com.hotelmangementsystem.application.entity.*;
import com.hotelmangementsystem.application.entity.pricing.SeasonRoomTypePricing;
import com.hotelmangementsystem.application.entity.pricing.SeasonSupplementPricing;
import com.hotelmangementsystem.application.entity.search.*;
import com.hotelmangementsystem.application.repository.HotelRepository;
import com.hotelmangementsystem.application.service.ContractService;
import com.hotelmangementsystem.application.service.RoomTypeService;
import com.hotelmangementsystem.application.service.pricing.SeasonRoomTypePricingService;
import com.hotelmangementsystem.application.service.pricing.SeasonSupplementPricingService;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private ContractService contractService;

    @Autowired
    private RoomTypeService roomTypeService;

    @Autowired
    private SeasonRoomTypePricingService seasonRoomTypePricingService;

    @Autowired
    private SeasonSupplementPricingService seasonSupplementPricingService;

    private static final Logger logger = LoggerFactory.getLogger(com.hotelmangementsystem.application.entity.Logger.class);

    @Override
    public List<Hotel> searchHotels(String search, HotelSearch hotelSearch) {

        List<Hotel> hotels = new ArrayList<>();

        AtomicInteger totalAmountOfGuest = new AtomicInteger();
        AtomicInteger totalRoomsAvailable = new AtomicInteger();

        Date checkInDate = hotelSearch.getCheckInDate();
        Date checkOutDate = hotelSearch.getCheckOutDate();
        String location = hotelSearch.getLocation();
        Integer noOfRooms = hotelSearch.getNoOfRooms();
        Integer noOfAdults = hotelSearch.getNoOfAdults();

        AtomicBoolean available = new AtomicBoolean(false);

        if(search.equalsIgnoreCase("hotel")){
            hotels = hotelRepository.findAll();
            logger.info("one");
            if(hotelSearch != null){
                logger.info("two");
                    logger.info("three");
                    hotels = hotels.stream().filter((hotel) -> {
                        logger.info("four");
                        List<Contract> contracts = hotel.getContracts();
                        for(Contract contract : contracts){
                            logger.info("five");
                            available.set(false);
                            if(contract.getStartDate().before(checkInDate) && contract.getEndDate().after(checkOutDate)) {
                                logger.info("six");
                                contractService.getContract(contract.getId()).getSeasons().forEach(season -> {
                                    logger.info("seven");
                                    if(season.getStartDate().before(checkInDate) && season.getEndDate().after(checkInDate)){
                                        List<RoomType> roomTypes = seasonRoomTypePricingService.getAllRoomTypesOfSeasonInContract(season.getId(), contract.getId());
                                        roomTypes.forEach((roomType -> {
                                            int bookedRoomCount = getBookedRoomsCount(roomType.getId(), checkInDate, checkOutDate);
                                            logger.info("booked: " + bookedRoomCount);
                                            SeasonRoomTypePricing roomTypePricing;
                                            try{
                                                roomTypePricing = seasonRoomTypePricingService.getRoomTypePricing(season.getId(), contract.getId(), roomType.getId());
                                            }catch (EntityNotFoundException e){
                                                roomTypePricing = null;
                                            }
                                            if(roomTypePricing != null){
                                                if((roomTypePricing.getNoOfRooms() - bookedRoomCount) >= noOfRooms){

                                                    available.set(true);
                                                }
                                            }

                                        }));
                                    }


                                });
                            }

                            }
                        if (available.get() && hotel.getDistrict().equalsIgnoreCase(location)){
                            logger.info("eight");
                            return true;
                        }
                        logger.info(totalAmountOfGuest.get()+"hi");
                        logger.info(totalRoomsAvailable.get()+"hi");
                        logger.info("nine");
                        return false;
                    }).collect(Collectors.toList());
                    return hotels;
            }
        }
        return null;
    }

    @Override
    public List<SummaryResult> searchHotelsSummary(String search, HotelSearch hotelSearch) {
        List<Contract> contracts = new ArrayList<>();
        List<SummaryResult> summaryResults = new ArrayList<>();

        AtomicInteger totalAmountOfGuest = new AtomicInteger();
        AtomicInteger totalRoomsAvailable = new AtomicInteger();

        Date checkInDate = hotelSearch.getCheckInDate();
        Date checkOutDate = hotelSearch.getCheckOutDate();
        String location = hotelSearch.getLocation();
        Integer noOfRooms = hotelSearch.getNoOfRooms();
        Integer noOfAdults = hotelSearch.getNoOfAdults();

        AtomicBoolean available = new AtomicBoolean(false);

        if(search.equalsIgnoreCase("hotel")){
            contracts = contractService.getAllContracts();
            logger.info("one");
            for(Contract contract : contracts){
                LocalDate contractStartDateMinusOne = contract.getStartDate().toLocalDate().minusDays(1);
                LocalDate contractEndDatePlusOne = contract.getEndDate().toLocalDate().plusDays(1);
//                if(contract.getStartDate().before(checkInDate) && contract.getEndDate().after(checkOutDate)) {


                if(contractStartDateMinusOne.isBefore(checkInDate.toLocalDate()) && contractEndDatePlusOne.isAfter(checkOutDate.toLocalDate())) {
                    List<Season> seasons = contract.getSeasons();
                    for (Season season : seasons){
                        logger.info(season.getName());
//                        if(season.getStartDate().before(checkInDate) && season.getEndDate().after(checkInDate)){
                        LocalDate seasonStartDateMinusOne = season.getStartDate().toLocalDate().minusDays(1);
                        LocalDate seasonEndDatePlusOne = season.getEndDate().toLocalDate().plusDays(1);
//                        seasonStartDateMinusOne.isBefore(checkInDate.toLocalDate());
//                        seasonEndDatePlusOne.isAfter(checkInDate.toLocalDate());
                        if(seasonStartDateMinusOne.isBefore(checkInDate.toLocalDate()) && seasonEndDatePlusOne.isAfter(checkInDate.toLocalDate())){
                            List<RoomType> roomTypes = seasonRoomTypePricingService.getAllRoomTypesOfSeasonInContract(season.getId(), contract.getId());

                            for (RoomType roomType : roomTypes){
                                int bookedRoomCount = getBookedRoomsCount(roomType.getId(), checkInDate, checkOutDate);
                                logger.info("booked: " + bookedRoomCount);
                                SeasonRoomTypePricing roomTypePricing;
                                try{
                                    logger.info("seasonID: " + season.getId());
                                    logger.info("contractID: " + contract.getId());
                                    logger.info("roomtypeID: " + roomType.getId());
                                    roomTypePricing = seasonRoomTypePricingService.getRoomTypePricing(season.getId(), roomType.getId(), contract.getId());
                                }catch (EntityNotFoundException e){
                                    roomTypePricing = null;
                                }
                                logger.info("pricing: " + roomTypePricing.getPrice());
                                if(roomTypePricing != null){
                                    Integer avialableRooms = roomTypePricing.getNoOfRooms() - bookedRoomCount;
                                    logger.info(avialableRooms.toString());

//                                    if(avialableRooms >= noOfRooms && contract.getHotel().getDistrict().equalsIgnoreCase(location)){
                                    if(avialableRooms >= noOfRooms && contract.getHotel().getDistrict().equalsIgnoreCase(location) && noOfAdults <= (noOfRooms * roomTypePricing.getRoomType().getMaxAdult())){
                                        Hotel hotel = contract.getHotel();
                                        Image image = null;
                                        Discount discount = new Discount();
                                        discount.setPercentage(0.0);
                                        if(hotel.getImages().size() > 0){
                                            image = hotel.getImages().get(0);
                                        }
                                        if(contract.getDiscounts().size() > 0){
                                            LocalDate currentDate = LocalDate.now();
                                            for(Discount discount1 : contract.getDiscounts()){
                                                Long daysDifference = ChronoUnit.DAYS.between(currentDate, checkInDate.toLocalDate());
                                                logger.info("days difference: " + daysDifference);
                                                if(daysDifference >= discount1.getDaysPriorToArrival()){
                                                    discount = discount1;
                                                }
                                            }
//                                            discount = contract.getDiscounts().get(0);
                                        }
                                        SummaryResult summaryResult = new SummaryResult(hotel.getId(), hotel.getName(), image, hotel.getDistrict(), roomTypePricing.getPrice(), discount.getPercentage(), season.getMarkup());
                                        summaryResults.add(summaryResult);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return summaryResults;
            }
        return null;
    }

    @Override
    public DetailedHotelResult getHotelDetails(Long hotelId, HotelSearch hotelSearch) {

        DetailedHotelResult detailedHotelResult = new DetailedHotelResult();

        Hotel hotel = hotelRepository.findById(hotelId).orElse(null);

        Date checkInDate = hotelSearch.getCheckInDate();
        Date checkOutDate = hotelSearch.getCheckOutDate();
        String location = hotelSearch.getLocation();
        Integer noOfRooms = hotelSearch.getNoOfRooms();
        Integer noOfAdults = hotelSearch.getNoOfAdults();

        if(hotel != null){
            List<Contract> contracts = hotel.getContracts();
            for (Contract contract : contracts){
                LocalDate contractStartDateMinusOne = contract.getStartDate().toLocalDate().minusDays(1);
                LocalDate contractEndDatePlusOne = contract.getEndDate().toLocalDate().plusDays(1);
                if(contractStartDateMinusOne.isBefore(checkInDate.toLocalDate()) && contractEndDatePlusOne.isAfter(checkOutDate.toLocalDate())) {
                    Discount discount = null;
                    if(contract.getDiscounts().size() > 0){
                        LocalDate currentDate = LocalDate.now();
                        for(Discount discount1 : contract.getDiscounts()){
                            Long daysDifference = ChronoUnit.DAYS.between(currentDate, checkInDate.toLocalDate());
                            logger.info("days difference: " + daysDifference);
                            if(daysDifference >= discount1.getDaysPriorToArrival()){
                                discount = discount1;
                            }
                        }
                    }

                    List<Season> seasons = contract.getSeasons();
                    for (Season season : seasons){
                        LocalDate seasonStartDateMinusOne = season.getStartDate().toLocalDate().minusDays(1);
                        LocalDate seasonEndDatePlusOne = season.getEndDate().toLocalDate().plusDays(1);
                        if(seasonStartDateMinusOne.isBefore(checkInDate.toLocalDate()) && seasonEndDatePlusOne.isAfter(checkInDate.toLocalDate())){
                            List<RoomTypeWithPricing> roomTypeWithPricings = new ArrayList<>();
                            List<SupplementWithPricing> supplementWithPricings = new ArrayList<>();
                            List<RoomType> roomTypes = seasonRoomTypePricingService.getAllRoomTypesOfSeasonInContract(season.getId(), contract.getId());
                            for (RoomType roomType : roomTypes){
                                int bookedRoomCount = getBookedRoomsCount(roomType.getId(), checkInDate, checkOutDate);
                                logger.info("booked: " + bookedRoomCount);
                                SeasonRoomTypePricing roomTypePricing;
                                try{
                                    logger.info("seasonID: " + season.getId());
                                    logger.info("contractID: " + contract.getId());
                                    logger.info("roomtypeID: " + roomType.getId());
                                    roomTypePricing = seasonRoomTypePricingService.getRoomTypePricing(season.getId(), roomType.getId(), contract.getId());
                                }catch (EntityNotFoundException e){
                                    roomTypePricing = null;
                                }
                                logger.info("pricing: " + roomTypePricing.getPrice());
                                if(roomTypePricing != null){
                                    Integer avialableRooms = roomTypePricing.getNoOfRooms() - bookedRoomCount;
                                    RoomTypeWithPricing roomTypeWithPricing = new RoomTypeWithPricing(roomType, roomTypePricing, avialableRooms);
                                    roomTypeWithPricings.add(roomTypeWithPricing);
                                }
                            }
                            List<Supplement> supplements = seasonSupplementPricingService.getAllSupplementsOfSeasonInContract(season.getId(), contract.getId());
                            for (Supplement supplement : supplements){

                                SeasonSupplementPricing supplementPricing;
                                try{
                                    logger.info("seasonID: " + season.getId());
                                    logger.info("contractID: " + contract.getId());
                                    logger.info("roomtypeID: " + supplement.getId());
                                    supplementPricing = seasonSupplementPricingService.getSupplementPricing(season.getId(), supplement.getId(), contract.getId());
                                }catch (EntityNotFoundException e){
                                    supplementPricing = null;
                                }
                                logger.info("pricing: " + supplementPricing.getPrice());
                                if(supplementPricing != null){
                                    SupplementWithPricing supplementWithPricing = new SupplementWithPricing(supplement, supplementPricing);
                                    supplementWithPricings.add(supplementWithPricing);
                                }
                            }
                            detailedHotelResult.setHotel(hotel);
                            detailedHotelResult.setContract(contract);
                            detailedHotelResult.setSeason(season);
                            detailedHotelResult.setRoomTypeWithPricings(roomTypeWithPricings);
                            detailedHotelResult.setSupplementWithPricings(supplementWithPricings);
                            detailedHotelResult.setDiscount(discount);
                            detailedHotelResult.setMarkup(season.getMarkup());
                            return detailedHotelResult;
                        }
                    }
                }
            }
        }

        return null;
    }

//    @Override
//    public List<SummaryResult> searchHotelsSummary(String search, HotelSearch hotelSearch) {
//        List<Hotel> hotels = new ArrayList<>();
//        List<SummaryResult> summaryResults = new ArrayList<>();
//
//        AtomicInteger totalAmountOfGuest = new AtomicInteger();
//        AtomicInteger totalRoomsAvailable = new AtomicInteger();
//
//        Date checkInDate = hotelSearch.getCheckInDate();
//        Date checkOutDate = hotelSearch.getCheckOutDate();
//        String location = hotelSearch.getLocation();
//        Integer noOfRooms = hotelSearch.getNoOfRooms();
//        Integer noOfAdults = hotelSearch.getNoOfAdults();
//
//        AtomicBoolean available = new AtomicBoolean(false);
//
//        if(search.equalsIgnoreCase("hotel")){
//            hotels = hotelRepository.findAll();
//            logger.info("one");
//            if(hotelSearch != null){
//                logger.info("two");
//                logger.info("three");
//                hotels = hotels.stream().filter((hotel) -> {
//                    SummaryResult summaryResult = new SummaryResult();
//                    summaryResult.setHotelId(hotel.getId());
//                    summaryResult.setBaseRoomTypePrice(null);
//                    summaryResult.setHotelName(hotel.getName());
//                    summaryResult.setHotelLocation(hotel.getDistrict());
//                    if(hotel.getImages().size() > 0){
//                        summaryResult.setHotelImage(hotel.getImages().get(0).getUrl());
//                    }else{
//                        summaryResult.setHotelImage(null);
//                    }
//
//                    logger.info("four");
//                    List<Contract> contracts = hotel.getContracts();
//                    for(Contract contract : contracts){
//                        logger.info("five");
//                        available.set(false);
//                        if(contract.getStartDate().before(checkInDate) && contract.getEndDate().after(checkOutDate)) {
//                            logger.info("six");
//                            contractService.getContract(contract.getId()).getSeasons().forEach(season -> {
//                                logger.info("seven");
//                                if(season.getStartDate().before(checkInDate) && season.getEndDate().after(checkInDate)){
//                                    List<RoomType> roomTypes = seasonRoomTypePricingService.getAllRoomTypesOfSeasonInContract(season.getId(), contract.getId());
//
//                                    roomTypes.forEach((roomType -> {
//                                        int bookedRoomCount = getBookedRoomsCount(roomType.getId(), checkInDate, checkOutDate);
//                                        logger.info("booked: " + bookedRoomCount);
//                                        SeasonRoomTypePricing roomTypePricing;
//                                        try{
//                                            roomTypePricing = seasonRoomTypePricingService.getRoomTypePricing(season.getId(), contract.getId(), roomType.getId());
//                                        }catch (EntityNotFoundException e){
//                                            roomTypePricing = null;
//                                        }
//                                        if(contract.getDiscounts().size() > 0){
//                                            summaryResult.setDiscountPercentage(contract.getDiscounts().get(0).getPercentage());
//                                        }else{
//                                            summaryResult.setDiscountPercentage(null);
//                                        }
//
//                                        if(roomTypePricing != null){
//                                            if((roomTypePricing.getNoOfRooms() - bookedRoomCount) >= noOfRooms){
//                                                if(summaryResult.getBaseRoomTypePrice() == null && summaryResult.getHotelLocation().equalsIgnoreCase(location)){
//                                                    summaryResult.setBaseRoomTypePrice(roomTypePricing.getPrice());
//                                                    summaryResults.add(summaryResult);
//                                                }
//
//                                                available.set(true);
//                                            }
//                                        }
//
//                                    }));
//                                }
//
//
//                            });
//                        }
//
//                    }
//                    if (available.get() && hotel.getDistrict().equalsIgnoreCase(location)){
//                        logger.info("eight");
////                        summaryResults.stream().filter(sum -> sum.getHotelLocation().equalsIgnoreCase(location));
////                        summaryResults.add(summaryResult);
//                        available.set(false);
//                        return true;
//                    }
//                    logger.info(totalAmountOfGuest.get()+"hi");
//                    logger.info(totalRoomsAvailable.get()+"hi");
//                    logger.info("nine");
//                    return false;
//                }).collect(Collectors.toList());
//                return summaryResults;
//            }
//        }
//        return null;
//    }

    public int getBookedRoomsCount(Long roomTypeId, Date ci, Date co){
//        Date ci = new Date(20240302);
//        Date co = new Date(20240304);

        RoomType roomType = roomTypeService.getRoomType(roomTypeId);
        logger.info(roomType.getName());
        List<Booking> bookings = roomType.getBookings().stream().filter(booking ->
                (ci.after(booking.getCheckInDate()) && ci.before(booking.getCheckOutDate())) || (co.before(booking.getCheckOutDate()) && co.after(booking.getCheckInDate()))
                || ci.equals(booking.getCheckOutDate()) || ci.equals(booking.getCheckInDate())
                || co.equals(booking.getCheckOutDate()) || co.equals(booking.getCheckInDate())).collect(Collectors.toList());





        int count = 0;

        for (Booking booking: bookings) {

            count += booking.getNoOfRooms();
            logger.info("count: " + count + ",, noOfRooms: " + booking.getNoOfRooms());
        }


        return count;
    }
}
