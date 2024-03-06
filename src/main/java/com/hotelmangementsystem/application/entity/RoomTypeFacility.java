package com.hotelmangementsystem.application.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class RoomTypeFacility {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    @JsonIgnore
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "roomtype_id",
            referencedColumnName = "id"
    )
    private RoomType roomType;

    public RoomTypeFacility() {
    }

    public RoomTypeFacility(String name, String description) {
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }
}
