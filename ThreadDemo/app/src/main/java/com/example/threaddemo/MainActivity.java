package com.example.threaddemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnStart, btnStop;
    Thread thread;
    boolean isThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // start Thread
        btnStart = findViewById(R.id.btn_start);
        btnStart.setOnClickListener(view -> {
            isThread = true;

            thread = new Thread(() -> {
                while (isThread) {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler.sendEmptyMessage(0);
                }
            });

            thread.start();
        });

        // stop thread
        btnStop = findViewById(R.id.btn_stop);
        btnStop.setOnClickListener(view -> {
            isThread = false;
        });

    }

    private Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            Toast.makeText(getApplicationContext(), "이기현", Toast.LENGTH_SHORT).show();
        }
    };

}