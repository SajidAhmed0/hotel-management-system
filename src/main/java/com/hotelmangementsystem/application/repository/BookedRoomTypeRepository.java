package com.hotelmangementsystem.application.repository;

import com.hotelmangementsystem.application.entity.BookedRoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookedRoomTypeRepository extends JpaRepository<BookedRoomType, Long> {
}
