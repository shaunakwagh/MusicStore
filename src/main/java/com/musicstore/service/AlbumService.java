package com.musicstore.service;

import java.util.List;

import com.musicstore.model.Album;

public interface AlbumService {
    List<Album> getAlbum();

    Album addAlbum( String albumName, String albumArtist, String albumGenre, Double albumPrice, Integer albumTracks);

    List<Album> findAllFilteredAlbums(String filter);

    Album findAlbumById(Long albumId);

    Album editAlbum(Long albumId, String albumName, String albumArtist, String albumGenre, Double albumPrice, Integer albumTracks);

    boolean deleteAlbumById(Long albumId);
}
