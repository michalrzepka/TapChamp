package pl.rzepka.tapchamp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String artistName;
    public static final String ARTIST_NAME = "pl.rzepka.tapchamp.ARTIST_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArtistAdapter artistAdapter = new ArtistAdapter(this, Library.getLibrary());
        final ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(artistAdapter);


        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Artist artist = (Artist) listView.getItemAtPosition(position);
                artistName = artist.getmArtistName().toString();
                Log.v("Artist Passed", artistName);

                Intent albumsIntent = new Intent (MainActivity.this, AlbumActivity.class);
                albumsIntent.putExtra(ARTIST_NAME, artistName);
                startActivity(albumsIntent);
            }
        });

    }

}
