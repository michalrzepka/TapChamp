package pl.rzepka.tapchamp;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class NowPlayingActivity extends AppCompatActivity {

    static LinkedList<Song> nowPlaying = Playlist.playlist;
    static ListIterator<Song> playListIterator = nowPlaying.listIterator();
    boolean goingForward = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nowplaying);

        if (nowPlaying.size() != 0) {
            playNow(playListIterator.next());
        }

        NowPlayingAdapter playlistAdapter = new NowPlayingAdapter(this, nowPlaying);
        final ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(playlistAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song song = (Song) listView.getItemAtPosition(position);
                playNow(song);

                // sets iterator to the correct position after tapping song on the list so the prev/next button will work correctly
                while(playListIterator.hasNext() && playListIterator.next() != song) {
                    playListIterator.next();
                    goingForward = false;
                }
                while (playListIterator.hasPrevious() && playListIterator.previous() != song) {
                    playListIterator.previous();
                }
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
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

    public static void removeSongFromIterator(Song song) {
        while(playListIterator.hasNext() && playListIterator.next() != song) {
            playListIterator.next();
        }
    }

    private void playNow(Song song) {
        ImageView nowPlayingCoverView = (ImageView) findViewById(R.id.now_playing_cover);
        int albumCover = Library.findAlbum(song.getmArtistName(), song.getmAlbumTitle()).getmAlbumCover();
        nowPlayingCoverView.setImageResource(albumCover);
        TextView nowPlayingTitleView = (TextView) findViewById(R.id.now_playing_title_text_view);
        nowPlayingTitleView.setText(song.getmSongTitle());
        TextView nowPlayingAlbumView = (TextView) findViewById(R.id.now_playing_album_artist_text_view);
        String albumArtist = String.format("%s – %s", song.getmAlbumTitle(), song.getmArtistName());
        nowPlayingAlbumView.setText(albumArtist);
    }

    private void playNext() {
        if (!goingForward) {
            if (playListIterator.hasNext()) {
                playListIterator.next();
            }
            goingForward = true;
        }
        if (playListIterator.hasNext()) {
            playNow(playListIterator.next());
        } else {
            playListIterator.previous();
            playNow(playListIterator.next());
        }
    }

    private void playPrev() {
        if (goingForward) {
            if (playListIterator.hasPrevious()) {
                playListIterator.previous();
            }
            goingForward = false;
        }
        if (playListIterator.hasPrevious()) {
            playNow(playListIterator.previous());
        } else {
            playNow(playListIterator.next());
        }
    }
}
