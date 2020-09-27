package com.musicstore.service.impl;

import org.springframework.stereotype.Service;

import com.musicstore.model.Album;
import com.musicstore.repository.AlbumRepository;
import com.musicstore.service.AlbumService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService {

    // field-injection (not recommended)
//    @Autowired  // managed by spring!
//    private GameRepository gameRepository;

    // managed by spring!
    private final AlbumRepository albumRepository;

    public AlbumServiceImpl(AlbumRepository albumRepository) {

        // instance managed by the developer
//        gameRepository = new GameRepositoryImpl();

        // injected by constructor!
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Album> getAlbum() {
        return albumRepository.getAlbum();
    }

    @Override
    public Album addAlbum(String albumName, String albumArtist, String albumGenre, Double albumPrice, Integer albumTracks) {

        //
        //  validation
        if (albumName == null || albumName.isEmpty()) {
            throw new IllegalArgumentException("album name cannot be null");
        }
        Double price;
        try {
            price = Double.valueOf(albumPrice);
        } catch (NumberFormatException nfex) {
            throw new IllegalArgumentException("invalid album price");
        }

        //  test if null/empty
        //long nextId = albumRepository.getNextAlbumId();
        //Long albumId, String albumName, String albumArtist, String genre, String albumPrice, Integer tracks
        Album album = new Album(albumName, albumArtist, albumGenre,  albumPrice, albumTracks);
        return albumRepository.addAlbum(album);
    }

    @Override
    public List<Album> findAllFilteredAlbums(String filter) {

        List<Album> allAlbums = albumRepository.getAlbum();
        return allAlbums.stream()
                .filter(g -> g.getAlbumName().toLowerCase().contains(filter))
                .collect(Collectors.toList());
    }

    @Override
    public Album findAlbumById(Long albumId) {
        return albumRepository.findAlbumById(albumId);
    }

    @Override
    public Album editAlbum(Long albumId, String albumName, String albumArtist,  String albumGenre,Double albumPrice, Integer albumTracks) {
        return albumRepository.editAlbum(albumId, albumName, albumArtist,albumGenre,albumPrice,albumTracks);
    }

    @Override
    public boolean deleteAlbumById(Long albumId) {
        return albumRepository.deletAlbumById(albumId);
    }
}

