package com.hotelmangementsystem.application.entity.search;

import com.hotelmangementsystem.application.entity.Image;

public class SummaryResult {

    private Long hotelId;

    private String hotelName;

    private Image hotelImage;

    private String hotelLocation;

    private Double baseRoomTypePrice;

    private Double discountPercentage;

    private Double markup;

    public SummaryResult() {
    }

    public SummaryResult(Long hotelId, String hotelName, Image hotelImage, String hotelLocation, Double baseRoomTypePrice, Double discountPercentage, Double markup) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.hotelImage = hotelImage;
        this.hotelLocation = hotelLocation;
        this.baseRoomTypePrice = baseRoomTypePrice;
        this.discountPercentage = discountPercentage;
        this.markup = markup;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Image getHotelImage() {
        return hotelImage;
    }

    public void setHotelImage(Image hotelImage) {
        this.hotelImage = hotelImage;
    }

    public String getHotelLocation() {
        return hotelLocation;
    }

    public void setHotelLocation(String hotelLocation) {
        this.hotelLocation = hotelLocation;
    }

    public Double getBaseRoomTypePrice() {
        return baseRoomTypePrice;
    }

    public void setBaseRoomTypePrice(Double baseRoomTypePrice) {
        this.baseRoomTypePrice = baseRoomTypePrice;
    }

    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public Double getMarkup() {
        return markup;
    }

    public void setMarkup(Double markup) {
        this.markup = markup;
    }
}
