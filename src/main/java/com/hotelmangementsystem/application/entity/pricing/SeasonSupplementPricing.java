package com.hotelmangementsystem.application.entity.pricing;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hotelmangementsystem.application.entity.Contract;
import com.hotelmangementsystem.application.entity.Season;
import com.hotelmangementsystem.application.entity.Supplement;
import com.hotelmangementsystem.application.key.SeasonSupplementKey;
import jakarta.persistence.*;

@Entity
public class SeasonSupplementPricing {
    @EmbeddedId
    private SeasonSupplementKey id;

    @JsonIgnore
    @ManyToOne
    @MapsId("seasonId")
    @JoinColumn(name = "season_id")
    private Season season;

    @JsonIgnore
    @ManyToOne
    @MapsId("supplementId")
    @JoinColumn(name = "supplement_id")
    private Supplement supplement;

    @JsonIgnore
    @ManyToOne
    @MapsId("contractId")
    @JoinColumn(
            name = "contract_id"
    )
    private Contract contract;

    private Double price;

    public SeasonSupplementPricing() {
    }

    public SeasonSupplementPricing(Season season, Supplement supplement, Contract contract, Double price) {
        this.season = season;
        this.supplement = supplement;
        this.price = price;
        this.contract = contract;
    }

    public SeasonSupplementPricing(SeasonSupplementKey id, Season season, Supplement supplement, Contract contract, Double price) {
        this.id = id;
        this.season = season;
        this.supplement = supplement;
        this.price = price;
        this.contract = contract;
    }

    public SeasonSupplementKey getId() {
        return id;
    }

    public void setId(SeasonSupplementKey id) {
        this.id = id;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Supplement getSupplement() {
        return supplement;
    }

    public void setSupplement(Supplement supplement) {
        this.supplement = supplement;
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
