package com.hotelmangementsystem.application.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date startDate;

    private Date endDate;

    private String cancellationPolicy;

    private String paymentPolicy;

    //TODO: hotel entity, discounts, roomTypes, seasons

    @JsonIgnore
    @ManyToOne
    @JoinColumn(
            name = "hotel_id",
            referencedColumnName = "id"
    )
    private Hotel hotel;

    @OneToMany(
            mappedBy = "contract",
            fetch = FetchType.LAZY
    )
    private List<Supplement> supplements = new ArrayList<>();


    @OneToMany(
            mappedBy = "contract",
            fetch = FetchType.LAZY
    )
    private List<Season> seasons = new ArrayList<>();


    @OneToMany(
            mappedBy = "contract",
            fetch = FetchType.LAZY
    )
    private List<RoomType> roomTypes = new ArrayList<>();


    @OneToMany(
            mappedBy = "contract",
            fetch = FetchType.LAZY
    )
    private List<Discount> discounts = new ArrayList<>();

    public Contract() {
    }

    public Contract(Date startDate, Date endDate, String cancellationPolicy, String paymentPolicy) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.cancellationPolicy = cancellationPolicy;
        this.paymentPolicy = paymentPolicy;
    }

    public Contract(Long id, Date startDate, Date endDate, String cancellationPolicy, String paymentPolicy) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cancellationPolicy = cancellationPolicy;
        this.paymentPolicy = paymentPolicy;
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

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<Supplement> getSupplements() {
        return supplements;
    }

    public void setSupplements(List<Supplement> supplements) {
        this.supplements = supplements;
    }

    public List<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
    }

    public List<RoomType> getRoomTypes() {
        return roomTypes;
    }

    public void setRoomTypes(List<RoomType> roomTypes) {
        this.roomTypes = roomTypes;
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<Discount> discounts) {
        this.discounts = discounts;
    }

    public void addSupplement(Supplement supplement){
        this.supplements.add(supplement);
    }
    public void removeSupplement(Supplement supplement){
        this.supplements.remove(supplement);
    }

    public void addSeason(Season season){
        this.seasons.add(season);
    }
    public void removeSeason(Season season){
        this.seasons.remove(season);
    }

    public void addRoomType(RoomType roomType){
        this.roomTypes.add(roomType);
    }
    public void removeRoomType(RoomType roomType){
        this.roomTypes.remove(roomType);
    }

    public void addDiscount(Discount discount){
        this.discounts.add(discount);
    }
    public void removeDiscount(Discount discount){
        this.discounts.remove(discount);
    }
}
