package pl.rzepka.tapchamp;

public class Song {

    private String mSongTitle;
    private String mSongDuration;

    public Song(String songTitle, String duration) {
        this.mSongTitle = mSongTitle;
        this.mSongDuration = mSongDuration;
    }

    public String getmSongTitle() {
        return mSongTitle;
    }

    public String getmSongDuration() {
        return mSongDuration;
    }
}

