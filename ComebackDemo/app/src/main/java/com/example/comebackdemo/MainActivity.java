package com.example.comebackdemo;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tvComeback;
    private Button btnGo;

    private ActivityResultLauncher<Intent> activityResultLauncher; // Intent형 activityResultLauncher 객체 생성

    private static final int REQUEST_CODE = 217;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize components
        tvComeback = findViewById(R.id.activity_main_tv_comeback);
        btnGo = findViewById(R.id.activity_main_btn_go);
        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if(result.getResultCode() == RESULT_OK) {
                Toast.makeText(getApplicationContext(), "수신 성공", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "수신 실패", Toast.LENGTH_SHORT).show();
            }

            String resultTxt = result.getData().getStringExtra("edt_comeback");
            tvComeback.setText(resultTxt);
        });

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                activityResultLauncher.launch(intent);
            }
        });

    }
}