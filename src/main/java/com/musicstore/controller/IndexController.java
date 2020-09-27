package com.musicstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.musicstore.model.Album;
import com.musicstore.service.AlbumService;

import java.util.List;

@Controller
public class IndexController {

    // field-injection

//    @Autowired
//    private albumservice albumservice;

    private final AlbumService albumService;

    //
    //  constructor injection!
    public IndexController(AlbumService albumService) {

        // managed instance by developer
//        this.albumservice = new albumserviceImpl();

        // by spring via the constructor!
        this.albumService = albumService;
    }

    @GetMapping("/")
//    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        List<Album> albums = albumService.getAlbum();
        model.addAttribute("albums", albums);
        return "index";
    }

    @GetMapping("/search")
    public String indexFiltered(Model model, @RequestParam("term") String term) {
        List<Album> albums = albumService.findAllFilteredAlbums(term);
        model.addAttribute("albums", albums);
        return "index";
    }

    @GetMapping("/success")
    public String indexWithSuccess(Model model) {
        List<Album> albums = albumService.getAlbum();
        model.addAttribute("albums", albums);
        model.addAttribute("success", "Your changes were successfully saved.");
        return "index";
    }

    @GetMapping("/albums/delete/{albumId}")
    public String deleteAlbum(@PathVariable Long albumId) {
        albumService.deleteAlbumById(albumId);
        return "redirect:/";
    }

}
