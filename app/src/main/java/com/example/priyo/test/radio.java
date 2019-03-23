package com.example.priyo.test;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class radio extends AppCompatActivity
{
private DrawerLayout drawerLayout;
    ArrayList<Bitmap> image=new ArrayList<>();
    ArrayList<String> text=new ArrayList<>();
    ArrayList<Bitmap> image1=new ArrayList<>();
    ArrayList<String> text1=new ArrayList<>();
    LinearLayout ar,fr;
    private BottomNavigationView bn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio2);
        ar=(LinearLayout)findViewById(R.id.ar);
        fr=(LinearLayout)findViewById(R.id.fr);
        ar.setVisibility(View.GONE);
        getImages1();
        getImages();
        initRecyclerView();
        Toolbar toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle("Radio");
        NavigationView navigationView=findViewById(R.id.nav);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.radio:onBackPressed();
                        break;
                    case R.id.home:startActivity(new Intent(radio.this,MainActivity.class));
                    finish();
                }
                return true;
            }
        });
        setSupportActionBar(toolbar);
        drawerLayout=findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        TabLayout tabLayout=findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("ALBUM"));
        tabLayout.addTab(tabLayout.newTab().setText("ARTISTS"));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
     if(tab.getPosition()==0){
         ar.setVisibility(View.GONE);
         fr.setVisibility(View.VISIBLE);
         initRecyclerView();
     }
                if(tab.getPosition()==1){
                    ar.setVisibility(View.VISIBLE);
                    fr.setVisibility(View.GONE);
                    initRecyclerView1();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        bn=(BottomNavigationView)findViewById(R.id.bn1);
        bn.setSelectedItemId(R.id.bradio);
        bn.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.bhome:startActivity(new Intent(radio.this,MainActivity.class));
                    finish();
                }
                return false;
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.rt,menu);
        return true;
    }

    private void getImages(){

        image1.add(BitmapFactory.decodeResource(getResources(),R.drawable.i1));
        text1.add("Udit Narayan");
        image1.add(BitmapFactory.decodeResource(getResources(),R.drawable.i2));
        text1.add("Shreya Ghoshal");
        image1.add(BitmapFactory.decodeResource(getResources(),R.drawable.i3));
        text1.add("Kishore Kumar");
        image1.add(BitmapFactory.decodeResource(getResources(),R.drawable.i4));
        text1.add("Arijit Sing");
        image1.add(BitmapFactory.decodeResource(getResources(),R.drawable.i5));
        text1.add("Neha Kakkar");
        image1.add(BitmapFactory.decodeResource(getResources(),R.drawable.i6));
        text1.add("Kumar Sanu");









    }
    private void getImages1(){

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
    private void initRecyclerView1(){

        RecyclerView recyclerView = findViewById(R.id.arec);
        GridLayoutManager layoutManager =
                new GridLayoutManager(this, 2);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, text1, image1);
        recyclerView.setAdapter(adapter);
    }

    private void initRecyclerView(){

        RecyclerView recyclerView = findViewById(R.id.frec);
        GridLayoutManager layoutManager =
                new GridLayoutManager(this, 2);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, text, image);
        recyclerView.setAdapter(adapter);
    }
    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }


}
