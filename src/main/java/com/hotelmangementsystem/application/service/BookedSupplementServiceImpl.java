package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.BookedSupplement;
import com.hotelmangementsystem.application.repository.BookedSupplementRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookedSupplementServiceImpl implements BookedSupplementService {

    @Autowired
    private BookedSupplementRepository bookedSupplementRepository;

    @Override
    public List<BookedSupplement> getAllBookedSupplements() {
        return bookedSupplementRepository.findAll();
    }

    @Override
    public BookedSupplement getBookedSupplement(Long id) {
        return bookedSupplementRepository.findById(id).orElse(null);
    }

    @Override
    public BookedSupplement addBookedSupplement(BookedSupplement bookedSupplement) {
        return bookedSupplementRepository.save(bookedSupplement);
    }

    @Override
    public BookedSupplement updateBookedSupplement(Long id, BookedSupplement bookedSupplement) {
        BookedSupplement bookedSupplementDB = bookedSupplementRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("BookedSupplement with id " + id + " does not exists"));

        if(bookedSupplementDB != null){
            bookedSupplementDB.setName(bookedSupplement.getName());
            bookedSupplementDB.setDescription(bookedSupplement.getDescription());
            bookedSupplementDB.setPrice(bookedSupplement.getPrice());
            bookedSupplementDB.setOriginalId(bookedSupplement.getOriginalId());

            return bookedSupplementRepository.save(bookedSupplementDB);
        }

        return null;
    }

    @Override
    public String deleteBookedSupplement(Long id) {
        boolean exists = bookedSupplementRepository.existsById(id);

        if(!exists){
            throw new EntityNotFoundException("BookedSupplement with id " + id + " does not exists");
        }

        bookedSupplementRepository.deleteById(id);
        return "deleted";
    }
}
