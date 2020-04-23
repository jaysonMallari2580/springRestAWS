package com.example.springRestAWS.model;

public class Album {
    private int albumId;
    private String albumName;
    private String albumDescription;
    private String albumCoverPicUrl;

    public Album(String albumName, String albumDescription, String albumCoverPicUrl) {
        this.albumName = albumName;
        this.albumDescription = albumDescription;
        this.albumCoverPicUrl = albumCoverPicUrl;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumDescription() {
        return albumDescription;
    }

    public void setAlbumDescription(String albumDescription) {
        this.albumDescription = albumDescription;
    }

    public String getAlbumCoverPicUrl() {
        return albumCoverPicUrl;
    }

    public void setAlbumCoverPicUrl(String albumCoverPicUrl) {
        this.albumCoverPicUrl = albumCoverPicUrl;
    }
}
