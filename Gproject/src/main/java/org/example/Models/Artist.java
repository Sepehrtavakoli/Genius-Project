package org.example.Models;

import java.util.ArrayList;

public class Artist extends Account {
    private ArrayList<Song> Songs;
    private ArrayList<Album> Albums;


    public Artist(String username, String password, int age, String email, String role) {
        super(username, password, age, email, "Artist");
        this.Songs = new ArrayList<>();
        this.Albums = new ArrayList<>();
    }

    public ArrayList<Song> getSongs() {
        return Songs;
    }

    public ArrayList<Album> getAlbums() {
        return Albums;
    }

    public void addSong(Song song) {
        Songs.add(song);
    }

    public void addAlbum(Album album) {
        Albums.add(album);
    }

    @Override
    public String toString() {
        return super.toString() + " Songs: " + Songs
                + " Albums: " + Albums
                + "Number Of Songs : " + Songs.size()
                + "Number Of Albums : " + Albums.size();
    }

}
