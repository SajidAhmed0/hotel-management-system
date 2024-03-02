package com.hotelmangementsystem.application.repository;

import com.hotelmangementsystem.application.entity.Supplement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplementRepository extends JpaRepository<Supplement, Long> {
}
