package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.BookedDiscount;
import com.hotelmangementsystem.application.repository.BookedDiscountRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookedDiscountServiceImpl implements BookedDiscountService {

    @Autowired
    private BookedDiscountRepository bookedDiscountRepository;

    @Override
    public List<BookedDiscount> getAllBookedDiscounts() {
        return bookedDiscountRepository.findAll();
    }

    @Override
    public BookedDiscount getBookedDiscount(Long id) {
        return bookedDiscountRepository.findById(id).orElse(null);
    }

    @Override
    public BookedDiscount addBookedDiscount(BookedDiscount bookedDiscount) {
        return bookedDiscountRepository.save(bookedDiscount);
    }

    @Override
    public BookedDiscount updateBookedDiscount(Long id, BookedDiscount bookedDiscount) {
        BookedDiscount bookedDiscountDB = bookedDiscountRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("BookedDiscount with id " + id + " does not exists"));

        if(bookedDiscountDB != null){
            bookedDiscountDB.setName(bookedDiscount.getName());
            bookedDiscountDB.setDescription(bookedDiscount.getDescription());
            bookedDiscountDB.setPercentage(bookedDiscount.getPercentage());
            bookedDiscountDB.setOriginalId(bookedDiscount.getOriginalId());
            bookedDiscountDB.setDaysPriorToArrival(bookedDiscount.getDaysPriorToArrival());
            return bookedDiscountRepository.save(bookedDiscountDB);
        }

        return null;
    }

    @Override
    public String deleteBookedDiscount(Long id) {
        boolean exists = bookedDiscountRepository.existsById(id);

        if(!exists){
            throw new EntityNotFoundException("BookedDiscount with id " + id + " does not exists");
        }
        bookedDiscountRepository.deleteById(id);
        return "deleted";
    }
}
