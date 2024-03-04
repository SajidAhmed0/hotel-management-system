package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.User;

import java.util.ArrayList;
import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public User getUser(Long id);

    public User addUser(User user);

    public User updateUser(Long id, User user);

    public String deleteUser(Long id);
}
