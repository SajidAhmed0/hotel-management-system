package com.hotelmangementsystem.application.dto;


import com.hotelmangementsystem.application.entity.User;

public class JwtAuthenticationResponse {
    private String token;

    private User user;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
