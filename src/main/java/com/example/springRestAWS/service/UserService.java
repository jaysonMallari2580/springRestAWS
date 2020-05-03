package com.example.springRestAWS.service;

import com.example.springRestAWS.model.User;
import com.example.springRestAWS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

// We keep the Business Logic on the Service
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    //POST/CREATE
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    //GET  / view all users list
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    //GET / view user by id
    public Optional<User> getUserById(String id) {
         return userRepository.findById(id);
    }

    // PUT /Update user body of the matching user id
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    //DELETE
    public void deleteUser(String userId) {
         userRepository.deleteById(userId);
    }

    /*
    public User getUser(){
       return userRepository.getUser();
    }
     */
}
