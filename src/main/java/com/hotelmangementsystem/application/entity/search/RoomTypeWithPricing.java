package com.hotelmangementsystem.application.entity.search;

import com.hotelmangementsystem.application.entity.RoomType;
import com.hotelmangementsystem.application.entity.pricing.SeasonRoomTypePricing;

public class RoomTypeWithPricing {

    private RoomType roomType;

    private SeasonRoomTypePricing pricing;

    private Integer avialableRooms;

    public RoomTypeWithPricing() {
    }

    public RoomTypeWithPricing(RoomType roomType, SeasonRoomTypePricing pricing, Integer avialableRooms) {
        this.roomType = roomType;
        this.pricing = pricing;
        this.avialableRooms = avialableRooms;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public SeasonRoomTypePricing getPricing() {
        return pricing;
    }

    public void setPricing(SeasonRoomTypePricing pricing) {
        this.pricing = pricing;
    }

    public Integer getAvialableRooms() {
        return avialableRooms;
    }

    public void setAvialableRooms(Integer avialableRooms) {
        this.avialableRooms = avialableRooms;
    }
}
