package pl.rzepka.tapchamp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SongsActivity extends AppCompatActivity {

    private String artistName;
    private String albumTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);

        Intent songsIntent = getIntent();
        artistName = songsIntent.getStringExtra(AlbumsActivity.ARTIST_NAME);
        albumTitle = songsIntent.getStringExtra(AlbumsActivity.ALBUM_TITLE);
        setTitle(albumTitle);

        ArrayList<Song> albumSongs = Library.findAlbum(artistName, albumTitle).getmSongs();


        SongAdapter songsAdapter = new SongAdapter(this, albumSongs);
        final ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(songsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song song = (Song) listView.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "You selected : " + song.getmSongTitle(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
