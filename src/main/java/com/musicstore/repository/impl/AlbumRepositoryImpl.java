package com.musicstore.repository.impl;

import com.musicstore.jpa.JpaMusicStoreRepository;
import com.musicstore.model.Album;
import com.musicstore.repository.AlbumRepository;
import org.springframework.stereotype.Repository;

import com.google.common.collect.MoreCollectors;
import com.musicstore.model.Album;
import com.musicstore.repository.AlbumRepository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import java.util.Optional;

@Repository
public class AlbumRepositoryImpl implements AlbumRepository {

    //
    // instance data
    //private List<Album> albumList;
	private final JpaMusicStoreRepository jpaMusicStoreRepository;
	
    public AlbumRepositoryImpl(JpaMusicStoreRepository jpaMusicStoreRepository) {
        //albumList = new ArrayList<>();
    	this.jpaMusicStoreRepository = jpaMusicStoreRepository;
    }

    @Override
    public List<Album> getAlbum() {
        //return albumList;
    	return (List<Album>) jpaMusicStoreRepository.findAll();
    }

    @Override
    public Album addAlbum(Album album) {

        //albumList.add(album);
        //return album;
    	return jpaMusicStoreRepository.save(album);
    }

   // @Override
   // public long getNextAlbumId() {

        //Album maxGame = albumList.stream().max(Comparator.comparing(Album::getAlbumId)).get();
        //return maxGame.getAlbumId() + 1;
    	
    //}

    @Override
    public Album findAlbumById(Long albumId) {

        //
        //  solution 1: using Optional

//        Optional<Game> foundGame = albumList.stream()
//                .filter(g -> g.getAlbumId().equals(albumId)).findAny();
//        if (foundGame.isPresent()) {
//            return foundGame.get();
//        } else {
//            throw new IllegalStateException("Game with ID " + albumId + " is not found!");
//        }

        //
        //  Solution 2: using Google Guava
       // return albumList.stream().filter(g -> g.getAlbumId().equals(albumId)).collect(MoreCollectors.onlyElement());
    	
    	Optional<Album> album = jpaMusicStoreRepository.findById(albumId);
        //if (album.isPresent()) {
    	if (album.isPresent()) {
            return album.get();
        }
        
        throw new IllegalStateException("Album with ID " + albumId + " is not found!");
        
    }

    @Override
    public Album editAlbum(Long albumId, String albumName, String albumArtist,  String albumGenre, Double albumPrice, Integer albumTracks) {

        //
        //  edit the existing game
		/*
		 * Album existing = findAlbumById(albumId); if (existing == null) { throw new
		 * IllegalStateException("game with ID not found"); }
		 * existing.setAlbumName(albumName); existing.setAlbumArtist(albumArtist);
		 * existing.setAlbumGenre(albumGenre);
		 * existing.setAlbumPrice(Double.valueOf(albumPrice));
		 * existing.setAlbumTracks(Integer.valueOf(albumTracks));
		 * 
		 * return existing;
		 */
    	
    	Album existing = findAlbumById(albumId);
        existing.setAlbumName(albumName);
        existing.setAlbumArtist(albumArtist);
        existing.setAlbumGenre(albumGenre);
        existing.setAlbumPrice(Double.valueOf(albumPrice));   
        existing.setAlbumTracks(Integer.valueOf(albumTracks));
        return jpaMusicStoreRepository.save(existing);    // update
    }

    @Override
    public boolean deletAlbumById(Long albumId) {
        //albumList = albumList.stream().filter(g -> !g.getAlbumId().equals(albumId)).collect(Collectors.toList());
        // return true;
        jpaMusicStoreRepository.deleteById(albumId);
        return true;
    }
      
}
