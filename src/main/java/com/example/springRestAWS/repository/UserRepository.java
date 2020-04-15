package com.example.springRestAWS.repository;

import com.example.springRestAWS.model.User;
import org.springframework.stereotype.Repository;

// We keep the Data related on the Repository.
@Repository
public class UserRepository {

    public User getUser(){
        User user = new User("Jayson Mallari","4731 216th Bayside NY",19,"url://pic.com");
        return user;
    }
}
