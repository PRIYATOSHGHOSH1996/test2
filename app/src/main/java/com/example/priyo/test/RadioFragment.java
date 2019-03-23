package com.example.priyo.test;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class RadioFragment extends Fragment {
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_radio, container, false);


        initView();
        return view;
    }

    private void initView() {
        TabLayout tabLayout = view.findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        final ViewPager viewPager = view.findViewById(R.id.viewpager);
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(myPagerAdapter);
        tabLayout.setupWithViewPager(viewPager,true);
        Log.e("radio","true");

    }





}
