package pl.rzepka.tapchamp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class AlbumActivity extends AppCompatActivity {

    String artistName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);

        Intent albumsIntent = getIntent();
        artistName = albumsIntent.getStringExtra(MainActivity.ARTIST_NAME);

        setTitle(artistName);

        ArrayList<Album> artistAlbums = new ArrayList<Album>();

        for (Artist artist : Library.getLibrary()) {
            if (artist.getmArtistName().equals(artistName)) {
                artistAlbums = artist.getmAlbums();
            }
        }

        AlbumAdapter albumAdapter = new AlbumAdapter(this, artistAlbums);
        final ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(albumAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Album album = (Album) listView.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "You selected : " + album.getmAlbumTitle(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}






//        Artist artistToFind = new Artist(artistName);
//        Log.v("find1", Library.getLibrary().get(0).toString());
//        Log.v("find2", artistToFind.toString());
//        int artistId = Library.getLibrary().indexOf(artistToFind);
//        Log.v("find3", artistId + "");
//        Artist artist = Library.getLibrary().get(artistId);
//        ArrayList<Album> artistAlbums = artist.getmAlbums();
//        return artistAlbums;
//    }
//
//}
