package com.example.comebackdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SubActivity extends AppCompatActivity {

    private EditText edtComeback;
    private Button btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        edtComeback = findViewById(R.id.activity_sub_edt_comeback);
        btnClose = findViewById(R.id.activity_sub_btn_close);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("edt_comeback", edtComeback.getText().toString()); // 입력 폼에 적은 값 담아주기
                setResult(RESULT_OK, intent); // 결과 값 설정
                finish(); // 현재 액티비티 종료
            }
        });

    }
}