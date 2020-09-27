package com.musicstore.model;

import javax.persistence.*;

@Entity
public class Album {

    //
    //  instance data
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "album_id_seq")
    @SequenceGenerator(name = "album_id_seq", sequenceName = "album_id_seq", allocationSize = 100)
    private Long albumId;
    private String albumName;
    private String albumArtist;
    private String albumGenre;
    private Double albumPrice;
    private Integer albumTracks;

    public Album() {}
    
    public Album(String albumName, String albumArtist,String albumGenre, Double albumPrice, Integer albumTracks ) {
        //this.albumId = albumId;
        this.albumName = albumName;
        this.albumArtist = albumArtist;
        this.albumGenre= albumGenre;
        this.albumPrice = albumPrice;
        this.albumTracks= albumTracks;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumArtist() {
        return albumArtist;
    }

    public void setAlbumArtist(String albumArtist) {
        this.albumArtist = albumArtist;
    }
    public String getAlbumGenre() {
    	return albumGenre;
    }
    public void setAlbumGenre(String albumGenre) {
    	this.albumGenre = albumGenre;
    }
    

    public Double getAlbumPrice() {
        return albumPrice;
    }

    public void setAlbumPrice(Double albumPrice) {
        this.albumPrice = albumPrice;
    }
    
    public Integer getAlbumTracks() {
    	return albumTracks;
    }
    public void setAlbumTracks(Integer albumTracks) {
    	this.albumTracks=albumTracks;
    }
}
