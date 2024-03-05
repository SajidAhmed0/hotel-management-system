package com.hotelmangementsystem.application.repository;

import com.hotelmangementsystem.application.entity.BookedPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookedPriceRepository extends JpaRepository<BookedPrice, Long> {
}