package com.hotelmangementsystem.application.repository.pricing;

import com.hotelmangementsystem.application.entity.RoomType;
import com.hotelmangementsystem.application.entity.pricing.SeasonRoomTypePricing;
import com.hotelmangementsystem.application.key.SeasonRoomTypeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeasonRoomTypePricingRepository extends JpaRepository<SeasonRoomTypePricing, SeasonRoomTypeKey> {
//    @Query(value = "SELECT rt FROM room_type rt WHERE rt.hotel_id=?1 AND rt.id NOT IN ( SELECT p.roomtype_id FROM season_room_type_pricing p WHERE p.contract_id=?2 AND p.season_id=?3)", nativeQuery = true)
//    public List<RoomType> getUnPricedRoomTypes(Long hotelId, Long contractId, Long seasonId);

    @Query("SELECT new com.hotelmangementsystem.application.entity.RoomType(rt.id, rt.name, rt.maxAdult, rt.description) FROM RoomType rt WHERE rt.hotel.id=?1 AND rt.id NOT IN (SELECT p.roomType.id FROM SeasonRoomTypePricing p WHERE p.contract.id=?2 AND p.season.id=?3)")
    public List<RoomType> getUnPricedRoomTypes(Long hotelId, Long contractId, Long seasonId);
}
