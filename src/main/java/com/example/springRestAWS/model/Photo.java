package com.example.springRestAWS.model;

import com.example.springRestAWS.validation.ValidCreatedBy;
import org.springframework.data.annotation.Id;

import java.util.Date;

public class Photo {
    @Id
    private String photoId;
    private String photoAlbumId;
    private String photoUrl;
    @ValidCreatedBy
    private String photoCreatedBy;
    private Date photoDateCreated;

    public Photo(String photoAlbumId, String photoUrl, String photoCreatedBy, Date photoDateCreated) {
        this.photoAlbumId = photoAlbumId;
        this.photoUrl = photoUrl;
        this.photoCreatedBy = photoCreatedBy;
        this.photoDateCreated = photoDateCreated;
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public String getPhotoAlbumId() {
        return photoAlbumId;
    }

    public void setPhotoAlbumId(String photoAlbumId) {
        this.photoAlbumId = photoAlbumId;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getPhotoCreatedBy() {
        return photoCreatedBy;
    }

    public void setPhotoCreatedBy(String photoCreatedBy) {
        this.photoCreatedBy = photoCreatedBy;
    }

    public Date getPhotoDateCreated() {
        return photoDateCreated;
    }

    public void setPhotoDateCreated(Date photoDateCreated) {
        this.photoDateCreated = photoDateCreated;
    }
}
