package pl.rzepka.tapchamp;

import java.util.ArrayList;

public class Album {

    private String mAlbumTitle;
    private String mAlbumArtist;
    private int mAlbumCover = R.drawable.cover;
    private ArrayList<Song> mSongs = new ArrayList<>();

    public Album(String mAlbumTitle, String mAlbumArtist) {
        this.mAlbumTitle = mAlbumTitle;
        this.mAlbumArtist = mAlbumArtist;
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
        return mSongs.size();
    }

    public int getmAlbumCover() {
        return mAlbumCover;
    }

    public void setmAlbumCover(int mAlbumCover) {
        this.mAlbumCover = mAlbumCover;
    }

    public int getAlbumDuration() {
        int albumDuration = 0;
        for (Song song : mSongs) {
            albumDuration += song.getmDuration();
        }
        return albumDuration;
    }
}
