--
--	  private Long albumId;
--    private String albumName;
--    private String albumArtist;
--    private String albumGenre;
--    private Double albumPrice;
--    private Integer albumTracks;
--  Create a table to hold albums!
create table public.Album (
    album_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    album_name VARCHAR(255),
    album_artist VARCHAR(255),
    album_genre VARCHAR(255),
    album_price DOUBLE,
    album_tracks INTEGER
);

