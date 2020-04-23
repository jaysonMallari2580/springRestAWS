package com.example.springRestAWS.repository;

import com.example.springRestAWS.model.Album;
import com.example.springRestAWS.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AlbumRepository {

    List<Album> albumList = new ArrayList();

    public Album getAlbum(){
        Album album = new Album("Parokya","90's rock music","url://pic.com");
        return album;
    }

    public Album saveAlbum(Album album) {
        album.setAlbumId(albumList.size() + 1);
        albumList.add(album);
        return album;
    }

    //GET/VIEW
    public List<Album> getAllAlbums() {
        return albumList;
    }


    public Album getAlbumById(int albumId) {
        for(Album album: albumList){
            if(album.getAlbumId() == albumId){
                return album;
            }
        }
        return null;
    }

    //PUT/UPDATE
    public Album updateAlbum(int albumId, Album album) {
        for(Album a: albumList){
            if(a.getAlbumId() == albumId){
                a.setAlbumName(album.getAlbumName());
                a.setAlbumDescription(album.getAlbumDescription());
                a.setAlbumCoverPicUrl(album.getAlbumCoverPicUrl());
                return a;
            }
        }
        return null;
    }

    //DELETE
    public Album deleteAlbum(int albumId) {
        Album deletedAlbum = null;
        for(Album a: albumList){
            if(a.getAlbumId() == albumId){
                deletedAlbum = a;
                albumList.remove(a);
                return deletedAlbum;
            }
        }
        return deletedAlbum;
    }
}
