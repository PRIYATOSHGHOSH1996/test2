package com.example.priyo.test;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class ArtistFragment extends Fragment {
    View view;

    ArrayList<Bitmap> image1 = new ArrayList<>();
    ArrayList<String> text1 = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_artist, container, false);
        intView();
        return view;
    }

    private void intView() {
        getImages();
        initRecyclerView1();
    }

    private void getImages() {

        image1.add(BitmapFactory.decodeResource(getResources(), R.drawable.i1));
        text1.add("Udit Narayan");
        image1.add(BitmapFactory.decodeResource(getResources(), R.drawable.i2));
        text1.add("Shreya Ghoshal");
        image1.add(BitmapFactory.decodeResource(getResources(), R.drawable.i3));
        text1.add("Kishore Kumar");
        image1.add(BitmapFactory.decodeResource(getResources(), R.drawable.i4));
        text1.add("Arijit Sing");
        image1.add(BitmapFactory.decodeResource(getResources(), R.drawable.i5));
        text1.add("Neha Kakkar");
        image1.add(BitmapFactory.decodeResource(getResources(), R.drawable.i6));
        text1.add("Kumar Sanu");


    }

    private void initRecyclerView1() {

        RecyclerView recyclerView = view.findViewById(R.id.arec);
        GridLayoutManager layoutManager =
                new GridLayoutManager(getContext(), 2);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext(), text1, image1);
        recyclerView.setAdapter(adapter);
    }
}
