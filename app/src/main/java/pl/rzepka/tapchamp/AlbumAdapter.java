package pl.rzepka.tapchamp;

import android.app.Activity;
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

        Album currentAlbum = getItem(position);

        TextView albumTitleView = (TextView) listItemView.findViewById(R.id.album_title_text_view);
        String albumTitle = String.format("%s (%d songs)", currentAlbum.getmAlbumTitle(), currentAlbum.getNumberOfSongs());
        albumTitleView.setText(albumTitle);

        return listItemView;
    }
}
