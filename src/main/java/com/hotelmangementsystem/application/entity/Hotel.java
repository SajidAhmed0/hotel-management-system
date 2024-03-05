package com.hotelmangementsystem.application.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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

    //TODO: create facility class
    @OneToMany(
            mappedBy = "hotel",
            orphanRemoval = true
    )
    private List<Facility> facilities = new ArrayList<>();

    //TODO: create image class
    @OneToMany(
            mappedBy = "hotel",
            orphanRemoval = true
    )
    private List<Image> images = new ArrayList<>();

    //TODO: create contract, supplements


    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "hotel"
//            orphanRemoval = true
    )
    private List<Contract> contracts = new ArrayList<>();

    public Hotel() {
    }

    public Hotel(String name, String country, String district, String street, String description, String contact) {
        this.name = name;
        this.country = country;
        this.district = district;
        this.street = street;
        this.description = description;
        this.contact = contact;
    }

    public Hotel(Long id, String name, String country, String district, String street, String description, String contact) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.district = district;
        this.street = street;
        this.description = description;
        this.contact = contact;
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

    public List<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<Facility> facilities) {
        this.facilities = facilities;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public void addContract(Contract contract) {
        this.contracts.add(contract);
    }

    public void removeContract(Contract contract){
        this.contracts.remove(contract);
    }

    public void addFacility(Facility facility){
        this.facilities.add(facility);
    }

    public void removeFacility(Facility facility){
        this.facilities.remove(facility);
    }

    public void addImage(Image image){
        this.images.add(image);
    }

    public void removeImage(Image image){
        this.images.remove(image);
    }
}
