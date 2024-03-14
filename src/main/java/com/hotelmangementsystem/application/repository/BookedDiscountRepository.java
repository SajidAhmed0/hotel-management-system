package com.hotelmangementsystem.application.repository;

import com.hotelmangementsystem.application.entity.BookedDiscount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookedDiscountRepository extends JpaRepository<BookedDiscount, Long> {
}
