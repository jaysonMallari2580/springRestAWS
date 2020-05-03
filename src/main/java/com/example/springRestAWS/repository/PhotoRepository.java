package com.example.springRestAWS.repository;

import com.example.springRestAWS.model.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PhotoRepository extends MongoRepository<Photo, String> {
}
