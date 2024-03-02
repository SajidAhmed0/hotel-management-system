package com.hotelmangementsystem.application.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.ArrayList;

@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String country;
    private String district;
    private String street;
    private String description;
    private String contact;
    private ArrayList<String> facilities;

    private ArrayList<String> images;

    //TODO: create contract
    public Hotel() {
    }

    public Hotel(Long id, String name, String country, String district, String street, String description, String contact, ArrayList<String> facilities, ArrayList<String> images) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.district = district;
        this.street = street;
        this.description = description;
        this.contact = contact;
        this.facilities = facilities;
        this.images = images;
    }

    public Hotel(String name, String country, String district, String street, String description, String contact, ArrayList<String> facilities, ArrayList<String> images) {
        this.name = name;
        this.country = country;
        this.district = district;
        this.street = street;
        this.description = description;
        this.contact = contact;
        this.facilities = facilities;
        this.images = images;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public ArrayList<String> getFacilities() {
        return facilities;
    }

    public void setFacilities(ArrayList<String> facilities) {
        this.facilities = facilities;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }
}
