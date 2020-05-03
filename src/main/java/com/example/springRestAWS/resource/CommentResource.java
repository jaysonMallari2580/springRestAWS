package com.example.springRestAWS.resource;

import com.example.springRestAWS.model.Comment;
import com.example.springRestAWS.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comments")
public class CommentResource {

    @Autowired
    CommentService commentService;

    // POST || CREATE
    @PostMapping
    public Comment createComment(@RequestBody Comment comment){
        return commentService.createComment(comment);
    }

    //GET || READ
    @GetMapping
    public List<Comment> getAllCOmments(){
        return commentService.getAllComments();
    }

    @GetMapping("/{commentId}")
    public Optional<Comment> getCommentById(@PathVariable("commentId") String commentId ){
        return commentService.getCommentById(commentId);
    }

    //PUT || UPDATE
    @PutMapping
    public Comment updateComment(@RequestBody Comment comment){
        return commentService.updateComment(comment);
    }

    //DELETE
    public void deleteComment(@RequestParam(name="commentId") String commentId){
        commentService.deleteComment(commentId);
    }
}
