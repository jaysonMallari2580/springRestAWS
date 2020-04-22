package com.example.springRestAWS.resource;

import com.example.springRestAWS.model.Album;
import com.example.springRestAWS.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AlbumResource {

    @Autowired
    AlbumService albumService;

    //POST/CREATE
    @PostMapping("/user")
    public Album saveAlbum(@RequestBody Album album){
        return albumService.saveAlbum(album);
    }

    //GET/VIEW
    @GetMapping("/allAlbums")
    public List<Album> getAllAlbums(){
        return albumService.getAllAlbums();
    }

    @GetMapping("/album/{albumId}")
    public Album getAlbumById(@PathVariable("albumId") int albumId){
        return albumService.getAlbumById(albumId);
    }

    //PUT /UPDATE
    @PutMapping("/album/{albumId}")
    public Album updateAlbum(@PathVariable("albumId") int albumId, @RequestBody Album album){
        return albumService.updateAlbum(albumId,album);
    }

    //DELETE
    @DeleteMapping("/album")
    public Album deleteAlbum(@RequestParam(name="albumId") int albumId){
        return albumService.deleteAlbum(albumId);
    }

}
