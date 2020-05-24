package com.example.springRestAWS.model;

import com.example.springRestAWS.validation.ValidName;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class User {
    @Id
    private String id;
    @NotEmpty @ValidName
    private String name;
    @Length(max=10) @NotEmpty @ValidName
    private String address;
    @Min(value=13) @Max(value=150)
    private int age;
    private String profilePicUrl;
    @Email
    private String email;

    public User(String id,String name, String address, int age, String profilePicUrl, String email) {
        this.id=id;
        this.name = name;
        this.address = address;
        this.age = age;
        this.profilePicUrl = profilePicUrl;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProfilePicUrl() {
        return profilePicUrl;
    }

    public void setProfilePicUrl(String profilePicUrl) {
        this.profilePicUrl = profilePicUrl;
    }
}
