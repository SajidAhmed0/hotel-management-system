package com.hotelmangementsystem.application.repository.pricing;

import com.hotelmangementsystem.application.entity.pricing.SeasonRoomTypePricing;
import com.hotelmangementsystem.application.key.SeasonRoomTypeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonRoomTypePricingRepository extends JpaRepository<SeasonRoomTypePricing, SeasonRoomTypeKey> {
}
