package com.example.springRestAWS.service;

import com.example.springRestAWS.model.Album;
import com.example.springRestAWS.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AlbumService {

    @Autowired
    AlbumRepository albumRepository;

    //POST/SAVE
    public Album saveAlbum(Album album) {
        return albumRepository.saveAlbum(album);
    }

    //GET/VIEW
    public List<Album> getAllAlbums() {
        return albumRepository.getAllAlbums();
    }

    public Album getAlbumById(int albumId) {
        return albumRepository.getAlbumById(albumId);
    }

    //PUT/UPDATE
    public Album updateAlbum(int albumId, Album album) {
        return albumRepository.updateAlbum(albumId,album);
    }

    //DELETE
    public Album deleteAlbum(int albumId) {
        return albumRepository.deleteAlbum(albumId);
    }
}
