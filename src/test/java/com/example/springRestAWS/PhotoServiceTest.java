package com.example.springRestAWS;

import com.example.springRestAWS.model.Photo;
import com.example.springRestAWS.service.PhotoService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PhotoServiceTest {

    @Autowired
    PhotoService photoService;

    @Before
    public void savePhoto(){
        photoService.savePhoto(new Photo("1","www.photo.com/photo1","jmallari@gmh.com", new Date()));
    }

    @Test
    public void getPhoto(){
        Optional<Photo> photo = photoService.getPhotoById("1");
        Assert.assertEquals("jmallari@gmh.com",photo.get().getPhotoCreatedBy());
    }

    @Test
    public void editPhoto(){
        Optional<Photo> photo = photoService.getPhotoById("1");
        photo.get().setPhotoCreatedBy("jmallari@gmail.com");
        photoService.savePhoto(photo.get());
        Assert.assertEquals("jmallari@gmail.com",photo.get().getPhotoCreatedBy());
    }
    
    @After
    public void deletePhoto(){
        photoService.deletePhoto("1");
    }
}
