package com.marlonjmoorer.concertcalender.helpers;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.marlonjmoorer.concertcalender.models.CalenderEvent;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by marlonmoorer on 11/4/16.
 */

public class FetchEventsTask extends AsyncTask<Void,Void,JSONObject> {

    ArrayAdapter<CalenderEvent> adapter;
    public FetchEventsTask(ArrayAdapter<CalenderEvent> arrayAdapter) {
        super();
        this.adapter=arrayAdapter;
    }

    @Override
    protected JSONObject doInBackground(Void... params) {
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;

        try {



            Uri builtUri = Uri.parse("http://api.eventful.com/json/events/search")
            .buildUpon()
            .appendQueryParameter(QueryParams.location,"22312" )
            .appendQueryParameter(QueryParams.within, "25")
            .appendQueryParameter(QueryParams.keywords,"Rap")
            .appendQueryParameter(QueryParams.sort_order,"date")
            .appendQueryParameter(QueryParams.page_size,"100")
            .appendQueryParameter(QueryParams.app_key,"BxBfJK2sTK3gQ58v")
            .build();



            URL url = new URL(builtUri.toString());
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // Read the input stream into a String
            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            if (inputStream == null) {
                // Nothing to do.
                return null;
            }
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line + "\n");
            }

            if (buffer.length() == 0) {
                // Stream was empty.  No point in parsing.
                return null;
            }

            return new JSONObject(buffer.toString());
        }catch (Exception e){
            Log.e("ERR",e.getMessage());
            return null;
        }
        finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (final IOException e) {
                    Log.e("ERR",e.getMessage());
                }
            }
        }
    }


    @Override
    protected void onPostExecute(JSONObject jsonObject) {
        super.onPostExecute(jsonObject);

       try {
           List<CalenderEvent> results = CalenderEvent.listFromJson(jsonObject);
           adapter.clear();
           adapter.addAll(results);

       }catch (Exception e){
           Log.e("ER",e.getMessage());
       }



    }
}
