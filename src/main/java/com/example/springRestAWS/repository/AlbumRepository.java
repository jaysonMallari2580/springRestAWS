package com.example.springRestAWS.repository;

import com.example.springRestAWS.model.Album;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlbumRepository extends MongoRepository<Album, String> {
}
