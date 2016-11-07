package com.marlonjmoorer.concertcalender.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.marlonjmoorer.concertcalender.R;
import com.marlonjmoorer.concertcalender.models.CalenderEvent;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by marlonmoorer on 11/3/16.
 */

public class EventsAdapter extends ArrayAdapter<CalenderEvent> {

    Context context;
    int resource;

    public EventsAdapter(Context context, List<CalenderEvent> objects) {
        super(context,0, objects);
    }

    public EventsAdapter(Context context) {
        super(context,0);
    }

    static class ViewHolderItem {
        TextView date;
        TextView title;
        TextView location;
        TextView venue;
        ImageView poster;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolderItem viewHolder;
        final CalenderEvent event=getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.event_list_item, parent, false);
            viewHolder = new ViewHolderItem();
            viewHolder.title= (TextView) convertView.findViewById(R.id.titleTextView);
            viewHolder.date=(TextView)convertView.findViewById(R.id.dateTextView);
            viewHolder.location= (TextView) convertView.findViewById(R.id.locationTextView);
            viewHolder.poster= (ImageView) convertView.findViewById(R.id.poster);
            viewHolder.venue= (TextView) convertView.findViewById(R.id.venueTextView);
            // store the holder with the view.
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolderItem) convertView.getTag();
        }

        if(event != null) {
            // get the TextView from the ViewHolder and then set the text (item name) and tag (item ID) values

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date startDate = null;
            try {
                startDate = df.parse(event.getStart_time());
            } catch (ParseException e) {
                Log.e("ERR",e.getMessage());
            }

            viewHolder.date.setText(DateFormat.getDateTimeInstance().format(startDate));
            viewHolder.title.setText(event.getTitle());
            viewHolder.location.setText(event.getCity_name());
            viewHolder.venue.setText("@"+event.getVenue_name());
            if(event.getImage()!=null){
               // viewHolder.poster.setImageBitmap(event.img);
                Picasso.with(getContext()).load(event.getImage().getUrl()).into(viewHolder.poster);
            }

        }



        return convertView;
    }
}
