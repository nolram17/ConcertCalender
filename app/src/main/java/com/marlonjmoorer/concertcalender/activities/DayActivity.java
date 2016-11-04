package com.marlonjmoorer.concertcalender.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.marlonjmoorer.concertcalender.R;

import java.util.Date;

public class DayActivity extends AppCompatActivity {

    static public final  String DATE_EXTRA="DATE_EXTRA";
    TextView todayText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);

        Intent intent= getIntent();

        Date day = (Date)intent.getSerializableExtra(DATE_EXTRA);
        todayText=(TextView)findViewById(R.id.today_date);
        todayText.setText(day.toString());
        Toast.makeText(this,day.toString(),Toast.LENGTH_LONG).show();


    }

}
