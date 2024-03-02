package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.User;
import com.hotelmangementsystem.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public ArrayList<User> getAllUsers() {
        return (ArrayList<User>) userRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        User userDB = userRepository.findById(id).get();
        userDB.setCountry(user.getCountry());
        return userRepository.save(userDB);
    }

    @Override
    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "deleted";
    }
}
