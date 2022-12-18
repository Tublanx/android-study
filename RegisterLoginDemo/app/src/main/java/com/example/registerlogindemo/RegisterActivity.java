package com.example.registerlogindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    private EditText edtId, edtPwd, edtName, edtAge;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // init components
        edtId = findViewById(R.id.register_activity_edt_id);
        edtPwd = findViewById(R.id.register_activity_edt_pwd);
        edtName = findViewById(R.id.register_activity_edt_name);
        edtAge = findViewById(R.id.register_activity_edt_age);
        btnRegister = findViewById(R.id.register_activity_btn_register);

        // register button click event
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userId = edtId.getText().toString();
                String userPwd = edtPwd.getText().toString();
                String userName = edtName.getText().toString();
                int userAge = Integer.parseInt(edtAge.getText().toString());

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObj = new JSONObject(response);
                            boolean isSuccess = jsonObj.getBoolean("success");

                            // 회원가입 성공
                            if (isSuccess) {
                                Toast.makeText(getApplicationContext(), "회원 등록에 성공하였습니다.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                startActivity(intent);
                            }
                            // 회원가입 실패
                            else {
                                Toast.makeText(getApplicationContext(), "회원 등록에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                // Volley를 이용해서 서버로 요청
                RegisterRequest registerRequest = new RegisterRequest(userId, userPwd, userName, userAge, responseListener);
                RequestQueue reqQue = Volley.newRequestQueue(RegisterActivity.this);
                reqQue.add(registerRequest);

            }
        });

    }
}