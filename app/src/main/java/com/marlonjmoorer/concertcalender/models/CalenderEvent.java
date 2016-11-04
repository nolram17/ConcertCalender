package com.marlonjmoorer.concertcalender.models;

import android.widget.ArrayAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by marlonmoorer on 11/3/16.
 */

public class CalenderEvent {

    public String eventText;
    public Date eventDate;

    public static CalenderEvent fromJson(JSONObject jsonObject){

        return  null;
    }
    public static List<CalenderEvent> fromJson(JSONArray jsonArray) throws JSONException{

            ArrayList<CalenderEvent> results = new ArrayList<CalenderEvent>();
            for (int i = 0; i < jsonArray.length(); i++) {
                final JSONObject jsonObj = jsonArray.getJSONObject(i);

                results.add(new CalenderEvent(){
                    {eventDate=new Date();}
                    {eventText=jsonObj.getString("name");}
                });

            }
            return results;

    }


}
