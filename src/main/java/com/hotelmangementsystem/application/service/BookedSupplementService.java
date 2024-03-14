package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.BookedSupplement;

import java.util.List;

public interface BookedSupplementService {

    public List<BookedSupplement> getAllBookedSupplements();

    public BookedSupplement getBookedSupplement(Long id);

    public BookedSupplement addBookedSupplement(BookedSupplement bookedSupplement);

    public BookedSupplement updateBookedSupplement(Long id, BookedSupplement bookedSupplement);

    public String deleteBookedSupplement(Long id);
}
