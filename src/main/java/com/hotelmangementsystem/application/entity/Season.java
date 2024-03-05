package com.hotelmangementsystem.application.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hotelmangementsystem.application.entity.pricing.SeasonRoomTypePricing;
import com.hotelmangementsystem.application.entity.pricing.SeasonSupplementPricing;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Date startDate;

    private Date endDate;

    //TODO: create supplements and contracts

    @JsonIgnore
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "contract_id",
            referencedColumnName = "id"
    )
    private Contract contract;

    @OneToMany(
            mappedBy = "season"
    )
    private List<SeasonSupplementPricing> seasonSupplementPricings = new ArrayList<>();

    @OneToMany(
            mappedBy = "season"
    )
    private List<SeasonRoomTypePricing> seasonRoomTypePricings = new ArrayList<>();

    public Season() {
    }

    public Season(String name, Date startDate, Date endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Season(Long id, String name, Date startDate, Date endDate) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    public List<SeasonRoomTypePricing> getSeasonRoomTypePricings() {
        return seasonRoomTypePricings;
    }

    public void setSeasonRoomTypePricings(List<SeasonRoomTypePricing> seasonRoomTypePricings) {
        this.seasonRoomTypePricings = seasonRoomTypePricings;
    }

    public void addSeasonRoomTypePricing(SeasonRoomTypePricing seasonRoomTypePricing){
        this.seasonRoomTypePricings.add(seasonRoomTypePricing);
    }

    public void removeSeasonRoomTypePricing(SeasonRoomTypePricing seasonRoomTypePricing){
        this.seasonRoomTypePricings.remove(seasonRoomTypePricing);
    }
}
