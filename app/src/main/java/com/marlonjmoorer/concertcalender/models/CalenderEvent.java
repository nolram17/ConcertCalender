package com.marlonjmoorer.concertcalender.models;

import android.widget.ArrayAdapter;
import android.widget.ImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by marlonmoorer on 11/3/16.
 */

public class CalenderEvent {

    public String eventText;
    public Date eventDate;
    public String location;
    public String venue;
    public String imgUrl;


    public static CalenderEvent fromJson(JSONObject jsonObject){

        return  null;
    }


    public static List<CalenderEvent> listFromJson(JSONArray jsonArray) throws JSONException,ParseException{

            ArrayList<CalenderEvent> results = new ArrayList<CalenderEvent>();
            for (int i = 0; i < jsonArray.length(); i++) {
                final JSONObject jsonObj = jsonArray.getJSONObject(i);

                DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                final Date startDate = df.parse(jsonObj.getString("start_time"));
                results.add(new CalenderEvent(){
                    {eventDate=startDate;}
                    {eventText=jsonObj.getString("title");}
                    //{location= formatLocation(jsonObj);}
                     {venue=jsonObj.getString("venue_name");}
                     {imgUrl=jsonObj.getJSONObject("image")
                            .getJSONObject("thumb")
                            .getString("url");}

                });

            }
            return results;

    }
    public static List<CalenderEvent> listFromJson(JSONObject jsonObject) throws JSONException,ParseException{

        JSONArray jsonArray= jsonObject.getJSONObject("events").getJSONArray("event");
        return listFromJson(jsonArray);

    }


    private static String formatLocation (JSONObject jsonObject) throws JSONException {

        String city=jsonObject.getString("city_name");
        String region=jsonObject.getString("region_name");
        String regionAbreviation= jsonObject.getString("region_abbr");
        String countryCode= jsonObject.getString("country_abbr2");
        String zip=jsonObject.getString("postal_code");

        return city+","+regionAbreviation+","+countryCode+" "+zip;
    }



}
