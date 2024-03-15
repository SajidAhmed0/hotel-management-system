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

    @Column(name = "contract_id")
    private Long contractId;

    public SeasonRoomTypeKey() {
    }

    public SeasonRoomTypeKey(Long seasonId, Long roomTypeId, Long contractId) {
        this.seasonId = seasonId;
        this.roomTypeId = roomTypeId;
        this.contractId = contractId;
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

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
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
