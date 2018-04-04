package pl.rzepka.tapchamp;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AlbumAdapter extends ArrayAdapter<Album> {

    public AlbumAdapter(Activity context, ArrayList<Album> albums) {
        super(context, 0, albums);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.album_item, parent, false);
        }

        final Album currentAlbum = getItem(position);

        TextView albumTitleView = (TextView) listItemView.findViewById(R.id.album_title_text_view);
        String albumTitle = currentAlbum.getmAlbumTitle();
        albumTitleView.setText(albumTitle);
        TextView albumInfoView = (TextView) listItemView.findViewById(R.id.album_info_text_view);
        String albumDuration = String.format("%02d:%02d", currentAlbum.getAlbumDuration() / 60, currentAlbum.getAlbumDuration() % 60);
        int trackCount = currentAlbum.getNumberOfSongs();
        String albumInfo = String.format("(%s – %d tracks)", albumDuration, trackCount);
        albumInfoView.setText(albumInfo);

        TextView addToPlaylist = (TextView)listItemView.findViewById(R.id.add_to_playlist_button);
        addToPlaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Playlist.addAlbum(currentAlbum);
                Intent playlistIntent = new Intent (view.getContext(), NowPlayingActivity.class);
                view.getContext().startActivity(playlistIntent);
            }
        });

        return listItemView;
    }
}
