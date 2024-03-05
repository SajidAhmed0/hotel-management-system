package com.hotelmangementsystem.application.repository.pricing;

import com.hotelmangementsystem.application.entity.Season;
import com.hotelmangementsystem.application.entity.Supplement;
import com.hotelmangementsystem.application.entity.pricing.SeasonSupplementPricing;
import com.hotelmangementsystem.application.key.SeasonSupplementKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeasonSupplementPricingRepository extends JpaRepository<SeasonSupplementPricing, SeasonSupplementKey> {

//    @Query("SELECT ss.supplement_id FROM SeasonSupplementPricingRepository ss WHERE ss.season_id=?1")
//    public List<Long> getAllSupplementBySeason( Long seasonId);
}
