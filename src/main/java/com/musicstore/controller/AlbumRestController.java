package com.musicstore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.musicstore.model.Album;
import com.musicstore.service.AlbumService;

import java.util.List;

@RestController
@RequestMapping("/api/albums")
public class AlbumRestController {

    private final AlbumService albumService;

    public AlbumRestController(AlbumService albumService) {
        this.albumService = albumService;
    }

    // GET /api/albums - Get all albums
    @GetMapping
    public ResponseEntity<List<Album>> getAllAlbums() {
        try {
            List<Album> albums = albumService.getAlbum();
            return ResponseEntity.ok(albums);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // GET /api/albums/{id} - Get album by ID
    @GetMapping("/{id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable Long id) {
        try {
            Album album = albumService.findAlbumById(id);
            if (album != null) {
                return ResponseEntity.ok(album);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // POST /api/albums - Create a new album
    @PostMapping
    public ResponseEntity<Album> createAlbum(@RequestBody Album album) {
        try {
            Album createdAlbum = albumService.addAlbum(
                album.getAlbumName(),
                album.getAlbumArtist(),
                album.getAlbumGenre(),
                album.getAlbumPrice(),
                album.getAlbumTracks()
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(createdAlbum);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // PUT /api/albums/{id} - Update an existing album
    @PutMapping("/{id}")
    public ResponseEntity<Album> updateAlbum(@PathVariable Long id, @RequestBody Album album) {
        try {
            Album updatedAlbum = albumService.editAlbum(
                id,
                album.getAlbumName(),
                album.getAlbumArtist(),
                album.getAlbumGenre(),
                album.getAlbumPrice(),
                album.getAlbumTracks()
            );
            return ResponseEntity.ok(updatedAlbum);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // DELETE /api/albums/{id} - Delete an album
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlbum(@PathVariable Long id) {
        try {
            boolean deleted = albumService.deleteAlbumById(id);
            if (deleted) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
