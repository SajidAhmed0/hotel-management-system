package com.hotelmangementsystem.application.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SeasonRoomTypeKey implements Serializable {

    @Column(name = "season_id")
    private Long seasonId;

    @Column(name = "roomtype_id")
    private Long roomTypeId;

    public SeasonRoomTypeKey() {
    }

    public SeasonRoomTypeKey(Long seasonId, Long roomTypeId) {
        this.seasonId = seasonId;
        this.roomTypeId = roomTypeId;
    }

    public Long getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(Long seasonId) {
        this.seasonId = seasonId;
    }

    public Long getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Long roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeasonRoomTypeKey that = (SeasonRoomTypeKey) o;
        return Objects.equals(seasonId, that.seasonId) && Objects.equals(roomTypeId, that.roomTypeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seasonId, roomTypeId);
    }
}
