package com.example.springRestAWS.service;

import com.example.springRestAWS.model.Photo;
import com.example.springRestAWS.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhotoService {

    @Autowired
    PhotoRepository photoRepository;

    //POST || CREATE
    public Photo savePhoto(Photo photo){
        return photoRepository.save(photo);
    }

    //GET || VIEW
    public List<Photo> getAllPhotos(){
        return photoRepository.findAll();
    }

    public Optional<Photo> getPhotoById(String photoId){
        return photoRepository.findById(photoId);
    }


    //PUT || UPDATE
    public Photo updatePhoto(Photo photo){
        return photoRepository.save(photo);
    }

    //DELETE
    public void deletePhoto(String photoId){
        photoRepository.deleteById(photoId);
    }
}
