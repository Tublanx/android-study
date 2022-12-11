package com.example.intentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edt;
    private Button btnMove;

    private String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt = findViewById(R.id.edt);

        btnMove = findViewById(R.id.btnMove);
        btnMove.setOnClickListener(view -> {
            str = edt.getText().toString();
            Intent intent = new Intent(MainActivity.this, SubActivity.class);
            intent.putExtra("str", str);
            startActivity(intent); // move activity
        });

    }
}