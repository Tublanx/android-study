package com.example.edittextdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edt_id;
    Button btn_confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_id = findViewById(R.id.edt_id);
        btn_confirm = findViewById(R.id.btn_confirm);

        btn_confirm.setOnClickListener(view -> {
            edt_id.setText("Hello Android");
        });

    }

}