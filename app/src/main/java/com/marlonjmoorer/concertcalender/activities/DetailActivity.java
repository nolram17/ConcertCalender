package com.marlonjmoorer.concertcalender.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.marlonjmoorer.concertcalender.R;
import com.marlonjmoorer.concertcalender.models.CalenderEvent;

public class DetailActivity extends AppCompatActivity {

    public static final String DETAIL_KEY="detail_key";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        CalenderEvent calenderEvent;

        String data= getIntent().getStringExtra(DETAIL_KEY);

        calenderEvent= new Gson().fromJson(data,CalenderEvent.class);

        TextView title= (TextView) findViewById(R.id.title);
        TextView venue= (TextView) findViewById(R.id.venue);

        title.setText(calenderEvent.getTitle());
        venue.setText(calenderEvent.getVenue_name());

    }
}
