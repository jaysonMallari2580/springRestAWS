package com.example.springRestAWS.service;

import com.example.springRestAWS.model.Album;
import com.example.springRestAWS.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {

    @Autowired
    AlbumRepository albumRepository;

    //POST || CREATE
    public Album saveAlbum(Album album) {
        return albumRepository.save(album);
    }

    // GET || READ
    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    public Optional<Album> getAlbumById(String albumId) {
        return albumRepository.findById(albumId);
    }

    //PUT/UPDATE
    public Album updateAlbum(Album album) {
        return albumRepository.save(album);
    }

    //DELETE
    public void deleteAlbum(String albumId) {
         albumRepository.deleteById(albumId);
    }

    /*
     //GET/VIEW
    public Album getAlbum() {
        return albumRepository.getAlbum();
    }
     */
}
