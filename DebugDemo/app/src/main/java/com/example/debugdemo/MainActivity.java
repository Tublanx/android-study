package com.example.debugdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String str = "이기현";

        Log.e("MainActivity : ", str);

        int a = 10;

        Log.e("MainActivity : ", a + "");

    }
}