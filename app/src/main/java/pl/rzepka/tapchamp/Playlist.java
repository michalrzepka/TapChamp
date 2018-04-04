package pl.rzepka.tapchamp;

import java.util.LinkedList;
import java.util.ListIterator;

public class Playlist {

    public static LinkedList<Song> playlist = new LinkedList<>();

    public static ListIterator<Song> playlistIterator = playlist.listIterator();

    public static void addAlbum(Album album) {
        for(Song song : album.getmSongs()) {
            playlist.add(song);
        }
    }

    public static void removeSong(Song song) {
        playlist.remove(song);
    }


}
