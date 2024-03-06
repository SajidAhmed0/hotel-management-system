package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Supplement;
import com.hotelmangementsystem.application.repository.SupplementRepository;
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
class SupplementServiceTest {

    @Autowired
    private SupplementService supplementService;

    @MockBean
    private SupplementRepository supplementRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getAllSupplements() {
        List<Supplement> supplements = new ArrayList<>();
        supplements.add(new Supplement());
        supplements.add(new Supplement());

        when(supplementRepository.findAll()).thenReturn(supplements);

        // Test
        List<Supplement> result = supplementService.getAllSupplements();

        // Verify
        assertEquals(2, result.size());
    }

    @Test
    void getSupplement() {
        Supplement supplement = new Supplement();
        long id = 1L;

        when(supplementRepository.findById(id)).thenReturn(Optional.of(supplement));

        // Test
        Supplement result = supplementService.getSupplement(id);

        // Verify
        assertNotNull(result);
    }

    @Test
    void addSupplement() {
        Supplement supplement = new Supplement();

        when(supplementRepository.save(Mockito.any(Supplement.class))).thenReturn(supplement);

        // Test
        Supplement result = supplementService.addSupplement(supplement);

        // Verify
        assertNotNull(result);
    }

    @Test
    void updateSupplement() {
        long id = 1L;
        Supplement existingSupplement = new Supplement();
        existingSupplement.setId(id);
        existingSupplement.setName("Existing Supplement");
        existingSupplement.setDescription("Existing Description");

        Supplement updatedSupplement = new Supplement();
        updatedSupplement.setId(id);
        updatedSupplement.setName("Updated Supplement");
        updatedSupplement.setDescription("Updated Description");

        when(supplementRepository.findById(id)).thenReturn(Optional.of(existingSupplement));
        when(supplementRepository.save(Mockito.any(Supplement.class))).thenReturn(updatedSupplement);

        // Test
        Supplement result = supplementService.updateSupplement(id, updatedSupplement);

        // Verify
        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals("Updated Supplement", result.getName());
        assertEquals("Updated Description", result.getDescription());
    }

    @Test
    void deleteSupplement() {
        long id = 1L;

        when(supplementRepository.existsById(id)).thenReturn(true);

        // Test
        String result = supplementService.deleteSupplement(id);

        // Verify
        assertEquals("delete", result);
    }
}