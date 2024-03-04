package com.hotelmangementsystem.application.repository;

import com.hotelmangementsystem.application.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    Optional<Hotel> findHotelByName(String name);
}
