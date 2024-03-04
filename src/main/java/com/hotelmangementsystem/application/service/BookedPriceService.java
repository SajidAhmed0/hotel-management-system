package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.BookedPrice;

import java.util.ArrayList;
import java.util.List;

public interface BookedPriceService {
    public List<BookedPrice> getAllBookedPrices();

    public BookedPrice getBookedPrice(Long id);

    public BookedPrice addBookedPrice(BookedPrice bookedPrice);

    public BookedPrice updateBookedPrice(Long id, BookedPrice bookedPrice);

    public String deleteBookedPrice(Long id);
}
