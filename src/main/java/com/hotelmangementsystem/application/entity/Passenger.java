package com.hotelmangementsystem.application.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String phone;

    private String name;

    //TODO: create booking


    public Passenger() {
    }

    public Passenger(String phone, String name) {
        this.phone = phone;
        this.name = name;
    }

    public Passenger(Long id, String phone, String name) {
        this.id = id;
        this.phone = phone;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
