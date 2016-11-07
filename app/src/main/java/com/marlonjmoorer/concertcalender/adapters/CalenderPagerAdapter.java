package com.marlonjmoorer.concertcalender.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.marlonjmoorer.concertcalender.fragments.CalenderFragment;
import com.marlonjmoorer.concertcalender.fragments.EventListFragment;

/**
 * Created by marlonmoorer on 11/5/16.
 */

public class CalenderPagerAdapter extends FragmentStatePagerAdapter {


    public CalenderPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new CalenderFragment();
            case 1:
                return new EventListFragment();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }



}
