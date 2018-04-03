package pl.rzepka.tapchamp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Library {

    public static void main(String[] args) {
        getLibrary();
    }

    public static ArrayList<Artist> getLibrary() {

        ArrayList<Artist> artists = new ArrayList<>();
        artists.add(new Artist("Tede"));
        artists.get(0).addAlbum(new Album("Esende Mylffon"));
        artists.get(0).getmAlbums().get(0).addSong(new Song("Wstępizille", "1:52"));
        artists.get(0).getmAlbums().get(0).addSong(new Song("Blask", "4:04"));
        artists.get(0).getmAlbums().get(0).addSong(new Song("Hity na czasie", "3:42"));
        artists.get(0).getmAlbums().get(0).addSong(new Song("Glokk", "5:00"));
        artists.get(0).getmAlbums().get(0).addSong(new Song("Airmax Classic", "4:34"));
        artists.get(0).addAlbum(new Album("Notes"));
        artists.get(0).getmAlbums().get(1).addSong(new Song("", "1:00"));
        artists.get(0).getmAlbums().get(1).addSong(new Song("", "1:00"));
        artists.get(0).getmAlbums().get(1).addSong(new Song("", "1:00"));
        artists.get(0).getmAlbums().get(1).addSong(new Song("", "1:00"));
        artists.get(0).getmAlbums().get(1).addSong(new Song("", "1:00"));
        artists.get(0).getmAlbums().get(1).addSong(new Song("", "1:00"));
        artists.get(0).getmAlbums().get(1).addSong(new Song("", "1:00"));
        artists.get(0).getmAlbums().get(1).addSong(new Song("", "1:00"));
        artists.get(0).getmAlbums().get(1).addSong(new Song("", "1:00"));
        artists.get(0).addAlbum(new Album("S.P.O.R.T."));
        artists.get(0).getmAlbums().get(2).addSong(new Song("", "1:00"));
        artists.get(0).getmAlbums().get(2).addSong(new Song("", "1:00"));
        artists.get(0).getmAlbums().get(2).addSong(new Song("", "1:00"));
        artists.get(0).getmAlbums().get(2).addSong(new Song("", "1:00"));
        artists.get(0).getmAlbums().get(2).addSong(new Song("", "1:00"));
        artists.get(0).getmAlbums().get(2).addSong(new Song("", "1:00"));

        artists.add(new Artist("The Beatles"));
        artists.get(1).addAlbum(new Album("Help!"));
        artists.get(1).getmAlbums().get(0).addSong(new Song("Help!", "2:18"));
        artists.get(1).getmAlbums().get(0).addSong(new Song("The Night Before", "2:34"));
        artists.get(1).getmAlbums().get(0).addSong(new Song("You've Got to Hide Your Love Away", "2:09"));
        artists.get(1).getmAlbums().get(0).addSong(new Song("I Need You", "2:28"));
        artists.get(1).getmAlbums().get(0).addSong(new Song("Another Girl", "2:05"));
        artists.get(1).addAlbum(new Album("Abbey Road"));
        artists.get(1).getmAlbums().get(1).addSong(new Song("", "1:00"));
        artists.get(1).getmAlbums().get(1).addSong(new Song("", "1:00"));
        artists.get(1).getmAlbums().get(1).addSong(new Song("", "1:00"));
        artists.get(1).addAlbum(new Album("Let It Be"));
        artists.get(1).getmAlbums().get(2).addSong(new Song("", "1:00"));
        artists.get(1).getmAlbums().get(2).addSong(new Song("", "1:00"));
        artists.get(1).getmAlbums().get(2).addSong(new Song("", "1:00"));
        artists.get(1).getmAlbums().get(2).addSong(new Song("", "1:00"));
        artists.get(1).getmAlbums().get(2).addSong(new Song("", "1:00"));
        artists.get(1).getmAlbums().get(2).addSong(new Song("", "1:00"));
        artists.get(1).getmAlbums().get(2).addSong(new Song("", "1:00"));

        artists.add(new Artist("Ich Troje"));
        artists.get(2).addAlbum(new Album("Ad. 4"));
        artists.get(2).getmAlbums().get(0).addSong(new Song("Intro 4", "0:56"));
        artists.get(2).getmAlbums().get(0).addSong(new Song("Powiedz", "4:06"));
        artists.get(2).getmAlbums().get(0).addSong(new Song("Zawsze pójdę w twoją stronę", "3:51"));
        artists.get(2).getmAlbums().get(0).addSong(new Song("Razem a jednak osobno", "4:10"));
        artists.get(2).getmAlbums().get(0).addSong(new Song("Lecz to nie to", "3:21"));

        artists.add(new Artist("Metallica"));
        artists.get(3).addAlbum(new Album("Kill 'Em All"));
        artists.get(3).getmAlbums().get(0).addSong(new Song("Hit the Lights", "4:17"));
        artists.get(3).getmAlbums().get(0).addSong(new Song("The Four Horsemen", "7:13"));
        artists.get(3).getmAlbums().get(0).addSong(new Song("Motorbreath", "3:08"));
        artists.get(3).getmAlbums().get(0).addSong(new Song("Jump in the Fire", "4:42"));
        artists.get(3).getmAlbums().get(0).addSong(new Song("(Anesthesia)—Pulling Teeth", "4:15"));
        artists.get(3).addAlbum(new Album("Master of Puppets "));
        artists.get(3).getmAlbums().get(1).addSong(new Song("", "1:00"));
        artists.get(3).getmAlbums().get(1).addSong(new Song("", "1:00"));
        artists.get(3).getmAlbums().get(1).addSong(new Song("", "1:00"));
        artists.get(3).getmAlbums().get(1).addSong(new Song("", "1:00"));
        artists.get(3).getmAlbums().get(1).addSong(new Song("", "1:00"));
        artists.get(3).getmAlbums().get(1).addSong(new Song("", "1:00"));
        artists.get(3).getmAlbums().get(1).addSong(new Song("", "1:00"));
        artists.get(3).getmAlbums().get(1).addSong(new Song("", "1:00"));
        artists.get(3).getmAlbums().get(1).addSong(new Song("", "1:00"));

        Collections.sort(artists, new Comparator<Artist>() {
            public int compare(Artist artist1, Artist artist2) {
                return artist1.getmArtistName().compareTo(artist2.getmArtistName());
            }
        });



        return artists;

    }
}
