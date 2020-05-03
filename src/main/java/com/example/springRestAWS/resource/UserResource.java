package com.example.springRestAWS.resource;

import com.example.springRestAWS.model.User;
import com.example.springRestAWS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// We keep the end-point on the resources
@RestController
@RequestMapping("/api/users")
public class UserResource {

    @Autowired
    UserService userService;

    //POST API /CREATE
    @PostMapping
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    //GET API / View
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    //GET API /View user ID
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable("id") String id){
        return userService.getUserById(id);
    }

    //PUT API / update
    @PutMapping
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    //DELETE API
    @DeleteMapping
    public void deleteUser(@RequestParam(name="userId") String userId){
         userService.deleteUser(userId);
    }


    /*
    @GetMapping("/user")
    public User getUser(){
        return userService.getUser();
    }
     */

}
