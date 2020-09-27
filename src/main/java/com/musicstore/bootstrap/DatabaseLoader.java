package com.musicstore.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.musicstore.model.Album;
import com.musicstore.repository.AlbumRepository;
import com.musicstore.repository.impl.AlbumRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
 
@Component
public class DatabaseLoader implements ApplicationListener<ContextRefreshedEvent> {

    //
    //  instance data
    // instance managed by spring!
    private final AlbumRepository albumRepository;

    public DatabaseLoader(AlbumRepository albumRepository) {

        // instance managed by the developer
//        this.gameRepository = new GameRepositoryImpl();

        // injected by constructor!
        this.albumRepository = albumRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("This will run when Spring starts!");

        //
        //  Initialize the database
        this.albumRepository.addAlbum(new Album("Lover", "Taylor Swift", "Pop", 59.99, 16));
        this.albumRepository.addAlbum(new Album("Bentley", "Post Malone", "Pop", 59.99, 10));
        this.albumRepository.addAlbum(new Album("Serious Hits", "Phil Collins", "Pop", 29.99, 15));
        this.albumRepository.addAlbum(new Album("Face Value", "Phil Collins", "Pop", 19.99, 10));
        this.albumRepository.addAlbum(new Album("WindSong", "John Denever", "Country",  59.99, 12));
        this.albumRepository.addAlbum(new Album("RD & Kishore", "Kishore Kumar", "Hindi",  59.99, 14));
    }
}
