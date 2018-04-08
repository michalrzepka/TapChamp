package pl.rzepka.tapchamp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Playlist {

    // playlist class with list that holds songs to display in now playing view

    public static ArrayList<Song> playlist = new ArrayList<>();

    public static void addAlbum(Album album) {
        for (Song song : album.getmSongs()) {
            playlist.add(song);
        }
    }

    public static void addArtist(Artist artist) {
        for (Album album : artist.getmAlbums()) {
            addAlbum(album);
        }
    }

    public static void removeSong(Song song) {
        playlist.remove(song);
    }


}
