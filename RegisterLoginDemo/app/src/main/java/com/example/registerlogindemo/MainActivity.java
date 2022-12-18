package com.example.registerlogindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvId, tvPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvId = findViewById(R.id.activity_main_tv_id);
        tvPwd = findViewById(R.id.activity_main_tv_pwd);

        Intent intent = getIntent();
        String userId = intent.getStringExtra("userId");
        String userPwd = intent.getStringExtra("userPwd");

        tvId.setText(userId);
        tvPwd.setText(userPwd);

    }
}