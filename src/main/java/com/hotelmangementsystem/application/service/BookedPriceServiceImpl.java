package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.BookedPrice;
import com.hotelmangementsystem.application.repository.BookedPriceRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookedPriceServiceImpl implements BookedPriceService{

    @Autowired
    private BookedPriceRepository bookedPriceRepository;

    @Override
    public List<BookedPrice> getAllBookedPrices() {
        return bookedPriceRepository.findAll();
    }

    @Override
    public BookedPrice getBookedPrice(Long id) {
        return bookedPriceRepository.findById(id).orElse(null);
    }

    @Override
    public BookedPrice addBookedPrice(BookedPrice bookedPrice) {
        return bookedPriceRepository.save(bookedPrice);
    }

    @Override
    public BookedPrice updateBookedPrice(Long id, BookedPrice bookedPrice) {
        BookedPrice bookedPriceDB = bookedPriceRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("BookedPrice with id " + id + " does not exists"));

        if(bookedPrice != null){
            bookedPriceDB.setType(bookedPrice.getType());
            bookedPriceDB.setName(bookedPrice.getName());
            bookedPriceDB.setPrice(bookedPrice.getPrice());
            return bookedPriceRepository.save(bookedPriceDB);
        }
        return null;

    }

    @Override
    public String deleteBookedPrice(Long id) {
        boolean exists = bookedPriceRepository.existsById(id);
        if(!exists) {
            throw new EntityNotFoundException("BookedPrice with id " + id + " does not exists");
        }
        bookedPriceRepository.deleteById(id);
        return "deleted";
    }
}
