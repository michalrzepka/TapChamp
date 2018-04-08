package pl.rzepka.tapchamp;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;

public class NowPlayingAdapter extends ArrayAdapter<Song> {

    public NowPlayingAdapter(Activity context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.playlist_item, parent, false);
        }

        final Song currentSong = getItem(position);

        TextView songTitleView = (TextView) listItemView.findViewById(R.id.song_title_text_view);
        String songTitle = currentSong.getmSongTitle();
        songTitleView.setText(songTitle);

        TextView songDurationView = (TextView) listItemView.findViewById(R.id.song_duration_text_view);
        String songDuration = String.format("(%02d:%02d)", currentSong.getmDuration() / 60, currentSong.getmDuration() % 60);
        songDurationView.setText(songDuration);

        TextView albumTitleView = (TextView) listItemView.findViewById(R.id.album_title_text_view);
        String albumTitle = currentSong.getmAlbumTitle();
        albumTitleView.setText(albumTitle);

        TextView artistNameView = (TextView) listItemView.findViewById(R.id.artist_name_text_view);
        String artistName = currentSong.getmArtistName();
        artistNameView.setText(artistName);

        ImageView removeFromPlaylist = (ImageView) listItemView.findViewById(R.id.remove_from_playlist_button);
        removeFromPlaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentSong != NowPlayingActivity.nowPlayingSong) {
                    Playlist.removeSong(currentSong);
                    notifyDataSetChanged();
                } else {
                    Toast.makeText(getContext(), "Song is playing now, can not delete", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return listItemView;
    }
}
