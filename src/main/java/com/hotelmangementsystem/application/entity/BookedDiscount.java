package com.hotelmangementsystem.application.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BookedDiscount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    private Double percentage;

    private Long originalId;

    public BookedDiscount() {
    }

    public BookedDiscount(String name, String description, Double percentage, Long originalId) {
        this.name = name;
        this.description = description;
        this.percentage = percentage;
        this.originalId = originalId;
    }

    public BookedDiscount(Long id, String name, String description, Double percentage, Long originalId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.percentage = percentage;
        this.originalId = originalId;
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

    public Long getOriginalId() {
        return originalId;
    }

    public void setOriginalId(Long originalId) {
        this.originalId = originalId;
    }
}
