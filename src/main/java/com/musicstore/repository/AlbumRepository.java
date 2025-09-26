package com.musicstore.repository;

import java.util.List;

import com.musicstore.model.Album;

public interface AlbumRepository {
    List<Album> getAlbum();

    Album addAlbum(Album album);

    //long getNextAlbumId();

    Album findAlbumById(Long albumId);

    Album editAlbum(Long albumId, String albumName, String albumArtist,  String albumGenre,Double albumPrice, Integer albumTracks);

    boolean deleteAlbumById(Long albumId);
}
