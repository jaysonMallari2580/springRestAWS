package com.example.springRestAWS.resource;

import com.example.springRestAWS.model.Comment;
import com.example.springRestAWS.model.FirebaseUser;
import com.example.springRestAWS.service.CommentService;
import com.example.springRestAWS.service.FirebaseService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comments")
public class CommentResource {

    @Autowired
    CommentService commentService;

    @Autowired
    FirebaseService firebaseService;

    // POST || CREATE
    @PostMapping
    public Comment createComment(@RequestBody @Valid Comment comment, @RequestHeader(name="idToken")String idToken,
                                 @RequestHeader(name="commentCreatedBy")String commentCreatedBy)
                                throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
            if(firebaseUser != null && firebaseUser.getEmail() == commentCreatedBy){
                return commentService.createComment(comment);
            }else{
                return null;
            }
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
    public Comment updateComment(@RequestBody Comment comment, @RequestHeader(name="idToken")String idToken,
    @RequestHeader(name="commentCreatedBy")String commentCreatedBy) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
            if(firebaseUser != null && firebaseUser.getEmail() == commentCreatedBy){
                return commentService.updateComment(comment);
            }else{
                return null;
            }
    }

    //DELETE
    @DeleteMapping
    public void deleteComment(@RequestParam(name="commentId") String commentId,@RequestHeader(name="idToken")String idToken,
                              @RequestHeader(name="commentCreatedBy")String commentCreatedBy) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
            if(firebaseUser != null && firebaseUser.getEmail() == commentCreatedBy){
                commentService.deleteComment(commentId);
            }

    }
}
