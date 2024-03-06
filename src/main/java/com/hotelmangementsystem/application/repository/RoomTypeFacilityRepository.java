package com.hotelmangementsystem.application.repository;

import com.hotelmangementsystem.application.entity.RoomTypeFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTypeFacilityRepository extends JpaRepository<RoomTypeFacility, Long> {
}
