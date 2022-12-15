package com.example.dialogdemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnOpen;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOpen = findViewById(R.id.btn_open);
        tvResult = findViewById(R.id.tv_result);

        // open dialog
        btnOpen.setOnClickListener(view -> {
            AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);
            ad.setIcon(R.mipmap.ic_launcher);
            ad.setTitle("dialog demo");
            ad.setMessage("앱 종료?");

            final EditText edt = new EditText(MainActivity.this);
            ad.setView(edt);
            ad.setPositiveButton("종료", (dialogInterface, i) -> {
                String result = edt.getText().toString();
                tvResult.setText(result);
                dialogInterface.dismiss();
            });

            ad.setNegativeButton("취소", (dialogInterface, i) -> {
                dialogInterface.dismiss();
            });

            ad.show();
        });

    }
}