package com.hotelmangementsystem.application.repository.pricing;

import com.hotelmangementsystem.application.entity.RoomType;
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

    @Query("SELECT new com.hotelmangementsystem.application.entity.Supplement(sp.id, sp.name, sp.description) FROM Supplement sp WHERE sp.hotel.id=?1 AND sp.id NOT IN (SELECT p.supplement.id FROM SeasonSupplementPricing p WHERE p.contract.id=?2 AND p.season.id=?3)")
    public List<Supplement> getUnPricedSupplements(Long hotelId, Long contractId, Long seasonId);
}
