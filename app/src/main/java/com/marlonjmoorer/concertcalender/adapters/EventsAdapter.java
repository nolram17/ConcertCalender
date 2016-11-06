package com.marlonjmoorer.concertcalender.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.marlonjmoorer.concertcalender.R;
import com.marlonjmoorer.concertcalender.models.CalenderEvent;

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
        TextView eventText;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolderItem viewHolder;
        CalenderEvent event=getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.event_list_item, parent, false);
            viewHolder = new ViewHolderItem();
            viewHolder.eventText= (TextView) convertView.findViewById(R.id.detailsTextView);
            viewHolder.date=(TextView)convertView.findViewById(R.id.dateTextView);
            // store the holder with the view.
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolderItem) convertView.getTag();
        }

        if(event != null) {
            // get the TextView from the ViewHolder and then set the text (item name) and tag (item ID) values
            viewHolder.date.setText(event.eventDate.toString());
            viewHolder.eventText.setText(event.eventText);
        }




        return convertView;
    }
}
