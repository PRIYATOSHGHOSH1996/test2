package com.example.priyo.test;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

public class MyPagerAdapter extends FragmentStatePagerAdapter {
    private  int NUM_ITEMS;
     MyPagerAdapter(FragmentManager fragmentManager, int a) {
        super(fragmentManager);
        NUM_ITEMS = a;
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                return "ALBUMS";
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return "ARTISTS";
            default:
                return null;
        }

    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                Log.e("album","true");
                return new AlbumFragment();
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return new ArtistFragment();
            default:
                return new ArtistFragment();
        }

    }
}
