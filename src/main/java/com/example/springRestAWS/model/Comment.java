package com.example.springRestAWS.model;

import com.example.springRestAWS.validation.ValidCreatedBy;

import javax.validation.constraints.Min;

public class Comment {
    private String commentId;
    private String commentPhotoId;
    @Min(value=5)
    private String commentMessage;
    @ValidCreatedBy
    private String commentCreatedBy;

    public Comment(String commentPhotoId, String commentMessage, String commentCreatedBy) {
        this.commentPhotoId = commentPhotoId;
        this.commentMessage = commentMessage;
        this.commentCreatedBy = commentCreatedBy;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getCommentPhotoId() {
        return commentPhotoId;
    }

    public void setCommentPhotoId(String commentPhotoId) {
        this.commentPhotoId = commentPhotoId;
    }

    public String getCommentMessage() {
        return commentMessage;
    }

    public void setCommentMessage(String commentMessage) {
        this.commentMessage = commentMessage;
    }

    public String getCommentCreatedBy() {
        return commentCreatedBy;
    }

    public void setCommentCreatedBy(String commentCreatedBy) {
        this.commentCreatedBy = commentCreatedBy;
    }
}
