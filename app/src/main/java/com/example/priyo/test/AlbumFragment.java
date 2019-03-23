package com.example.priyo.test;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class AlbumFragment extends Fragment {
    ArrayList<Bitmap> image=new ArrayList<>();
    ArrayList<String> text=new ArrayList<>();
 private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_album, container, false);
        initView();
        return view;
    }

    private void initView() {
        getImages();
        initRecyclerView();
    }
    private void getImages(){

        image.add(BitmapFactory.decodeResource(getResources(),R.drawable.ii1));
        text.add("Thugs Of Hindostan");
        image.add(BitmapFactory.decodeResource(getResources(),R.drawable.ii2));
        text.add("Baazaar");
        image.add(BitmapFactory.decodeResource(getResources(),R.drawable.ii3));
        text.add("Love Yatri");
        image.add(BitmapFactory.decodeResource(getResources(),R.drawable.ii4));
        text.add("Batti Gul Meter Chalu");
        image.add(BitmapFactory.decodeResource(getResources(),R.drawable.ii5));
        text.add("2.O");
        image.add(BitmapFactory.decodeResource(getResources(),R.drawable.ii6));
        text.add("Sui Dhaaga");
    }
    private void initRecyclerView(){

        RecyclerView recyclerView = view.findViewById(R.id.frec);
        GridLayoutManager layoutManager =
                new GridLayoutManager(getContext(), 2);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext(), text, image);
        recyclerView.setAdapter(adapter);
    }

}
