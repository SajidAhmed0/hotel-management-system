package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.BookedRoomType;

import java.util.List;

public interface BookedRoomTypeService {

    public List<BookedRoomType> getAllBookedRoomTypes();

    public BookedRoomType getBookedRoomType(Long id);

    public BookedRoomType addBookedRoomType(BookedRoomType bookedRoomType);

    public BookedRoomType updateBookedRoomType(Long id, BookedRoomType bookedRoomType);

    public String deleteBookedRoomType(Long id);
}
