package com.hotelmangementsystem.application.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Date;

@Entity
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date startDate;

    private Date endDate;

    private String cancellationPolicy;

    private String paymentPolicy;

    private Double markup;

    //TODO: hotel entity, discounts, roomTypes, seasons


    public Contract() {
    }

    public Contract(Date startDate, Date endDate, String cancellationPolicy, String paymentPolicy, Double markup) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.cancellationPolicy = cancellationPolicy;
        this.paymentPolicy = paymentPolicy;
        this.markup = markup;
    }

    public Contract(Long id, Date startDate, Date endDate, String cancellationPolicy, String paymentPolicy, Double markup) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cancellationPolicy = cancellationPolicy;
        this.paymentPolicy = paymentPolicy;
        this.markup = markup;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCancellationPolicy() {
        return cancellationPolicy;
    }

    public void setCancellationPolicy(String cancellationPolicy) {
        this.cancellationPolicy = cancellationPolicy;
    }

    public String getPaymentPolicy() {
        return paymentPolicy;
    }

    public void setPaymentPolicy(String paymentPolicy) {
        this.paymentPolicy = paymentPolicy;
    }

    public Double getMarkup() {
        return markup;
    }

    public void setMarkup(Double markup) {
        this.markup = markup;
    }
}
