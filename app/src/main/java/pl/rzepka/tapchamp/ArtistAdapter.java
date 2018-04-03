package pl.rzepka.tapchamp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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

        Artist currentArtist = getItem(position);

        TextView artistName = (TextView) listItemView.findViewById(R.id.artist_name_text_view);
        artistName.setText(currentArtist.getmArtistName());

        return listItemView;
    }
}
