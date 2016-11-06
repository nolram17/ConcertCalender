package com.marlonjmoorer.concertcalender.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.marlonjmoorer.concertcalender.R;
import com.marlonjmoorer.concertcalender.adapters.EventsAdapter;
import com.marlonjmoorer.concertcalender.helpers.FetchEventsTask;

/**
 * Created by marlonmoorer on 11/5/16.
 */



public class EventListFragment extends Fragment {

    ListView eventListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_events, container, false);
        EventsAdapter adapter= new EventsAdapter(getActivity());
        eventListView=(ListView)view.findViewById(R.id.eventsListView);
        eventListView.setAdapter(adapter);

        new FetchEventsTask(adapter).execute();
        return view ;
    }
}
