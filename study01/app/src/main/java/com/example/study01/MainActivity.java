package com.example.study01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgView = findViewById(R.id.imgView);

        imgView.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(), "안녕하세요", Toast.LENGTH_SHORT).show();
        });

    }
}