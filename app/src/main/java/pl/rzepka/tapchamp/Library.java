package pl.rzepka.tapchamp;

import android.util.Log;

import java.util.ArrayList;

public class Library {

    private static ArrayList<Artist> artists = new ArrayList<>();

    public static void populateLibrary() {
        new Song("Wstępizille", "Esende Mylffon", "Tede", 112);
        new Song("Blask", "Esende Mylffon", "Tede", 244);
        new Song("Hity na czasie", "Esende Mylffon", "Tede", 222);
        new Song("Glokk", "Esende Mylffon", "Tede", 300);
        new Song("Airmax Classic", "Esende Mylffon", "Tede", 274);

        new Song("#1", "Notes", "Tede", 0);
        new Song("#2", "Notes", "Tede", 0);
        new Song("#3", "Notes", "Tede", 0);
        new Song("#4", "Notes", "Tede", 0);
        new Song("#5", "Notes", "Tede", 0);
        new Song("#6", "Notes", "Tede", 0);
        new Song("#7", "Notes", "Tede", 0);

        new Song("#1", "S.P.O.R.T.", "Tede", 0);
        new Song("#2", "S.P.O.R.T.", "Tede", 0);
        new Song("#3", "S.P.O.R.T.", "Tede", 0);
        new Song("#4", "S.P.O.R.T.", "Tede", 0);
        new Song("#5", "S.P.O.R.T.", "Tede", 0);
        new Song("#6", "S.P.O.R.T.", "Tede", 0);
        new Song("#7", "S.P.O.R.T.", "Tede", 0);
        new Song("#8", "S.P.O.R.T.", "Tede", 0);

        new Song("Help!", "Help!", "The Beatles", 138);
        new Song("The Night Before!", "Help!", "The Beatles", 154);
        new Song("You've Got to Hide Your Love Away", "Help!", "The Beatles", 129);
        new Song("I Need You!", "Help!", "The Beatles", 148);
        new Song("Another Girl", "Help!", "The Beatles", 125);

        new Song("#1", "Abbey Road", "The Beatles", 0);
        new Song("#2", "Abbey Road", "The Beatles", 0);
        new Song("#3", "Abbey Road", "The Beatles", 0);
        new Song("#4", "Abbey Road", "The Beatles", 0);
        new Song("#5", "Abbey Road", "The Beatles", 0);
        new Song("#6", "Abbey Road", "The Beatles", 0);
        new Song("#7", "Abbey Road", "The Beatles", 0);

        new Song("#1", "Let It Be", "The Beatles", 0);
        new Song("#2", "Let It Be", "The Beatles", 0);
        new Song("#3", "Let It Be", "The Beatles", 0);
        new Song("#4", "Let It Be", "The Beatles", 0);
        new Song("#5", "Let It Be", "The Beatles", 0);
        new Song("#6", "Let It Be", "The Beatles", 0);
        new Song("#7", "Let It Be", "The Beatles", 0);
        new Song("#8", "Let It Be", "The Beatles", 0);

        new Song("Hit the Lights", "Kill 'Em All", "Metallica", 257);
        new Song("The Four Horsemen", "Kill 'Em All", "Metallica", 433);
        new Song("Motorbreath", "Kill 'Em All", "Metallica", 188);
        new Song("Jump in the Fire", "Kill 'Em All", "Metallica", 282);
        new Song("(Anesthesia)—Pulling Teeth", "Kill 'Em All", "Metallica", 255);

        new Song("#1", "Master of Puppets", "Metallica", 0);
        new Song("#2", "Master of Puppets", "Metallica", 0);
        new Song("#3", "Master of Puppets", "Metallica", 0);
        new Song("#4", "Master of Puppets", "Metallica", 0);
        new Song("#5", "Master of Puppets", "Metallica", 0);
        new Song("#6", "Master of Puppets", "Metallica", 0);
        new Song("#7", "Master of Puppets", "Metallica", 0);
    }

    public static ArrayList<Artist> getArtists() {
        return artists;
    }

    public static void addToLibrary(Song song) {
        String artistName = song.getmArtistName();
        String albumTitle = song.getmAlbumTitle();
        String songTitle = song.getmSongTitle();
        if (findArtist(artistName) == null) {
            Library.artists.add(new Artist(artistName));
            Log.v("added", artistName);
        }
        if (findAlbum(artistName, albumTitle) == null) {
            Library.findArtist(artistName).addAlbum(new Album(albumTitle));
            Log.v("added", artistName + albumTitle);
        }
        if (findSong(artistName, albumTitle, songTitle) == null) {
            Library.findAlbum(artistName, albumTitle).addSong(song);
            Log.v("added", artistName + albumTitle + songTitle);
        }
    }

    public static Artist findArtist(String artistName) {
        Artist artistFound = null;
        for (Artist artist : artists) {
            if (artist.getmArtistName().equals(artistName)) {
                artistFound = artist;
                Log.v("Something", artistName);
            }
        }
       return artistFound;
    }

    public static Album findAlbum(String artistName, String albumTitle) {
        Album albumFound = null;
        ArrayList<Album> artistAlbums = findArtist(artistName).getmAlbums();
        for (Album album : artistAlbums) {
            if (album.getmAlbumTitle().equals(albumTitle)) {
                albumFound = album;
            }
        }
        return albumFound;
    }

    private static Song findSong(String artistName, String albumTitle, String songTitle) {
        Song songFound = null;
        ArrayList<Song> album = findAlbum(artistName, albumTitle).getmSongs();
        for (Song song : album) {
            if (song.getmSongTitle().equals(songTitle)) {
                songFound = song;
            }
        }
        return songFound;
    }

}
