package pl.rzepka.tapchamp;

import java.util.ArrayList;

public class Album {

    private String mAlbumTitle;
    private ArrayList<Song> mSongs = new ArrayList<>();

    public Album(String mAlbumTitle) {
        this.mAlbumTitle = mAlbumTitle;
    }

    public void addSong(Song song) {
        this.mSongs.add(song);
    }

    public String getmAlbumTitle() {
        return mAlbumTitle;
    }

    public ArrayList<Song> getmSongs() {
        return mSongs;
    }

    public int getNumberOfSongs() {
        int songsNumber = mSongs.size();
        return songsNumber;
    }

    public int getAlbumDuration() {
        int albumDuration = 0;
        for(Song song : mSongs) {
            albumDuration += song.getmDuration();
        }
        return albumDuration;
    }
}
