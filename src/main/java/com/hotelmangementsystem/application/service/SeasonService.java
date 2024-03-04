package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Season;

import java.util.ArrayList;
import java.util.List;

public interface SeasonService {
    public List<Season> getAllSeasons();

    public Season getSeason(Long id);

    public Season addSeason(Season season);

    public Season updateSeason(Long id, Season season);

    public String deleteSeason(Long id);
}
