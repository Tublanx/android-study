package com.example.musicplayerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnPlay, btnStop;

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize components
        btnPlay = findViewById(R.id.activity_main_btn_play);
        btnStop = findViewById(R.id.activity_main_btn_stop);

        // play button click event
        btnPlay.setOnClickListener(view -> {
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.playpretend);
            mediaPlayer.start();
        });

        // stop button click event
        btnStop.setOnClickListener(view -> {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();  // stop
                mediaPlayer.reset(); // initialize
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}