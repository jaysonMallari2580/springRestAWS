package com.example.springRestAWS.resource;

import com.example.springRestAWS.exception.RestrictedInfoException;
import com.example.springRestAWS.model.User;
import com.example.springRestAWS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

// We keep the end-point on the resources
@RestController
@RequestMapping("/api/users")
public class UserResource {

    @Autowired
    UserService userService;

    //POST API /CREATE
    @PostMapping
    public User saveUser(@RequestBody @Valid User user){
        return userService.saveUser(user);
    }

    //GET API / View
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    //GET API /View user ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") String id){
        return userService.getUserById(id);
    }

    //if user is root create a custom exception
    @GetMapping("/find-name")
    public List<User> getByName(@RequestParam(name="name")String name) throws RestrictedInfoException{
        if(name.equalsIgnoreCase("root")){
            throw new RestrictedInfoException();
        }
        return userService.getByName(name);
    }

    /*address ex
    @GetMapping("/find")
    public List<User> getByAddress(@RequestParam("address") String address) throws RestrictedInfoException{
        if(address.equalsIgnoreCase("area51")){
            throw new RestrictedInfoException();
        }
        return userService.getByAddress(address);
    }
     */

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
