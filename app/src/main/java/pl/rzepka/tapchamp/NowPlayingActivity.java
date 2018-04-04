package pl.rzepka.tapchamp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;

public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nowplaying);

        LinkedList<Song> nowPlaying = Playlist.playlist;

        NowPlayingAdapter playlistAdapter = new NowPlayingAdapter(this, nowPlaying);
        final ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(playlistAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song song = (Song) listView.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "You selected : " + song.getmSongTitle(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
