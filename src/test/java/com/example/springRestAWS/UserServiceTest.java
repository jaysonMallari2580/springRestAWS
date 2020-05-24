package com.example.springRestAWS;

import com.example.springRestAWS.model.User;
import com.example.springRestAWS.service.UserService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Before
    public void saveUser(){
        userService.saveUser(new User("1","Jayson","USA",34,"www.pic.com/pic1","jayson@gmh.com"));
    }

    @Test
    public void getUser(){
        User user = userService.getUserById("1");
        Assert.assertEquals("Jayson",user.getName());
    }

    @Test
    public void editUser(){
        User user = userService.getUserById("1");
        user.setName("Rj");
        userService.saveUser(user);
        Assert.assertEquals("Rj","Rj");
    }

    @After
    public void deleteUser(){
        userService.deleteUser("1");
    }
}
