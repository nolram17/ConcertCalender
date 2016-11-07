package com.marlonjmoorer.concertcalender.models;

import android.graphics.Bitmap;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by marlonmoorer on 11/3/16.
 */

public class _OldCalenderEvent {

    public String eventText;
    public Date eventDate;
    public String location;
    public String venue;
    public String imgUrl;
    public Bitmap img;
    public String eventId;



    public static _OldCalenderEvent fromJson(JSONObject jsonObj)throws Exception{


        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final Date startDate = df.parse(jsonObj.getString("start_time"));
        _OldCalenderEvent event=  new _OldCalenderEvent();


        event.eventId=jsonObj.getString("id");
        event.eventDate=startDate;
        event.eventText=jsonObj.getString("title");
        event.location= formatLocation(jsonObj);
        event.venue= jsonObj.getString("venue_name");


        JSONObject img= jsonObj.optJSONObject("image");
        if(img!=null){

            event.imgUrl= img.getJSONObject("medium")
                             .getString("url");
           // new DownloadImageTask(event).execute(imgUrl);

        }


        return event;
    }


    public static List<_OldCalenderEvent> listFromJson(JSONArray jsonArray) throws Exception{

            ArrayList<_OldCalenderEvent> results = new ArrayList<_OldCalenderEvent>();
            for (int i = 0; i < jsonArray.length(); i++) {
                final JSONObject jsonObj = jsonArray.getJSONObject(i);
                results.add(fromJson(jsonObj));
            }
            return results;

    }
    public static List<_OldCalenderEvent> listFromJson(JSONObject jsonObject) throws Exception{

        JSONArray jsonArray= jsonObject.getJSONObject("events").getJSONArray("event");
        return listFromJson(jsonArray);

    }


    private static String formatLocation (JSONObject jsonObject) throws Exception {

        String city=jsonObject.getString("city_name");
        String region=jsonObject.getString("region_name");
        String regionAbreviation= jsonObject.getString("region_abbr");
        String countryCode= jsonObject.getString("country_abbr2");
        String zip=jsonObject.getString("postal_code");

        return city+","+regionAbreviation+","+countryCode+" "+zip;
    }



}
