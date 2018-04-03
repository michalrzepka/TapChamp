package pl.rzepka.tapchamp;

import java.util.ArrayList;

public class Artist {

    private String mArtistName;
    private ArrayList<Album> mAlbums = new ArrayList<>();

    public Artist(String mArtistName) {
        this.mArtistName = mArtistName;
    }

    public void addAlbum(Album album) {
        this.mAlbums.add(album);
    }

    public String getmArtistName() {
        return mArtistName;
    }

    public ArrayList<Album> getmAlbums() {
        return mAlbums;
    }
}
