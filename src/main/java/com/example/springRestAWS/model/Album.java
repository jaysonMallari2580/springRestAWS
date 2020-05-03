package com.example.springRestAWS.model;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Album {
    @Id
    private String albumId;
    private String albumName;
    private String albumCoverPhotoUrl;
    private String albumCreatedBy;
    private Date dateCreated;

    public Album(String albumName, String albumCoverPhotoUrl, String albumCreatedBy, Date dateCreated) {
        this.albumName = albumName;
        this.albumCoverPhotoUrl = albumCoverPhotoUrl;
        this.albumCreatedBy = albumCreatedBy;
        this.dateCreated = dateCreated;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumCoverPhotoUrl() {
        return albumCoverPhotoUrl;
    }

    public void setAlbumCoverPhotoUrl(String albumCoverPhotoUrl) {
        this.albumCoverPhotoUrl = albumCoverPhotoUrl;
    }

    public String getAlbumCreatedBy() {
        return albumCreatedBy;
    }

    public void setAlbumCreatedBy(String albumCreatedBy) {
        this.albumCreatedBy = albumCreatedBy;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}

