--
--	  private Long albumId;
--    private String albumName;
--    private String albumArtist;
--    private String albumGenre;
--    private Double albumPrice;
--    private Integer albumTracks;
--  Create a table to hold customers!
create table public.Album (
    album_id INTEGER PRIMARY KEY,
    album_name character  varying ,
    album_artist character  varying ,
    album_genre character  varying ,
    album_price double ,
    album_tracks integer
);

drop sequence public.album_id_seq;

create sequence public.album_id_seq
    increment by 100
    minvalue 1
    maxvalue 2147483647
    start 1
    cache 100;

