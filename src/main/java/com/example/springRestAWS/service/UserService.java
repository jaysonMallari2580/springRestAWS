package com.example.springRestAWS.service;

import com.example.springRestAWS.model.User;
import com.example.springRestAWS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// We keep the Business Logic on the Service
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUser(){
       return userRepository.getUser();
    }

    //POST/CREATE
    public User saveUser(User user) {
        return userRepository.saveUser(user);
    }

    //GET  / view all users list
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    //GET / view user by id
    public User getUserById(int userId) {
        return userRepository.getUserById(userId);
    }

    // PUT /Update user body of the matching user id
    public User updateUser(int userId, User user) {
        return userRepository.updateUser(userId, user);
    }

    //DELETE
    public User deleteUser(int userId) {
        return userRepository.deleteUser(userId);
    }
}
