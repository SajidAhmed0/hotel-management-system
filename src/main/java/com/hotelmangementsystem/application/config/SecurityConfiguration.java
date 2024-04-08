package com.hotelmangementsystem.application.config;

import com.hotelmangementsystem.application.entity.Role;
import com.hotelmangementsystem.application.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private final JWTAuthenticationFilter jwtAuthenticationFilter;

    private final UserService userService;

    public SecurityConfiguration(JWTAuthenticationFilter jwtAuthenticationFilter, UserService userService) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.userService = userService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> request.requestMatchers("/auth/**")
                        .permitAll()
                        .requestMatchers("/searches/**").permitAll()
                        .requestMatchers("/**").hasAuthority(Role.ADMIN.name())
                        .requestMatchers("/bookings/**").hasAuthority(Role.USER.name())
                        .requestMatchers("/passengers/**").hasAuthority(Role.USER.name())
                        .requestMatchers("/payments/**").hasAuthority(Role.USER.name())
                        .requestMatchers("/bookedroomtypes/**").hasAuthority(Role.USER.name())
                        .requestMatchers("/bookedsupplements/**").hasAuthority(Role.USER.name())
                        .requestMatchers("/bookeddiscounts/**").hasAuthority(Role.USER.name())
                        .requestMatchers("/users/**").hasAuthority(Role.USER.name())
                        .requestMatchers("/roomtypes/**/bookings/**").hasAuthority(Role.USER.name())
                        .anyRequest().authenticated())
                .sessionManagement(manager -> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider()).addFilterBefore(
                        jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class
                );
        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userService.userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config)
        throws Exception {
        return config.getAuthenticationManager();
    }
}
