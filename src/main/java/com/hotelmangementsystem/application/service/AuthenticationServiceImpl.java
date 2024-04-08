package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.dto.JwtAuthenticationResponse;
import com.hotelmangementsystem.application.dto.SignInRequest;
import com.hotelmangementsystem.application.dto.SignUpRequest;
import com.hotelmangementsystem.application.entity.Role;
import com.hotelmangementsystem.application.entity.User;
import com.hotelmangementsystem.application.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JWTService jwtService;

    public AuthenticationServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JWTService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public User signup(SignUpRequest signUpRequest){
        User user = new User();

        user.setId(signUpRequest.getId());
        user.setFirstName(signUpRequest.getFirstName());
        user.setLastName(signUpRequest.getLastName());
        user.setEmail(signUpRequest.getEmail());
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        return userRepository.save(user);
    }

    public JwtAuthenticationResponse signin(SignInRequest signInRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getEmail(),
                signInRequest.getPassword()));

        User user = userRepository.findUserByEmail(signInRequest.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));

        var jwt = jwtService.generateToken(user);

        JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();

        jwtAuthenticationResponse.setToken(jwt);
        jwtAuthenticationResponse.setUser(user);
        return jwtAuthenticationResponse;
    }

}
