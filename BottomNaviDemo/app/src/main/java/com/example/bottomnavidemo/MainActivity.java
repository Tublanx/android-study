package com.example.bottomnavidemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Frag1 frag1;
    private Frag2 frag2;
    private Frag3 frag3;
    private Frag4 frag4;
    private Frag5 frag5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.activity_main_bottom_navi);
        frag1 = new Frag1();
        frag2 = new Frag2();
        frag3 = new Frag3();
        frag4 = new Frag4();
        frag5 = new Frag5();

        setFrag(0);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.action_calculate:
                        setFrag(0);
                        break;
                    case R.id.action_calendar:
                        setFrag(1);
                        break;
                    case R.id.action_help:
                        setFrag(2);
                        break;
                    case R.id.action_https:
                        setFrag(3);
                        break;
                    case R.id.action_chart:
                        setFrag(4);
                        break;
                }

                return true;
            }
        });

    }

    // replace fragments
    private void setFrag(int n) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        switch (n) {
            case 0:
                ft.replace(R.id.activity_main_frame, frag1);
                ft.commit();
                break;
            case 1:
                ft.replace(R.id.activity_main_frame, frag2);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.activity_main_frame, frag3);
                ft.commit();
                break;
            case 3:
                ft.replace(R.id.activity_main_frame, frag4);
                ft.commit();
                break;
            default:
                ft.replace(R.id.activity_main_frame, frag5);
                ft.commit();
        }
    }

}