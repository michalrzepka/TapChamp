package pl.rzepka.tapchamp;

import java.util.ArrayList;

public class Library {

    private static ArrayList<Artist> artists = new ArrayList<>();

    public static ArrayList<Artist> getArtists() {
        return artists;
    }

    // adds songs to library first checking if that artist/album does not already exists in library

    public static void addToLibrary(Song song) {
        String artistName = song.getmArtistName();
        String albumTitle = song.getmAlbumTitle();
        String songTitle = song.getmSongTitle();
        if (findArtist(artistName) == null) {
            Library.artists.add(new Artist(artistName));
        }
        if (findAlbum(artistName, albumTitle) == null) {
            Library.findArtist(artistName).addAlbum(new Album(albumTitle, artistName));
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

    // add songs with duration in seconds

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

        new Song("Ja, mój walkman", "Notes", "Tede", 282);
        new Song("T.D.F.", "Notes", "Tede", 456);
        new Song("Jak żyć?", "Notes", "Tede", 231);
        new Song("Zazdrość II", "Notes", "Tede", 236);
        new Song("Sukcez", "Notes", "Tede", 226);
        new Song("Robię rap", "Notes", "Tede", 239);
        new Song("Wiem, wiem", "Notes", "Tede", 204);
        new Song("Obłęd", "Notes", "Tede", 205);
        new Song("Klaszcz! (Tedunio wieeesz)", "Notes", "Tede", 190);
        new Song("Zajawka kipi", "Notes", "Tede", 249);
        new Song("Harlekin (EEE-OOO)", "Notes", "Tede", 240);
        new Song("MercBezel S600", "Notes", "Tede", 227);
        new Song("Abonent", "Notes", "Tede", 300);
        new Song("Kochanie", "Notes", "Tede", 242);
        new Song("Ekipa Wielkie Joł", "Notes", "Tede", 222);

        new Song("Introdukcja", "Ścieżka dzwiękowa", "Tede", 214);
        new Song("22 Gibony (Diler)", "Ścieżka dzwiękowa", "Tede", 213);
        new Song("HD fotoplastikon", "Ścieżka dzwiękowa", "Tede", 226);
        new Song("Posłuchaj, to tutaj", "Ścieżka dzwiękowa", "Tede", 238);
        new Song("Air Max LTD", "Ścieżka dzwiękowa", "Tede", 236);
        new Song("Made in China", "Ścieżka dzwiękowa", "Tede", 200);
        new Song("Moje tocze fele", "Ścieżka dzwiękowa", "Tede", 259);
        new Song("Rób  PLNY", "Ścieżka dzwiękowa", "Tede", 258);
        new Song("G.R.U.B.Y.", "Ścieżka dzwiękowa", "Tede", 239);
        new Song("Skręt", "Ścieżka dzwiękowa", "Tede", 234);
        new Song("F/S 360 Kickflip", "Ścieżka dzwiękowa", "Tede", 320);
        new Song("Modopolo", "Ścieżka dzwiękowa", "Tede", 213);
        new Song("Czy jasno, czy ciemno", "Ścieżka dzwiękowa", "Tede", 291);
        new Song("Dryń, dryń, dryń", "Ścieżka dzwiękowa", "Tede", 270);
        new Song("Mówią na mnie", "Ścieżka dzwiękowa", "Tede", 207);
        new Song("Nie podoba szieeea?", "Ścieżka dzwiękowa", "Tede", 226);

        new Song("Help!", "Help!", "The Beatles", 138);
        new Song("The Night Before!", "Help!", "The Beatles", 154);
        new Song("Hide Your Love", "Help!", "The Beatles", 129);
        new Song("I Need You!", "Help!", "The Beatles", 148);
        new Song("Another Girl", "Help!", "The Beatles", 125);

        new Song("Come Together", "Abbey Road", "The Beatles", 234);
        new Song("Something", "Abbey Road", "The Beatles", 241);
        new Song("Maxwell's Silver Hammer", "Abbey Road", "The Beatles", 211);
        new Song("Oh! Darling", "Abbey Road", "The Beatles", 155);
        new Song("Octopus's Garden", "Abbey Road", "The Beatles", 166);
        new Song("I Want You", "Abbey Road", "The Beatles", 133);

        new Song("Two of Us", "Let It Be", "The Beatles", 201);
        new Song("Dig a Pony", "Let It Be", "The Beatles", 196);
        new Song("Across the Universe", "Let It Be", "The Beatles", 178);
        new Song("I Me Mine", "Let It Be", "The Beatles", 199);
        new Song("Dig It", "Let It Be", "The Beatles", 150);
        new Song("Let It Be", "Let It Be", "The Beatles", 243);
        new Song("Maggie Mae", "Let It Be", "The Beatles", 140);

        new Song("Hit the Lights", "Kill 'Em All", "Metallica", 257);
        new Song("The Four Horsemen", "Kill 'Em All", "Metallica", 433);
        new Song("Motorbreath", "Kill 'Em All", "Metallica", 188);
        new Song("Jump in the Fire", "Kill 'Em All", "Metallica", 282);
        new Song("(Anesthesia)—Pulling Teeth", "Kill 'Em All", "Metallica", 255);
        new Song("Whiplash", "Kill 'Em All", "Metallica", 249);
        new Song("Phantom Lord", "Kill 'Em All", "Metallica", 302);
        new Song("No Remorse", "Kill 'Em All", "Metallica", 432);
        new Song("Seek & Destroy", "Kill 'Em All", "Metallica", 399);
        new Song("Metal Militia", "Kill 'Em All", "Metallica", 311);

        new Song("Battery", "Master of Puppets", "Metallica", 313);
        new Song("Master of Puppets", "Master of Puppets", "Metallica", 411);
        new Song("The Thing That Should", "Master of Puppets", "Metallica", 555);
        new Song("Welcome Home (Sanitarium)", "Master of Puppets", "Metallica", 456);
        new Song("Disposable Heroes", "Master of Puppets", "Metallica", 679);
        new Song("Leper Messiah", "Master of Puppets", "Metallica", 340);
        new Song("Orion", "Master of Puppets", "Metallica", 507);
        new Song("Damage, Inc.", "Master of Puppets", "Metallica", 332);

        new Song("Intro 4", "Ad. 4", "Ich Troje", 234);
        new Song("Powiedz", "Ad. 4", "Ich Troje", 289);
        new Song("Zawsze pójdę", "Ad. 4", "Ich Troje", 245);
        new Song("Razem a jednak", "Ad. 4", "Ich Troje", 235);
        new Song("Lecz to nie to", "Ad. 4", "Ich Troje", 222);
        new Song("Dla ciebie", "Ad. 4", "Ich Troje", 245);
        new Song("To tylko chwila", "Ad. 4", "Ich Troje", 199);
        new Song("Wojenne rozkazy", "Ad. 4", "Ich Troje", 188);
        new Song("Po prostu", "Ad. 4", "Ich Troje", 255);
        new Song("Geranium", "Ad. 4", "Ich Troje", 274);
        new Song("Pierwsza ostatnia", "Ad. 4", "Ich Troje", 339);
        new Song("Zawsze z tobą", "Ad. 4", "Ich Troje", 218);
        new Song("I stało się...", "Ad. 4", "Ich Troje", 333);
        new Song("Wypijmy za to!", "Ad. 4", "Ich Troje", 234);

    }

}
