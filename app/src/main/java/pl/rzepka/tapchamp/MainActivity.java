package pl.rzepka.tapchamp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    // variables for intent putExtra

    private String artistName;
    public static final String ARTIST_NAME = "pl.rzepka.tapchamp.ARTIST_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        //initiates library and adds covers to albums - probably covers should be covered in constructor but I wrote that part later and din't want to rebuild established classes

        Library.populateLibrary();
        Library.findAlbum("Tede", "Esende Mylffon").setmAlbumCover(R.drawable.tede_essende_mylffon);
        Library.findAlbum("Tede", "Notes").setmAlbumCover(R.drawable.tede_notes);
        Library.findAlbum("Tede", "Ścieżka dzwiękowa").setmAlbumCover(R.drawable.tede_sciezka_dzwiekowa);
        Library.findAlbum("The Beatles", "Help!").setmAlbumCover(R.drawable.the_beatles_help);
        Library.findAlbum("The Beatles", "Let It Be").setmAlbumCover(R.drawable.the_beatles_let_it_be);
        Library.findAlbum("The Beatles", "Abbey Road").setmAlbumCover(R.drawable.the_beatles_1);
        Library.findAlbum("Metallica", "Kill 'Em All").setmAlbumCover(R.drawable.metallica_kill_em_all);
        Library.findAlbum("Metallica", "Master of Puppets").setmAlbumCover(R.drawable.metallica_master_of_puppets);
        Library.findAlbum("Ich Troje", "Ad. 4").setmAlbumCover(R.drawable.ich_troje_ad4);

        // sort artist alphabetically

        Collections.sort(Library.getArtists(), new Comparator<Artist>() {
            public int compare(Artist artist1, Artist artist2) {
                return artist1.getmArtistName().compareTo(artist2.getmArtistName());
            }
        });

        ArtistAdapter artistAdapter = new ArtistAdapter(this, Library.getArtists());
        final ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(artistAdapter);

        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Artist artist = (Artist) listView.getItemAtPosition(position);
                artistName = artist.getmArtistName();
                Intent albumsIntent = new Intent (MainActivity.this, AlbumsActivity.class);
                albumsIntent.putExtra(ARTIST_NAME, artistName);
                startActivity(albumsIntent);
            }
        });

    }

    // toolbar icon that takes user to now playing section

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.now_playing:
                Intent nowPlayingIntent = new Intent(this, NowPlayingActivity.class);
                this.startActivity(nowPlayingIntent);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

}
