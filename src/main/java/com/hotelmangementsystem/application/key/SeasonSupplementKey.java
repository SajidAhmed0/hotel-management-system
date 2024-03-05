package com.hotelmangementsystem.application.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SeasonSupplementKey implements Serializable {

    @Column(name = "season_id")
    private Long seasonId;

    @Column(name = "supplementId")
    private Long supplementId;

    public SeasonSupplementKey() {
    }

    public SeasonSupplementKey(Long seasonId, Long supplementId) {
        this.seasonId = seasonId;
        this.supplementId = supplementId;
    }

    public Long getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(Long seasonId) {
        this.seasonId = seasonId;
    }

    public Long getSupplementId() {
        return supplementId;
    }

    public void setSupplementId(Long supplementId) {
        this.supplementId = supplementId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeasonSupplementKey that = (SeasonSupplementKey) o;
        return Objects.equals(seasonId, that.seasonId) && Objects.equals(supplementId, that.supplementId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seasonId, supplementId);
    }
}
