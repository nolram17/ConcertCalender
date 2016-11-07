package com.marlonjmoorer.concertcalender.helpers;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import com.marlonjmoorer.concertcalender.models._OldCalenderEvent;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by marlonmoorer on 11/6/16.
 */

public class DownloadImageTask extends AsyncTask<String,Void,Bitmap> {

    _OldCalenderEvent event;

    public DownloadImageTask(_OldCalenderEvent ev) {
        this.event=ev;

    }

    protected Bitmap doInBackground(String... urls) {
        String urlOfImage = urls[0];
        Bitmap logo = null;
        try {
            InputStream is = new URL(urlOfImage).openStream();

            logo = BitmapFactory.decodeStream(is);
        } catch (Exception e) { // Catch the download exception
            e.printStackTrace();
        }
        return logo;
    }

    @Override
    protected void onPostExecute(Bitmap result) {
       event.img=result;
    }
}
