package com.example.shareddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtSave;

    String sharedStr = "file";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtSave = findViewById(R.id.edt_save);

        SharedPreferences sharedPref = getSharedPreferences(sharedStr, 0);

        String value = sharedPref.getString("val", "");
        edtSave.setText(value);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        SharedPreferences sharedPref = getSharedPreferences(sharedStr, 0);
        SharedPreferences.Editor editor = sharedPref.edit();

        String value = edtSave.getText().toString();

        editor.putString("val", value);
        editor.commit();

    }
}