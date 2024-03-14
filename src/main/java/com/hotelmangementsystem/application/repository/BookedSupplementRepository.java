package com.hotelmangementsystem.application.repository;

import com.hotelmangementsystem.application.entity.BookedSupplement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookedSupplementRepository extends JpaRepository<BookedSupplement, Long> {
}
