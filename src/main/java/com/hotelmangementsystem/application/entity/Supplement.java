package com.hotelmangementsystem.application.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hotelmangementsystem.application.entity.pricing.SeasonSupplementPricing;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Supplement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    //TODO: create contract and season, hotel

    @JsonIgnore
    @ManyToOne
    @JoinColumn(
            name = "hotel_id",
            referencedColumnName = "id"
    )
    private Hotel hotel;

    @JsonIgnore
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "contract_id",
            referencedColumnName = "id"
    )
    private Contract contract;

    @JsonIgnore
    @OneToMany(
            mappedBy = "supplement"
    )
    private List<SeasonSupplementPricing> seasonSupplementPricings = new ArrayList<>();


    public Supplement() {
    }

    public Supplement(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Supplement(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public List<SeasonSupplementPricing> getSeasonSupplementPricings() {
        return seasonSupplementPricings;
    }

    public void setSeasonSupplementPricings(List<SeasonSupplementPricing> seasonSupplementPricings) {
        this.seasonSupplementPricings = seasonSupplementPricings;
    }

    public void addSeasonSupplementPricing(SeasonSupplementPricing seasonSupplementPricing){
        this.seasonSupplementPricings.add(seasonSupplementPricing);
    }

    public void removeSeasonSupplementPricing(SeasonSupplementPricing seasonSupplementPricing){
        this.seasonSupplementPricings.remove(seasonSupplementPricing);
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
