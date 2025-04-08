package org.example.Models;

import java.util.ArrayList;

public class User extends Account{
    private ArrayList<Song> LikedSongs;
    private ArrayList<Album> LikedAlbums;

    public User(String username, String password, int age, String email, String role) {
        super(username, password, age, email, "User");
        this.LikedSongs = new ArrayList<>();
        this.LikedAlbums = new ArrayList<>();
    }

    public ArrayList<Song> getLikedSongs() {
        return LikedSongs;
    }

    public ArrayList<Album> getLikedAlbums() {
        return LikedAlbums;
    }

    public void likeSong(Song song) {
        if (!LikedSongs.contains(song)) {
            LikedSongs.add(song);
        }
    }

    public void likeAlbum(Album album) {
        if (!LikedAlbums.contains(album)) {
            LikedAlbums.add(album);
        }
    }



    @Override
    public String toString(){
        return super.toString() + "Liked Songs : " + LikedAlbums + "\nLiked Albums : " + LikedAlbums;
    }
}
