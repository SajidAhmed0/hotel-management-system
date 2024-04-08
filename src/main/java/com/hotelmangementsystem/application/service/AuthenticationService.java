package com.hotelmangementsystem.application.service;


import com.hotelmangementsystem.application.dto.JwtAuthenticationResponse;
import com.hotelmangementsystem.application.dto.SignInRequest;
import com.hotelmangementsystem.application.dto.SignUpRequest;
import com.hotelmangementsystem.application.entity.User;

public interface AuthenticationService {
    public User signup(SignUpRequest signUpRequest);

    public JwtAuthenticationResponse signin(SignInRequest signInRequest);
}
