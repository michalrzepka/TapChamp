package pl.rzepka.tapchamp;

import android.util.Log;

import java.util.ArrayList;

public class Library {

    private static ArrayList<Artist> artists = new ArrayList<>();

    public static ArrayList<Artist> getArtists() {
        return artists;
    }

    public static void addToLibrary(Song song) {
        String artistName = song.getmArtistName();
        String albumTitle = song.getmAlbumTitle();
        String songTitle = song.getmSongTitle();
        if (findArtist(artistName) == null) {
            Library.artists.add(new Artist(artistName));
        }
        if (findAlbum(artistName, albumTitle) == null) {
            Library.findArtist(artistName).addAlbum(new Album(albumTitle));
        }
        if (findSong(artistName, albumTitle, songTitle) == null) {
            Library.findAlbum(artistName, albumTitle).addSong(song);
        }
    }

    public static Artist findArtist(String artistName) {
        Artist artistFound = null;
        for (Artist artist : artists) {
            if (artist.getmArtistName().equals(artistName)) {
                artistFound = artist;
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

    public static void populateLibrary() {
        new Song("Wstępizille", "Esende Mylffon", "Tede", 112);
        new Song("Blask", "Esende Mylffon", "Tede", 244);
        new Song("Hity na czasie", "Esende Mylffon", "Tede", 222);
        new Song("Glokk", "Esende Mylffon", "Tede", 300);
        new Song("Airmax Classic", "Esende Mylffon", "Tede", 274);
        new Song("Zamknij pysk!", "Esende Mylffon", "Tede", 256);
        new Song("Chory pastor", "Esende Mylffon", "Tede", 255);
        new Song("Łap tego loopa", "Esende Mylffon", "Tede", 216);
        new Song("21 palec", "Esende Mylffon", "Tede", 220);
        new Song("Zdzi-ro", "Esende Mylffon", "Tede", 220);
        new Song("Nic za darmo", "Esende Mylffon", "Tede", 254);
        new Song("Jakby jutra miało nie być", "Esende Mylffon", "Tede", 296);
        new Song("Esende Mylffon", "Esende Mylffon", "Tede", 310);
        new Song("To jeszcze nie koniec", "Esende Mylffon", "Tede", 221);



        new Song("Lorem ipsum", "Notes", "Tede", 123);
        new Song("Doler sit amet", "Notes", "Tede", 456);
        new Song("Absrudui", "Notes", "Tede", 654);
        new Song("Purusunu dadu", "Notes", "Tede", 765);
        new Song("Ryubudi", "Notes", "Tede", 223);
        new Song("Pariabafo", "Notes", "Tede", 434);
        new Song("Rutiuid", "Notes", "Tede", 198);
        new Song("Raproti rosir masir", "Notes", "Tede", 500);
        new Song("Proti nund osop", "Notes", "Tede", 324);
        new Song("Partim guhnyi", "Notes", "Tede", 299);
        new Song("Osodig soif dusop", "Notes", "Tede", 198);
        new Song("Abuidfo", "Notes", "Tede", 333);

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

        new Song("Powiedz", "Ad. 4", "Ich Troje", 999);
    }

}
