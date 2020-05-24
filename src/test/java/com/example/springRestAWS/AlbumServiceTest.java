package com.example.springRestAWS;

import com.example.springRestAWS.model.Album;
import com.example.springRestAWS.model.User;
import com.example.springRestAWS.service.AlbumService;
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

import static com.amazonaws.services.snowball.model.JobState.New;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlbumServiceTest {

    @Autowired
    AlbumService albumService;

    @Before
    public void saveAlbum(){
        albumService.saveAlbum(new Album("1","Album A","www.pic.com/albumA","albuma@gmh.com",new Date()));
    }


    @Test
    public void getAlbum(){
        Optional<Album> album = albumService.getAlbumById("1");
        Assert.assertEquals("Album A", album.get().getAlbumName());
    }

    @Test
    public void editAlbum (){
        Optional<Album> album = albumService.getAlbumById("1");
        album.get().setAlbumName("Album B");
        albumService.saveAlbum(album.get());
        Assert.assertEquals("Album B",album.get().getAlbumName());
    }

    @After
    public void deleteAlbum(){
        albumService.deleteAlbum("1");
    }
}
