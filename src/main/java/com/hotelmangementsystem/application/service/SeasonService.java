package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Season;

import java.util.ArrayList;

public interface SeasonService {
    public ArrayList<Season> getAllSeasons();

    public Season getSeason(Long id);

    public Season addSeason(Season season);

    public Season updateSeason(Long id, Season season);

    public String deleteSeason(Long id);
}
