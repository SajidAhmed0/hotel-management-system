package com.hotelmangementsystem.application.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    private Double percentage;

    private Integer daysPriorToArrival;

    //TODO: create contract and bookings

    @JsonIgnore
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "contract_id",
            referencedColumnName = "id"
    )
    private Contract contract;

    public Discount() {
    }

    public Discount(String name, String description, Double percentage, Integer daysPriorToArrival) {
        this.name = name;
        this.description = description;
        this.percentage = percentage;
        this.daysPriorToArrival = daysPriorToArrival;
    }

    public Discount(Long id, String name, String description, Double percentage, Integer daysPriorToArrival) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.percentage = percentage;
        this.daysPriorToArrival = daysPriorToArrival;
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

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Integer getDaysPriorToArrival() {
        return daysPriorToArrival;
    }

    public void setDaysPriorToArrival(Integer daysPriorToArrival) {
        this.daysPriorToArrival = daysPriorToArrival;
    }
}
