package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Season;
import com.hotelmangementsystem.application.repository.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SeasonServiceImpl implements SeasonService{

    @Autowired
    private SeasonRepository seasonRepository;

    @Override
    public ArrayList<Season> getAllSeasons() {
        return (ArrayList<Season>) seasonRepository.findAll();
    }

    @Override
    public Season getSeason(Long id) {
        return seasonRepository.findById(id).get();
    }

    @Override
    public Season addSeason(Season season) {
        return seasonRepository.save(season);
    }

    @Override
    public Season updateSeason(Long id, Season season) {
        Season seasonDB = seasonRepository.findById(id).get();
        seasonDB.setName(season.getName());
        return seasonRepository.save(seasonDB);
    }

    @Override
    public String deleteSeason(Long id) {
        seasonRepository.deleteById(id);
        return "deleted";
    }
}
