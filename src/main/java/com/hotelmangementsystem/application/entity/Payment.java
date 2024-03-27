package com.hotelmangementsystem.application.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date date;

    private Double amount;

    private String method;

    private String cardNumber;

    private String expiration;

    private Integer cvv;

    private String streetAddress;

    private String city;

    private String zipCode;

    //TODO: create user
    @JsonIgnore
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id"
    )
    private User user;

    public Payment() {
    }

    public Payment(Date date, Double amount, String method, String cardNumber, String expiration, Integer cvv, String streetAddress, String city, String zipCode) {
        this.date = date;
        this.amount = amount;
        this.method = method;
        this.cardNumber = cardNumber;
        this.expiration = expiration;
        this.cvv = cvv;
        this.streetAddress = streetAddress;
        this.city = city;
        this.zipCode = zipCode;
    }

    public Payment(Long id, Date date, Double amount, String method, String cardNumber, String expiration, Integer cvv, String streetAddress, String city, String zipCode) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.method = method;
        this.cardNumber = cardNumber;
        this.expiration = expiration;
        this.cvv = cvv;
        this.streetAddress = streetAddress;
        this.city = city;
        this.zipCode = zipCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
