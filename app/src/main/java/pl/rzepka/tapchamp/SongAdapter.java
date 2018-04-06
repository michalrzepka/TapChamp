package pl.rzepka.tapchamp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter(Activity context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_item, parent, false);
        }

        Song currentSong = getItem(position);

        TextView trackNumberView = (TextView) listItemView.findViewById(R.id.track_number_text_view);
        String trackNumber = position+1 + ".";
        trackNumberView.setText(trackNumber);

        TextView songTitleView = (TextView) listItemView.findViewById(R.id.song_title_text_view);
        String songTitle = currentSong.getmSongTitle();
        songTitleView.setText(songTitle);

        TextView songDurationView = (TextView) listItemView.findViewById(R.id.song_duration_text_view);
        String songDuration = String.format("(%02d:%02d)", currentSong.getmDuration() / 60, currentSong.getmDuration() % 60);
        songDurationView.setText(songDuration);

        TextView albumArtistView = (TextView) listItemView.findViewById(R.id.album_artist_text_view);
        String albumTitle = currentSong.getmAlbumTitle();
        String artistName = currentSong.getmArtistName();
        String albumArtist = String.format("%s – %s", albumTitle, artistName);
        albumArtistView.setText(albumArtist);

        return listItemView;
    }
}
