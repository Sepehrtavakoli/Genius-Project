package org.example.Models;

import java.io.File;

public class Album {
    private String AlbumName;
    private int Year;
    private Artist artist;
    private String SongNames;
    //private String Artists;
    public Album(String AlbumName) {
        this.AlbumName = AlbumName;
        this.Year = Year;
        this.artist = artist;

    }

    public String getAlbumName() {
        return AlbumName;
    }

    public int getYear() {
        return Year;
    }

    public Artist getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        return "Album : " + AlbumName + "\tArtist : " + artist + "\tReleased Year : " + Year ;
    }

}
