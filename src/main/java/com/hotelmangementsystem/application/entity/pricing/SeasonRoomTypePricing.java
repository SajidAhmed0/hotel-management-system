package com.hotelmangementsystem.application.entity.pricing;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hotelmangementsystem.application.entity.Contract;
import com.hotelmangementsystem.application.entity.RoomType;
import com.hotelmangementsystem.application.entity.Season;
import com.hotelmangementsystem.application.key.SeasonRoomTypeKey;
import jakarta.persistence.*;

@Entity
public class SeasonRoomTypePricing {

    @EmbeddedId
    private SeasonRoomTypeKey id;

    @JsonIgnore
    @ManyToOne
    @MapsId("seasonId")
    @JoinColumn(name = "season_id")
    private Season season;

    @JsonIgnore
    @ManyToOne
    @MapsId("roomTypeId")
    @JoinColumn(name = "roomtype_id")
    private RoomType roomType;

    @JsonIgnore
    @ManyToOne
    @MapsId("contractId")
    @JoinColumn(
            name = "contract_id"
    )
    private Contract contract;

    private Double price;

    public SeasonRoomTypePricing() {
    }

    public SeasonRoomTypePricing(Season season, RoomType roomType, Double price) {
        this.season = season;
        this.roomType = roomType;
        this.price = price;
    }

    public SeasonRoomTypePricing(SeasonRoomTypeKey id, Season season, RoomType roomType, Double price) {
        this.id = id;
        this.season = season;
        this.roomType = roomType;
        this.price = price;
    }

    public SeasonRoomTypeKey getId() {
        return id;
    }

    public void setId(SeasonRoomTypeKey id) {
        this.id = id;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
