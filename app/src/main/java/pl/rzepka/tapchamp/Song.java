package pl.rzepka.tapchamp;

public class Song {

    private String mSongTitle;
    private String mAlbumTitle;
    private String mArtistName;
    private int mDuration;

    // song constructor that adds song to library after making new object

    public Song(String mSongTitle, String mAlbumTitle, String mArtistName, int mDuration) {
        this.mSongTitle = mSongTitle;
        this.mAlbumTitle = mAlbumTitle;
        this.mArtistName = mArtistName;
        this.mDuration = mDuration;
        Library.addToLibrary(this);
    }

    public String getmSongTitle() {
        return mSongTitle;
    }

    public String getmAlbumTitle() {
        return mAlbumTitle;
    }

    public String getmArtistName() {
        return mArtistName;
    }

    public int getmDuration() {
        return mDuration;
    }
}

