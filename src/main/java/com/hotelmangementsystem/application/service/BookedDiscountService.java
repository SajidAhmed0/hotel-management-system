package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.BookedDiscount;

import java.util.List;

public interface BookedDiscountService {
    public List<BookedDiscount> getAllBookedDiscounts();

    public BookedDiscount getBookedDiscount(Long id);

    public BookedDiscount addBookedDiscount(BookedDiscount bookedDiscount);

    public BookedDiscount updateBookedDiscount(Long id, BookedDiscount bookedDiscount);

    public String deleteBookedDiscount(Long id);
}
