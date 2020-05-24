package com.example.springRestAWS.resource;

import com.example.springRestAWS.model.FirebaseUser;
import com.example.springRestAWS.model.Photo;
import com.example.springRestAWS.service.FirebaseService;
import com.example.springRestAWS.service.PhotoService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/photos")
public class PhotoResource {

    @Autowired
    PhotoService photoService;

    @Autowired
    FirebaseService firebaseService;

    //POST || CREATE
    @PostMapping
    public Photo savePhoto(@RequestBody @Valid Photo photo, @RequestHeader(name="idToken")String idToken,
                           @RequestHeader(name="photoCreatedBy")String photoCreatedBy) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser=firebaseService.authenticate(idToken);
            if(firebaseUser != null && firebaseUser.getEmail()== photoCreatedBy){
                return photoService.savePhoto(photo);
            }else{
                return null;
            }
    }

    // GET || READ
    @GetMapping
    public List<Photo> getAllPhotos(){
        return photoService.getAllPhotos();
    }

    @GetMapping("/{photoId}")
    public Optional<Photo> getPhotoById(@PathVariable("photoId") String photoId){
        return photoService.getPhotoById(photoId);
    }

    //PUT || UPDATE
    @PutMapping
    public Photo updatePhoto(@RequestBody Photo photo, @RequestHeader(name="idToken")String idToken,
                             @RequestHeader(name="photoCreatedBy")String photoCreatedBy) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
            if(firebaseUser != null && firebaseUser.getEmail() == photoCreatedBy){
                return photoService.updatePhoto(photo);
            }else{
                return null;
            }
    }

    //DELETE
    @DeleteMapping
    public void deletePhoto(@RequestParam(name="photoId") String photoId, @RequestHeader(name="idToken")String idToken,
                            @RequestHeader(name="photoCreatedBy")String photoCreatedBy) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser=firebaseService.authenticate(idToken);
            if(firebaseUser != null && firebaseUser.getEmail() == photoCreatedBy){
                photoService.deletePhoto(photoId);
            }
    }
}
