package com.example.springRestAWS.resource;

import com.example.springRestAWS.exception.RestrictedInfoException;
import com.example.springRestAWS.model.FirebaseUser;
import com.example.springRestAWS.model.User;
import com.example.springRestAWS.service.FirebaseService;
import com.example.springRestAWS.service.UserService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

// We keep the end-point on the resources
@RestController
@RequestMapping("/api/users")
public class UserResource {

    @Autowired
    UserService userService;

    @Autowired
    FirebaseService firebaseService;

    //POST API /CREATE
    @PostMapping
    public User saveUser(@RequestBody User user,@RequestHeader(name="idToken")String idToken) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if(firebaseUser != null) {
            return userService.saveUser(user);
        }else{
            return null;
        }
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
    public User updateUser(@RequestBody User user,@RequestHeader(name="idToken")String idToken) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if (firebaseUser != null){
            return userService.updateUser(user);
        }else{
            return null;
        }
    }

    //DELETE API
    @DeleteMapping
    public void deleteUser(@RequestParam(name="userId") String userId, @RequestHeader(name="idToken") String idToken) throws IOException, FirebaseAuthException {
         FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
         if(firebaseUser != null) {
             userService.deleteUser(userId);
         }
    }


    /*
    @GetMapping("/user")
    public User getUser(){
        return userService.getUser();
    }
     */

}
