package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Season;
import com.hotelmangementsystem.application.repository.SeasonRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class SeasonServiceTest {

    @Autowired
    private SeasonService seasonService;

    @MockBean
    private SeasonRepository seasonRepository;


    @Test
    void getAllSeasons() {
        List<Season> seasons = new ArrayList<>();
        seasons.add(new Season());
        seasons.add(new Season());

        when(seasonRepository.findAll()).thenReturn(seasons);

        // Test
        List<Season> result = seasonService.getAllSeasons();

        // Verify
        assertEquals(2, result.size());
    }

    @Test
    void getSeason() {
        Season season = new Season();
        long id = 1L;

        when(seasonRepository.findById(id)).thenReturn(Optional.of(season));

        // Test
        Season result = seasonService.getSeason(id);

        // Verify
        assertNotNull(result);
    }

    @Test
    void addSeason() {
        Season season = new Season();

        when(seasonRepository.save(Mockito.any(Season.class))).thenReturn(season);

        // Test
        Season result = seasonService.addSeason(season);

        // Verify
        assertNotNull(result);
    }

    @Test
    void updateSeason() {
        long id = 1L;
        Season existingSeason = new Season();
        existingSeason.setId(id);
        existingSeason.setName("Summer");
        existingSeason.setStartDate(Date.valueOf(LocalDate.of(2024, 6, 1)));
        existingSeason.setEndDate(Date.valueOf(LocalDate.of(2024, 8, 31)));
        existingSeason.setMarkup(0.1);

        Season updatedSeason = new Season();
        updatedSeason.setId(id);
        updatedSeason.setName("Winter");
        updatedSeason.setStartDate(Date.valueOf(LocalDate.of(2024, 12, 1)));
        updatedSeason.setEndDate(Date.valueOf(LocalDate.of(2025, 2, 28)));
        updatedSeason.setMarkup(0.15);

        when(seasonRepository.findById(id)).thenReturn(Optional.of(existingSeason));
        when(seasonRepository.save(Mockito.any(Season.class))).thenReturn(updatedSeason);

        // Test
        Season result = seasonService.updateSeason(id, updatedSeason);

        // Verify
        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals("Winter", result.getName());
        assertEquals(Date.valueOf(LocalDate.of(2024, 12, 1)), result.getStartDate());
        assertEquals(Date.valueOf(LocalDate.of(2025, 2, 28)), result.getEndDate());
        assertEquals(0.15, result.getMarkup());
    }

    @Test
    void deleteSeason() {
        long id = 1L;

        when(seasonRepository.existsById(id)).thenReturn(true);

        // Test
        String result = seasonService.deleteSeason(id);

        // Verify
        assertEquals("deleted", result);
    }
}