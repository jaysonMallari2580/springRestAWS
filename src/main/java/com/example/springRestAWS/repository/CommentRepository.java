package com.example.springRestAWS.repository;

import com.example.springRestAWS.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment, String> {
}
