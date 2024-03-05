package com.hotelmangementsystem.application.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hotelmangementsystem.application.entity.pricing.SeasonRoomTypePricing;
import com.hotelmangementsystem.application.entity.pricing.SeasonSupplementPricing;
import jakarta.persistence.*;

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


    @JsonIgnore
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "contract_id",
            referencedColumnName = "id"
    )
    private Contract contract;

    @JsonIgnore
    @OneToMany(
            mappedBy = "roomType"
    )
    private List<SeasonRoomTypePricing> seasonRoomTypePricings = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "booked_roomtype",
            joinColumns = @JoinColumn(name = "roomtype_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "booking_id", referencedColumnName = "id")
    )
    private List<Booking> bookings;

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

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
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

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public void addBooking(Booking booking){
        this.bookings.add(booking);
    }

    public void removeBooking(Booking booking){
        this.bookings.remove(booking);
    }
}
