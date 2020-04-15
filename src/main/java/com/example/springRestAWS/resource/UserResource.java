package com.example.springRestAWS.resource;

import com.example.springRestAWS.model.User;
import com.example.springRestAWS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// We keep the end-point on the resources
@RestController
@RequestMapping("/api")
public class UserResource {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public User getUser(){
        return userService.getUser();
    }
}
