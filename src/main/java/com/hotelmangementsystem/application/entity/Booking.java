package com.hotelmangementsystem.application.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date checkInDate;

    private Date checkOutDate;

    private Integer noOfAdult;

    private String Status;

    private Integer noOfRooms;

    private Double total;

    private Date bookingDate;

    private Double markup;

    private String hotelName;

    private Long hotelId;

    //TODO: create discounts, bookedprices, and passengers
    @OneToMany(
            mappedBy = "booking",
            fetch = FetchType.LAZY
    )
    private List<BookedPrice> bookedPrices = new ArrayList<>();

    @OneToOne(
            mappedBy = "booking",
            fetch = FetchType.LAZY
    )
    private BookedRoomType bookedRoomType;

    @OneToMany(
            mappedBy = "booking",
            fetch = FetchType.LAZY
    )
    private List<BookedDiscount> bookedDiscounts = new ArrayList<>();

    @OneToMany(
            mappedBy = "booking",
            fetch = FetchType.LAZY
    )
    private List<BookedSupplement> bookedSupplements = new ArrayList<>();

    @OneToMany(
            mappedBy = "booking",
            fetch = FetchType.LAZY
    )
    private List<Passenger> passengers = new ArrayList<>();

    @JsonIgnore
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id"
    )
    private User user;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(
            name = "roomtype_id",
            referencedColumnName = "id"
    )
    private RoomType roomType;

    public Booking() {
    }

    public Booking(Date checkInDate, Date checkOutDate, Integer noOfAdult, String status, Double total, Integer noOfRooms, Date bookingDate, Double markup, String hotelName, Long hotelId) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.noOfAdult = noOfAdult;
        Status = status;
        this.total = total;
        this.noOfRooms = noOfRooms;
        this.bookingDate = bookingDate;
        this.markup = markup;
        this.hotelName = hotelName;
        this.hotelId = hotelId;
    }

    public Booking(Long id, Date checkInDate, Date checkOutDate, Integer noOfAdult, String status, Double total, Integer noOfRooms, Date bookingDate, Double markup, String hotelName, Long hotelId) {
        this.id = id;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.noOfAdult = noOfAdult;
        Status = status;
        this.total = total;
        this.noOfRooms = noOfRooms;
        this.bookingDate = bookingDate;
        this.markup = markup;
        this.hotelName = hotelName;
        this.hotelId = hotelId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Integer getNoOfAdult() {
        return noOfAdult;
    }

    public void setNoOfAdult(Integer noOfAdult) {
        this.noOfAdult = noOfAdult;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<BookedPrice> getBookedPrices() {
        return bookedPrices;
    }

    public void setBookedPrices(List<BookedPrice> bookedPrices) {
        this.bookedPrices = bookedPrices;
    }

    public void addBookedPrice(BookedPrice bookedPrice){
        this.bookedPrices.add(bookedPrice);
    }

    public void removeBookedPrice(BookedPrice bookedPrice){
        this.bookedPrices.remove(bookedPrice);
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public void addPassenger(Passenger passenger){
        this.passengers.add(passenger);
    }

    public void removePassenger(Passenger passenger){
        this.passengers.remove(passenger);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(Integer noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public List<BookedSupplement> getBookedSupplements() {
        return bookedSupplements;
    }

    public void setBookedSupplements(List<BookedSupplement> bookedSupplements) {
        this.bookedSupplements = bookedSupplements;
    }

    public void addBookedSupplement(BookedSupplement bookedSupplement){
        this.bookedSupplements.add(bookedSupplement);
    }

    public void removeBookedSupplement(BookedSupplement bookedSupplement){
        this.bookedSupplements.remove(bookedSupplement);
    }

    public List<BookedDiscount> getBookedDiscounts() {
        return bookedDiscounts;
    }

    public void setBookedDiscounts(List<BookedDiscount> bookedDiscounts) {
        this.bookedDiscounts = bookedDiscounts;
    }

    public void addBookedDiscount(BookedDiscount bookedDiscount){
        this.bookedDiscounts.add(bookedDiscount);
    }

    public void removeBookedDiscount(BookedDiscount bookedDiscount){
        this.bookedDiscounts.remove(bookedDiscount);
    }

    public BookedRoomType getBookedRoomType() {
        return bookedRoomType;
    }

    public void setBookedRoomType(BookedRoomType bookedRoomType) {
        this.bookedRoomType = bookedRoomType;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Double getMarkup() {
        return markup;
    }

    public void setMarkup(Double markup) {
        this.markup = markup;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }
}
