package com.marlonjmoorer.concertcalender.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CalendarView;
import android.widget.ListView;

import com.marlonjmoorer.concertcalender.R;
import com.marlonjmoorer.concertcalender.adapters.EventsAdapter;
import com.marlonjmoorer.concertcalender.helpers.FetchEventsTask;
import com.marlonjmoorer.concertcalender.models.CalenderEvent;

import java.util.ArrayList;
import java.util.Date;

public class CalenderActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    CalendarView calendarView;
    ListView eventList;
    EventsAdapter adapter;
    ArrayList<CalenderEvent> items= new ArrayList<CalenderEvent>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);


        ///

        adapter= new EventsAdapter(this,items);
        eventList= (ListView)findViewById(R.id.eventsListView);
        calendarView= (CalendarView)findViewById(R.id.calendarView);


        eventList.setAdapter(adapter);
        new FetchEventsTask(adapter).execute();

        calendarView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;
            }
        });

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                //String date= String.format("%1$d/%2$d/%3$d",month,dayOfMonth,year);
                Date date= new Date();
                date.setMonth(month);
                date.setDate(dayOfMonth);
                date.setYear(year);

                Intent i= new Intent(CalenderActivity.this,DayActivity.class);
                i.putExtra(DayActivity.DATE_EXTRA,date);
               // startActivity(i);

            }
        });



    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
