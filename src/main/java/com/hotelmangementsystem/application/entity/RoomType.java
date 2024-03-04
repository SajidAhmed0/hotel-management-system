package com.hotelmangementsystem.application.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
public class RoomType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Integer noOfRooms;

    private Integer maxAdult;

    private String description;

    private List<String> facilities;

    private Double price;

    //TODO: create season and contract

    public RoomType() {
    }

    public RoomType(String name, Integer noOfRooms, Integer maxAdult, String description, List<String> facilities, Double price) {
        this.name = name;
        this.noOfRooms = noOfRooms;
        this.maxAdult = maxAdult;
        this.description = description;
        this.facilities = facilities;
        this.price = price;
    }

    public RoomType(Long id, String name, Integer noOfRooms, Integer maxAdult, String description, List<String> facilities, Double price) {
        this.id = id;
        this.name = name;
        this.noOfRooms = noOfRooms;
        this.maxAdult = maxAdult;
        this.description = description;
        this.facilities = facilities;
        this.price = price;
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

    public Integer getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(Integer noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public Integer getMaxAdult() {
        return maxAdult;
    }

    public void setMaxAdult(Integer maxAdult) {
        this.maxAdult = maxAdult;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<String> facilities) {
        this.facilities = facilities;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
