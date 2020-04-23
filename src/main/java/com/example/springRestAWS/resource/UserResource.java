package com.example.springRestAWS.resource;

import com.example.springRestAWS.model.User;
import com.example.springRestAWS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //POST API /CREATE
    @PostMapping("/user")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    //GET API / View
    @GetMapping("/allUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    //GET API /View user ID
    @GetMapping("/user/{userId}")
    public User getUserById(@PathVariable("userId") int userId){
        return userService.getUserById(userId);
    }

    //PUT API / update
    @PutMapping("/user/{userId}")
    public User updateUser(@PathVariable("userId") int userId, @RequestBody User user){
        return userService.updateUser(userId, user);
    }

    //DELETE API
    @DeleteMapping("/user")
    public User deleteUser(@RequestParam(name="userId") int userId){
        return userService.deleteUser(userId);
    }

}
