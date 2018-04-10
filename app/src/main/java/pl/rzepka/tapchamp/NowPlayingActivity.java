package pl.rzepka.tapchamp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NowPlayingActivity extends AppCompatActivity {

    static ArrayList<Song> nowPlayingList = Playlist.playlist;
    static Song nowPlayingSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nowplaying);

        Toolbar titleToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(titleToolbar);

        //play first song on the list when entering activity for the first time - if playlist not empty
        //play last playing song when reentering activty

        if (nowPlayingList.size() != 0 && nowPlayingSong == null) { //play first song when entering activity if playlist not empty
            playNow(nowPlayingList.get(0));
        } else if (nowPlayingSong != null) {
            playNow(nowPlayingSong);
        }

        NowPlayingAdapter playlistAdapter = new NowPlayingAdapter(this, nowPlayingList);
        final ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(playlistAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song song = (Song) listView.getItemAtPosition(position);
                playNow(song);

            }
        });

        ImageView nextView = (ImageView) findViewById(R.id.next_button);
        nextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playNext();
            }
        });

        ImageView prevView = (ImageView) findViewById(R.id.prev_button);
        prevView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playPrev();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.library, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.library:
                onBackPressed();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    // populate main part of the screen with album cover and song detials

    private void playNow(Song song) {
        ImageView nowPlayingCoverView = (ImageView) findViewById(R.id.now_playing_cover);
        int albumCover = Library.findAlbum(song.getmArtistName(), song.getmAlbumTitle()).getmAlbumCover();
        nowPlayingCoverView.setImageResource(albumCover);
        TextView nowPlayingTitleView = (TextView) findViewById(R.id.now_playing_title_text_view);
        nowPlayingTitleView.setText(song.getmSongTitle());
        TextView nowPlayingAlbumView = (TextView) findViewById(R.id.now_playing_album_artist_text_view);
        String albumArtist = String.format("%s – %s", song.getmAlbumTitle(), song.getmArtistName());
        nowPlayingAlbumView.setText(albumArtist);
        nowPlayingSong = song;
    }

    // playNext and playPrev looks for currently playing song and then go +1/-1 in Array List, exceptions added so
    // list will loop when going prev/next on first/last item; also checks if playlist is not empty to prevent exception throw

    public void playNext() {
        if (nowPlayingList.size() != 0) {
            int nextToPlay = nowPlayingList.indexOf(nowPlayingSong) + 1;
            if (nextToPlay < nowPlayingList.size()) {
                playNow(nowPlayingList.get(nextToPlay));
            } else {
                playNow(nowPlayingList.get(0));
            }
        }
    }

    public void playPrev() {
        if (nowPlayingList.size() != 0) {
            int prevToPlay = nowPlayingList.indexOf(nowPlayingSong) - 1;
            if (prevToPlay >= 0) {
                playNow(nowPlayingList.get(prevToPlay));
            } else {
                playNow(nowPlayingList.get(nowPlayingList.size() - 1));
            }
        }
    }
}
