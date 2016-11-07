package com.marlonjmoorer.concertcalender.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.marlonjmoorer.concertcalender.R;
import com.marlonjmoorer.concertcalender.activities.DetailActivity;
import com.marlonjmoorer.concertcalender.adapters.EventsAdapter;
import com.marlonjmoorer.concertcalender.helpers.FetchEventsTask;
import com.marlonjmoorer.concertcalender.models.CalenderEvent;
import com.marlonjmoorer.concertcalender.models._OldCalenderEvent;

/**
 * Created by marlonmoorer on 11/5/16.
 */



public class EventListFragment extends Fragment implements AdapterView.OnItemClickListener{

    ListView eventListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_events, container, false);
        EventsAdapter adapter= new EventsAdapter(getActivity());
        eventListView=(ListView)view.findViewById(R.id.eventsListView);
        eventListView.setAdapter(adapter);

        new FetchEventsTask(adapter).execute();
        eventListView.setOnItemClickListener(this);
        return view ;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        CalenderEvent e = (CalenderEvent) parent.getItemAtPosition(position);

        Intent intent= new Intent(getActivity(), DetailActivity.class);
        intent.putExtra(DetailActivity.DETAIL_KEY,new Gson().toJson(e));
        startActivity(intent);

    }
}
