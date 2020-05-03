package com.example.springRestAWS.repository;

import com.example.springRestAWS.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String>{


}
