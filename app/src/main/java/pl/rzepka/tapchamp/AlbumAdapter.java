package pl.rzepka.tapchamp;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

        ImageView albumCoverView = (ImageView) listItemView.findViewById(R.id.album_cover);
        albumCoverView.setImageResource(currentAlbum.getmAlbumCover());
        TextView albumTitleView = (TextView) listItemView.findViewById(R.id.album_title_text_view);
        String albumTitle = currentAlbum.getmAlbumTitle();
        albumTitleView.setText(albumTitle);
        TextView albumInfoView = (TextView) listItemView.findViewById(R.id.album_info_text_view);
        String albumDuration = String.format("%02d:%02d", currentAlbum.getAlbumDuration() / 60, currentAlbum.getAlbumDuration() % 60);
        int trackCount = currentAlbum.getNumberOfSongs();
        String albumInfo = String.format("(%s – %d tracks)", albumDuration, trackCount);
        albumInfoView.setText(albumInfo);

        ImageView playAlbumView = (ImageView) listItemView.findViewById(R.id.play_album_button);
        playAlbumView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Playlist.playlist.clear();
                Playlist.addAlbum(currentAlbum);
                NowPlayingActivity.nowPlayingSong = null;
                Toast.makeText(getContext(), "Now playing " + currentAlbum.getmAlbumTitle(), Toast.LENGTH_SHORT).show();
                Intent playlistIntent = new Intent(view.getContext(), NowPlayingActivity.class);
                view.getContext().startActivity(playlistIntent);
            }
        });

        ImageView addToPlaylist = (ImageView) listItemView.findViewById(R.id.add_to_playlist_button);
        addToPlaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Playlist.addAlbum(currentAlbum);
                Toast.makeText(getContext(), currentAlbum.getmAlbumTitle() + " added to playlist", Toast.LENGTH_SHORT).show();
                Intent playlistIntent = new Intent(view.getContext(), NowPlayingActivity.class);
                view.getContext().startActivity(playlistIntent);
            }
        });

        return listItemView;
    }
}
