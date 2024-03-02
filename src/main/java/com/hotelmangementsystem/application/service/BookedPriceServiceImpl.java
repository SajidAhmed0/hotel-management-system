package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.BookedPrice;
import com.hotelmangementsystem.application.repository.BookedPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BookedPriceServiceImpl implements BookedPriceService{

    @Autowired
    private BookedPriceRepository bookedPriceRepository;

    @Override
    public ArrayList<BookedPrice> getAllBookedPrices() {
        return (ArrayList<BookedPrice>) bookedPriceRepository.findAll();
    }

    @Override
    public BookedPrice getBookedPrice(Long id) {
        return bookedPriceRepository.findById(id).get();
    }

    @Override
    public BookedPrice addBookedPrice(BookedPrice bookedPrice) {
        return bookedPriceRepository.save(bookedPrice);
    }

    @Override
    public BookedPrice updateBookedPrice(Long id, BookedPrice bookedPrice) {
        BookedPrice bookedPriceDB = bookedPriceRepository.findById(id).get();
        bookedPriceDB.setPrice(bookedPrice.getPrice());
        return bookedPriceRepository.save(bookedPriceDB);
    }

    @Override
    public String deleteBookedPrice(Long id) {
        bookedPriceRepository.deleteById(id);
        return "deleted";
    }
}
