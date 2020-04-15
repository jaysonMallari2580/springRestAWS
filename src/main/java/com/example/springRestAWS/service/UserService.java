package com.example.springRestAWS.service;

import com.example.springRestAWS.model.User;
import com.example.springRestAWS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// We keep the Business Logic on the Service
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUser(){
       return userRepository.getUser();
    }
}
