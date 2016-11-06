package com.marlonjmoorer.concertcalender.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marlonjmoorer.concertcalender.R;

/**
 * Created by marlonmoorer on 11/5/16.
 */

public class CalenderFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_calender, container, false);
    }
}
