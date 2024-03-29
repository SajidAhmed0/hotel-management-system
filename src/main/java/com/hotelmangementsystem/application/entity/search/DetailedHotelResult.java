package com.hotelmangementsystem.application.entity.search;

import com.hotelmangementsystem.application.entity.Contract;
import com.hotelmangementsystem.application.entity.Discount;
import com.hotelmangementsystem.application.entity.Hotel;
import com.hotelmangementsystem.application.entity.Season;

import java.util.List;

public class DetailedHotelResult {

    private Hotel hotel;

    private Contract contract;

    private Season season;

    private List<RoomTypeWithPricing> roomTypeWithPricings;

    private List<SupplementWithPricing> supplementWithPricings;

    private Discount discount;

    private Double markup;

    public DetailedHotelResult() {
    }

    public DetailedHotelResult(Hotel hotel, Contract contract, Season season, List<RoomTypeWithPricing> roomTypeWithPricings, List<SupplementWithPricing> supplementWithPricings, Discount discount, Double markup) {
        this.hotel = hotel;
        this.contract = contract;
        this.season = season;
        this.roomTypeWithPricings = roomTypeWithPricings;
        this.supplementWithPricings = supplementWithPricings;
        this.discount = discount;
        this.markup = markup;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public List<RoomTypeWithPricing> getRoomTypeWithPricings() {
        return roomTypeWithPricings;
    }

    public void setRoomTypeWithPricings(List<RoomTypeWithPricing> roomTypeWithPricings) {
        this.roomTypeWithPricings = roomTypeWithPricings;
    }

    public List<SupplementWithPricing> getSupplementWithPricings() {
        return supplementWithPricings;
    }

    public void setSupplementWithPricings(List<SupplementWithPricing> supplementWithPricings) {
        this.supplementWithPricings = supplementWithPricings;
    }

    public void addRoomTypeWithPricing(RoomTypeWithPricing roomTypeWithPricing){
        this.roomTypeWithPricings.add(roomTypeWithPricing);
    }

    public void removeRoomTypeWithPricing(RoomTypeWithPricing roomTypeWithPricing){
        this.roomTypeWithPricings.remove(roomTypeWithPricing);
    }

    public void addSupplementWithPricing(SupplementWithPricing supplementWithPricing){
        this.supplementWithPricings.add(supplementWithPricing);
    }

    public void removeSupplementWithPricing(SupplementWithPricing supplementWithPricing){
        this.supplementWithPricings.remove(supplementWithPricing);
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public Double getMarkup() {
        return markup;
    }

    public void setMarkup(Double markup) {
        this.markup = markup;
    }
}
