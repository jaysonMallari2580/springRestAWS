package com.example.springRestAWS.resource;

import com.example.springRestAWS.model.Photo;
import com.example.springRestAWS.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/photos")
public class PhotoResource {

    @Autowired
    PhotoService photoService;

    //POST || CREATE
    @PostMapping
    public Photo savePhoto(@RequestBody @Valid Photo photo){
        return photoService.savePhoto(photo);
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
    public Photo updatePhoto(@RequestBody Photo photo){
        return photoService.updatePhoto(photo);
    }

    //DELETE
    @DeleteMapping
    public void deletePhoto(@RequestParam(name="photoId") String photoId){
        photoService.deletePhoto(photoId);
    }
}
