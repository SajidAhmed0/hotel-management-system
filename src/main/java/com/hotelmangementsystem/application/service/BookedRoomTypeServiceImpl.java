package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.BookedRoomType;
import com.hotelmangementsystem.application.repository.BookedRoomTypeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookedRoomTypeServiceImpl implements BookedRoomTypeService {

    @Autowired
    private BookedRoomTypeRepository bookedRoomTypeRepository;

    @Override
    public List<BookedRoomType> getAllBookedRoomTypes() {
        return bookedRoomTypeRepository.findAll();
    }

    @Override
    public BookedRoomType getBookedRoomType(Long id) {
        return bookedRoomTypeRepository.findById(id).orElse(null);
    }

    @Override
    public BookedRoomType addBookedRoomType(BookedRoomType bookedRoomType) {
        return bookedRoomTypeRepository.save(bookedRoomType);
    }

    @Override
    public BookedRoomType updateBookedRoomType(Long id, BookedRoomType bookedRoomType) {
        BookedRoomType bookedRoomTypeDB = bookedRoomTypeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("BookedRoomType with id " + id + " does not exists"));

        if(bookedRoomTypeDB != null){
            bookedRoomTypeDB.setName(bookedRoomType.getName());
            bookedRoomTypeDB.setNoOfRooms(bookedRoomType.getNoOfRooms());
            bookedRoomTypeDB.setMaxAdult(bookedRoomType.getMaxAdult());
            bookedRoomTypeDB.setDescription(bookedRoomType.getDescription());
            bookedRoomTypeDB.setPrice(bookedRoomType.getPrice());
            bookedRoomTypeDB.setOriginalId(bookedRoomType.getOriginalId());
            return bookedRoomTypeRepository.save(bookedRoomTypeDB);
        }

        return null;
    }

    @Override
    public String deleteBookedRoomType(Long id) {
        boolean exists = bookedRoomTypeRepository.existsById(id);

        if(!exists){
            throw new EntityNotFoundException("BookedRoomType with id " + id + " does not exists");
        }
        bookedRoomTypeRepository.deleteById(id);
        return "deleted";
    }
}
