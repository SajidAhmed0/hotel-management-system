package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.User;
import com.hotelmangementsystem.application.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

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
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User addUser(User user) {
        Optional<User> userByEmail = userRepository.findUserByEmail(user.getEmail());
        if(userByEmail.isPresent()){
            throw new IllegalStateException("Email exists");
        }

        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        User userDB = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User with id " + id + " does not exists"));

        if(user != null){
            userDB.setFirstName(user.getFirstName());
            userDB.setLastName(user.getLastName());
            userDB.setEmail(user.getEmail());
            userDB.setPassword(user.getPassword());
            userDB.setPhone(user.getPhone());
            userDB.setCountry(user.getCountry());
            userDB.setDistrict(user.getDistrict());
            userDB.setStreet(user.getStreet());
            return userRepository.save(userDB);
        }
        return null;

    }

    @Override
    public String deleteUser(Long id) {
        boolean exists = userRepository.existsById(id);
        if(!exists){
            throw new EntityNotFoundException("User with id " + id + " does not exists");
        }
        userRepository.deleteById(id);
        return "deleted";
    }
}
