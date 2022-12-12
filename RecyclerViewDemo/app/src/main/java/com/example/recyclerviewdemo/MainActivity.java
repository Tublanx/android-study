package com.example.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<MainData> mainDataList;
    private MainAdapter mainAdapter;
    private RecyclerView rv;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv);
        linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);

        mainDataList = new ArrayList<>();

        mainAdapter = new MainAdapter(mainDataList);
        rv.setAdapter(mainAdapter);

        Button btnAdd = findViewById(R.id.btn_add);

        btnAdd.setOnClickListener(view -> {
            MainData mainData = new MainData(R.drawable.ic_launcher_background, "이기현", "김신영");
            mainDataList.add(mainData);
            mainAdapter.notifyDataSetChanged(); // 새로고침
        });
    }
}