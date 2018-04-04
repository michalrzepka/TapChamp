package pl.rzepka.tapchamp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    private String artistName;
    public static final String ARTIST_NAME = "pl.rzepka.tapchamp.ARTIST_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Library.populateLibrary();

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



}
