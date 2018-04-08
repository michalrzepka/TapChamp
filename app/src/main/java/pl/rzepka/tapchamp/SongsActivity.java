package pl.rzepka.tapchamp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
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
        setContentView(R.layout.activity_songs);

        Toolbar titleToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(titleToolbar);

        Intent songsIntent = getIntent();
        artistName = songsIntent.getStringExtra(AlbumsActivity.ARTIST_NAME);
        albumTitle = songsIntent.getStringExtra(AlbumsActivity.ALBUM_TITLE);
        getSupportActionBar().setTitle(albumTitle + " - " + artistName);

        // find song to display in this view based on album title and artist name from previous activity

        ArrayList<Song> albumSongs = Library.findAlbum(artistName, albumTitle).getmSongs();

        SongAdapter songsAdapter = new SongAdapter(this, albumSongs);
        final ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(songsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song song = (Song) listView.getItemAtPosition(position);
                Playlist.playlist.add(0, song);
                NowPlayingActivity.nowPlayingSong = null;
                Toast.makeText(view.getContext(), "Now playing " + song.getmSongTitle(), Toast.LENGTH_SHORT).show();
                Intent playlistIntent = new Intent(SongsActivity.this, NowPlayingActivity.class);
                startActivity(playlistIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
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
