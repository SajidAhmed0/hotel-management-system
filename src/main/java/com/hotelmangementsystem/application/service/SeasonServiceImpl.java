package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Season;
import com.hotelmangementsystem.application.repository.SeasonRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeasonServiceImpl implements SeasonService{

    @Autowired
    private SeasonRepository seasonRepository;

    @Override
    public List<Season> getAllSeasons() {
        return seasonRepository.findAll();
    }

    @Override
    public Season getSeason(Long id) {
        return seasonRepository.findById(id).orElse(null);
    }

    @Override
    public Season addSeason(Season season) {
        return seasonRepository.save(season);
    }

    @Override
    public Season updateSeason(Long id, Season season) {
        Season seasonDB = seasonRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Season with id " + id + " does not exists"));

        if(season != null){
            seasonDB.setName(season.getName());
            seasonDB.setStartDate(season.getStartDate());
            seasonDB.setEndDate(season.getEndDate());
            seasonDB.setMarkup(season.getMarkup());
            return seasonRepository.save(seasonDB);
        }
        return null;

    }

    @Override
    public String deleteSeason(Long id) {
        boolean exists = seasonRepository.existsById(id);
        if(!exists) {
            throw new EntityNotFoundException("Season with id " + id + " does not exists");
        }
        seasonRepository.deleteById(id);
        return "deleted";
    }
}
