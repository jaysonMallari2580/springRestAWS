package com.example.springRestAWS.resource;

import com.example.springRestAWS.model.Album;
import com.example.springRestAWS.model.FirebaseUser;
import com.example.springRestAWS.service.AlbumService;
import com.example.springRestAWS.service.FirebaseService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/albums")
public class AlbumResource {

    @Autowired
    AlbumService albumService;

    @Autowired
    FirebaseService firebaseService;

    //POST || CREATE
    @PostMapping
    public Album saveAlbum(@RequestBody @Valid Album album,@RequestHeader(name="idToken")String idToken,
                           @RequestHeader(name="albumCreatedBy")String albumCreatedBy) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);

            if(firebaseUser != null && firebaseUser.getEmail() == albumCreatedBy){
                return albumService.saveAlbum(album);
            }else{
                return null;
            }
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
    public Album updateAlbum(@RequestBody Album album , @RequestHeader(name="idToken")String idToken,
                             @RequestHeader(name="albumCreatedBy") String albumCreatedBy) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);

            if(firebaseUser != null && firebaseUser.getEmail() == albumCreatedBy){
                return albumService.updateAlbum(album);
            }else{
                return null;
            }
    }

    //DELETE
    @DeleteMapping
    public void deleteAlbum(@RequestParam(name="albumId") String albumId, @RequestHeader(name="idToken") String idToken,
                            @RequestHeader(name="albumCreatedBy")String albumCreatedBy) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);

            if(firebaseUser != null && firebaseUser.getEmail() == albumCreatedBy){
                albumService.deleteAlbum(albumId);
            }
    }

    /*
     //GET/VIEW
    @GetMapping("/album")
    public Album getAlbum(){
        return albumService.getAlbum();
    }
     */
}
