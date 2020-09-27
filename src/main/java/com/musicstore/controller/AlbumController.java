package com.musicstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.musicstore.model.Album;
import com.musicstore.service.AlbumService;

@Controller
public class AlbumController {

    //
    // auto-wired
    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    /*
        Add game
     */

    @GetMapping("/album/add")
    public String addalbumForm(Model model) {
        return "addalbum";
    }

    @PostMapping("/album/add")
    public String addAlbumSubmit(Model model,  @RequestParam("albumName") String albumName, @RequestParam("albumArtist") String albumArtist,@RequestParam("albumGenre") String albumGenre,@RequestParam("albumPrice") Double albumPrice,@RequestParam("albumTracks") Integer albumTracks) {

        //
        //  Add the game to the database
        try {
        	//long nextId = albumRepository.getNextAlbumId();
            this.albumService.addAlbum(albumName, albumArtist, albumGenre, albumPrice, albumTracks);
        } catch (Exception ex) {
            model.addAttribute("error", ex.getMessage());
            return "addalbum";
        }

        model.addAttribute("success", "Your album was successfully added");
        return "redirect:/success";
    }

    /*
        Edit game
     */
    @GetMapping("/albums/edit/{albumId}")
    public String editAlbumPage(@PathVariable Long albumId, Model model) {

        //
        //  find the game
        Album album = albumService.findAlbumById(albumId);

        //
        //  set the model
        model.addAttribute("album_id", album.getAlbumId());
        model.addAttribute("albumName", album.getAlbumName());
        model.addAttribute("albumArtist", album.getAlbumArtist());
        model.addAttribute("albumGenre", album.getAlbumGenre());
        model.addAttribute("albumPrice", album.getAlbumPrice());
        model.addAttribute("albumTracks", album.getAlbumTracks());
        return "editalbum";
    }

    @PostMapping("/albums/edit")
    public String editAlbumSubmit(@RequestParam Long albumId, @RequestParam String albumName, @RequestParam String albumArtist, @RequestParam String albumGenre,@RequestParam Double albumPrice,@RequestParam Integer albumTracks, Model model) {

        //
        //  submit the form
        try {
            this.albumService.editAlbum(albumId, albumName, albumArtist,albumGenre, albumPrice, albumTracks);
        } catch (Exception ex) {
            model.addAttribute("error", ex.getMessage());
        }

        //
        //  success
        return "redirect:/success";
    }

}
