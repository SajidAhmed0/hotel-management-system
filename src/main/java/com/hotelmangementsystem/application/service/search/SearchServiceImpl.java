package com.hotelmangementsystem.application.service.search;

import com.hotelmangementsystem.application.entity.Booking;
import com.hotelmangementsystem.application.entity.Contract;
import com.hotelmangementsystem.application.entity.Hotel;
import com.hotelmangementsystem.application.entity.RoomType;
import com.hotelmangementsystem.application.entity.pricing.SeasonRoomTypePricing;
import com.hotelmangementsystem.application.entity.search.HotelSearch;
import com.hotelmangementsystem.application.repository.HotelRepository;
import com.hotelmangementsystem.application.service.ContractService;
import com.hotelmangementsystem.application.service.RoomTypeService;
import com.hotelmangementsystem.application.service.pricing.SeasonRoomTypePricingService;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
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
//                                contractService.getContract(contract.getId()).getRoomTypes().forEach(roomType -> {
//                                        logger.info("seven");
//                                        int bookedRoomCount = getBookedRoomsCount(roomType.getId(), checkInDate, checkOutDate);
//                                        logger.info("booked: " + bookedRoomCount);
//                                        //TODO: need to change this to availabe
////                                        totalRoomsAvailable.getAndAdd(getBookedRoomsCount(roomType.getId(), checkInDate, checkOutDate));
////                                        totalAmountOfGuest.getAndAdd(getBookedRoomsCount(roomType.getId(), checkInDate, checkOutDate) * roomType.getMaxAdult());
////                                        System.out.println(totalAmountOfGuest.get());
////                                        System.out.println(totalRoomsAvailable.get());
////                                        logger.info(totalAmountOfGuest.get()+"hi");
////                                        logger.info(totalRoomsAvailable.get()+"hi");
//
//                                    if((roomType.getNoOfRooms() - bookedRoomCount) >= noOfRooms){
//
//                                        available.set(true);
//                                    }
//
//                                });
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
