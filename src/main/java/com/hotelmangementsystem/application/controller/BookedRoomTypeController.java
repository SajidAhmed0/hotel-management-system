package com.hotelmangementsystem.application.controller;

import com.hotelmangementsystem.application.entity.BookedRoomType;
import com.hotelmangementsystem.application.service.BookedRoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/bookedroomtypes")
public class BookedRoomTypeController {

    @Autowired
    private BookedRoomTypeService bookedRoomTypeService;

    @GetMapping
    public List<BookedRoomType> getAllBookedRoomTypes(){
        return bookedRoomTypeService.getAllBookedRoomTypes();
    }

    @GetMapping("/{id}")
    public BookedRoomType getBookedRoomType(@PathVariable("id") Long id) {
        return bookedRoomTypeService.getBookedRoomType(id);
    }

    @PostMapping
    public BookedRoomType addBookedRoomType(@RequestBody BookedRoomType bookedRoomType){
        return bookedRoomTypeService.addBookedRoomType(bookedRoomType);
    }

    @PutMapping("/{id}")
    public BookedRoomType updateBookedRoomType(@PathVariable("id") Long id, @RequestBody BookedRoomType bookedRoomType){
        return bookedRoomTypeService.updateBookedRoomType(id, bookedRoomType);
    }

    @DeleteMapping("/{id}")
    public String deleteBookedRoomType(@PathVariable("id") Long id){
        return bookedRoomTypeService.deleteBookedRoomType(id);
    }
}
