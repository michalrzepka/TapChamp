package pl.rzepka.tapchamp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AlbumsActivity extends AppCompatActivity {

    private String artistName;
    private String albumTitle;
    public static final String ARTIST_NAME = "pl.rzepka.tapchamp.ARTIST_NAME";
    public static final String ALBUM_TITLE = "pl.rzepka.tapchamp.ALBUM_TITLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);

        Intent albumsIntent = getIntent();
        artistName = albumsIntent.getStringExtra(MainActivity.ARTIST_NAME);
        setTitle(artistName);

        ArrayList<Album> artistAlbums = Library.findArtist(artistName).getmAlbums();

        Collections.sort(artistAlbums, new Comparator<Album>() {
            public int compare(Album album1, Album album2) {
                return album1.getmAlbumTitle().compareTo(album2.getmAlbumTitle());
            }
        });

        AlbumAdapter albumAdapter = new AlbumAdapter(this, artistAlbums);
        final ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(albumAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Album album = (Album) listView.getItemAtPosition(position);
                albumTitle = album.getmAlbumTitle();
                Intent songsIntent = new Intent (AlbumsActivity.this, SongsActivity.class);
                songsIntent.putExtra(ARTIST_NAME, artistName);
                songsIntent.putExtra(ALBUM_TITLE, albumTitle);
                startActivity(songsIntent);
            }
        });
    }
}
