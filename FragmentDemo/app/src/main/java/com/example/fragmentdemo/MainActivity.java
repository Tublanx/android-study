package com.example.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnMenu1, btnMenu2, btnMenu3, btnMenu4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMenu1 = findViewById(R.id.btn_menu1);
        btnMenu2 = findViewById(R.id.btn_menu2);
        btnMenu3 = findViewById(R.id.btn_menu3);
        btnMenu4 = findViewById(R.id.btn_menu4);

        btnMenu1.setOnClickListener(view -> {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            Fragment1 fragment1 = new Fragment1();
            transaction.replace(R.id.frame, fragment1);
            transaction.commit();
        });

        btnMenu2.setOnClickListener(view -> {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            Fragment2 fragment2 = new Fragment2();
            transaction.replace(R.id.frame, fragment2);
            transaction.commit();
        });

        btnMenu3.setOnClickListener(view -> {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            Fragment3 fragment3 = new Fragment3();
            transaction.replace(R.id.frame, fragment3);
            transaction.commit();
        });

        btnMenu4.setOnClickListener(view -> {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            Fragment4 fragment4 = new Fragment4();
            transaction.replace(R.id.frame, fragment4);
            transaction.commit();
        });

    }
}