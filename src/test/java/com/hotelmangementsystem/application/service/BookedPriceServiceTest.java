package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.BookedPrice;
import com.hotelmangementsystem.application.repository.BookedPriceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class BookedPriceServiceTest {

    @Autowired
    private BookedPriceService bookedPriceService;

    @MockBean
    private BookedPriceRepository bookedPriceRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getAllBookedPrices() {
        List<BookedPrice> bookedPrices = new ArrayList<>();
        bookedPrices.add(new BookedPrice());
        bookedPrices.add(new BookedPrice());

        when(bookedPriceRepository.findAll()).thenReturn(bookedPrices);

        // Test
        List<BookedPrice> result = bookedPriceService.getAllBookedPrices();

        // Verify
        assertEquals(2, result.size());
    }

    @Test
    void getBookedPrice() {
        BookedPrice bookedPrice = new BookedPrice();
        long id = 1L;

        when(bookedPriceRepository.findById(id)).thenReturn(Optional.of(bookedPrice));

        // Test
        BookedPrice result = bookedPriceService.getBookedPrice(id);

        // Verify
        assertNotNull(result);
    }

    @Test
    void addBookedPrice() {
        BookedPrice bookedPrice = new BookedPrice();

        when(bookedPriceRepository.save(Mockito.any(BookedPrice.class))).thenReturn(bookedPrice);

        // Test
        BookedPrice result = bookedPriceService.addBookedPrice(bookedPrice);

        // Verify
        assertNotNull(result);
    }

    @Test
    void updateBookedPrice() {
        long id = 1L;
        BookedPrice existingBookedPrice = new BookedPrice();
        existingBookedPrice.setId(id);
        existingBookedPrice.setName("Existing BookedPrice");

        BookedPrice updatedBookedPrice = new BookedPrice();
        updatedBookedPrice.setId(id);
        updatedBookedPrice.setName("Updated BookedPrice");

        when(bookedPriceRepository.findById(id)).thenReturn(Optional.of(existingBookedPrice));
        when(bookedPriceRepository.save(Mockito.any(BookedPrice.class))).thenReturn(updatedBookedPrice);

        // Test
        BookedPrice result = bookedPriceService.updateBookedPrice(id, updatedBookedPrice);

        // Verify
        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals("Updated BookedPrice", result.getName());
    }

    @Test
    void deleteBookedPrice() {
        long id = 1L;

        when(bookedPriceRepository.existsById(id)).thenReturn(true);

        // Test
        String result = bookedPriceService.deleteBookedPrice(id);

        // Verify
        assertEquals("deleted", result);
    }
}