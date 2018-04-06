package pl.rzepka.tapchamp;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ArtistAdapter extends ArrayAdapter<Artist> {

    public ArtistAdapter(Activity context, ArrayList<Artist> artists) {
        super(context, 0, artists);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.artist_item, parent, false);
        }

        final Artist currentArtist = getItem(position);

        TextView artistNameView = (TextView) listItemView.findViewById(R.id.artist_name_text_view);
        artistNameView.setText(currentArtist.getmArtistName());

        ImageView playAlbumView = (ImageView) listItemView.findViewById(R.id.play_album_button);
        playAlbumView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Playlist.playlist.clear();
                Playlist.addArtist(currentArtist);
                Intent playlistIntent = new Intent (view.getContext(), NowPlayingActivity.class);
                view.getContext().startActivity(playlistIntent);
            }
        });

        ImageView addToPlaylist = (ImageView) listItemView.findViewById(R.id.add_to_playlist_button);
        addToPlaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Playlist.addArtist(currentArtist);
                Intent playlistIntent = new Intent (view.getContext(), NowPlayingActivity.class);
                view.getContext().startActivity(playlistIntent);
            }
        });

        return listItemView;
    }
}
