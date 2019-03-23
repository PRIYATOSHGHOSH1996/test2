package com.example.priyo.test;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bn;
    private int home = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Menu");
        getSupportFragmentManager().beginTransaction().replace(R.id.frame, new HomeFragment()).commit();
        setSupportActionBar(toolbar);

        bn = (BottomNavigationView) findViewById(R.id.bn);


        bn.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.bhome:
                        if (home == 0) {
                            getSupportFragmentManager().beginTransaction().replace(R.id.frame, new HomeFragment()).commit();
                            home = 1;
                            menuItem.setChecked(true);

                        }
                        break;
                    case R.id.bradio:
                        if (home == 1) {
                            getSupportFragmentManager().beginTransaction().replace(R.id.frame, new RadioFragment()).commit();
                            home = 0;
                            menuItem.setChecked(true);

                        }

                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ht, menu);
        return true;
    }


    @Override
    public void onBackPressed() {

        super.onBackPressed();

    }


}
