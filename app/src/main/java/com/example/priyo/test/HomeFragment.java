package com.example.priyo.test;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
   private View view;
    ArrayList<Bitmap> image=new ArrayList<>();
    ArrayList<String> text=new ArrayList<>();
    ArrayList<Bitmap> image1=new ArrayList<>();
    ArrayList<String> text1=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        initView();
        return view;
    }

    private void initView() {

        getImages();
        getImages1();
    }

    private void getImages(){

        image.add(BitmapFactory.decodeResource(getResources(),R.drawable.i1));
        text.add("Udit Narayan");
        image.add(BitmapFactory.decodeResource(getResources(),R.drawable.i2));
        text.add("Shreya Ghoshal");
        image.add(BitmapFactory.decodeResource(getResources(),R.drawable.i3));
        text.add("Kishore Kumar");
        image.add(BitmapFactory.decodeResource(getResources(),R.drawable.i4));
        text.add("Arijit Sing");
        image.add(BitmapFactory.decodeResource(getResources(),R.drawable.i5));
        text.add("Neha Kakkar");
        image.add(BitmapFactory.decodeResource(getResources(),R.drawable.i6));
        text.add("Kumar Sanu");





        initRecyclerView();

    }

    private void initRecyclerView(){


        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = view.findViewById(R.id.rec);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext(), text, image);
        recyclerView.setAdapter(adapter);
    }
    private void getImages1(){

        image1.add(BitmapFactory.decodeResource(getResources(),R.drawable.ii1));
        text1.add("Thugs Of Hindostan");
        image1.add(BitmapFactory.decodeResource(getResources(),R.drawable.ii2));
        text1.add("Baazaar");
        image1.add(BitmapFactory.decodeResource(getResources(),R.drawable.ii3));
        text1.add("Love Yatri");
        image1.add(BitmapFactory.decodeResource(getResources(),R.drawable.ii4));
        text1.add("Batti Gul Meter Chalu");
        image1.add(BitmapFactory.decodeResource(getResources(),R.drawable.ii5));
        text1.add("2.O");
        image1.add(BitmapFactory.decodeResource(getResources(),R.drawable.ii6));
        text1.add("Sui Dhaaga");



        initRecyclerView1();





    }
    private void initRecyclerView1(){

        RecyclerView recyclerView = view.findViewById(R.id.rec1);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext(), text1, image1);
        recyclerView.setAdapter(adapter);
    }
}
