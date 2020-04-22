package com.example.springRestAWS.repository;

import com.example.springRestAWS.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

// We keep the Data related on the Repository.
@Repository
public class UserRepository {

    List<User> userList = new ArrayList();

    public User getUser(){
        User user = new User("Jayson Mallari","4731 216th Bayside NY",19,"url://pic.com");
        return user;
    }

    //POST/CREATE
    public User saveUser(User user) {
        user.setUserId(userList.size() + 1);
        userList.add(user);
        return user;
    }

    //GET /view all users list
    public List<User> getAllUsers() {
        return userList;
    }

    //GET /view user by id
    public User getUserById(int userId) {
        for(User user: userList){
            if(user.getUserId() == userId){
                return user;
            }
        }
        return null;
    }

    // PUT / update the user body of the matching user id
    public User updateUser(int userId, User user) {
        for(User u: userList){
            if(u.getUserId() == userId){
                u.setName(user.getName());
                u.setAddress(user.getAddress());
                u.setAge(user.getAge());
                return u;
            }
        }
        return null;
    }

    //DELETE
    public User deleteUser(int userId) {
        User deletedUser = null;
        for(User u: userList){
            if(u.getUserId() == userId){
                deletedUser = u;
                userList.remove(u);
                return deletedUser;
            }
        }
        return deletedUser;
    }
}
