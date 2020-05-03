package com.example.springRestAWS.resource;

import com.example.springRestAWS.model.Album;
import com.example.springRestAWS.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/albums")
public class AlbumResource {

    @Autowired
    AlbumService albumService;

    //POST || CREATE
    @PostMapping
    public Album saveAlbum(@RequestBody Album album){
        return albumService.saveAlbum(album);
    }

    //GET || READ
    @GetMapping
    public List<Album> getAllAlbums(){
        return albumService.getAllAlbums();
    }

    @GetMapping("/{albumId}")
    public Optional<Album> getAlbumById(@PathVariable("albumId") String albumId){
        return albumService.getAlbumById(albumId);
    }

    //PUT  || UPDATE
    @PutMapping
    public Album updateAlbum(@RequestBody Album album){
        return albumService.updateAlbum(album);
    }

    //DELETE
    @DeleteMapping
    public void deleteAlbum(@RequestParam(name="albumId") String albumId){
         albumService.deleteAlbum(albumId);
    }

    /*
     //GET/VIEW
    @GetMapping("/album")
    public Album getAlbum(){
        return albumService.getAlbum();
    }
     */
}
