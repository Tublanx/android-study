package com.example.registerlogindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    private EditText edtId, edtPwd;
    private Button btnLogin, btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // init components
        edtId = findViewById(R.id.login_activity_edt_id);
        edtPwd = findViewById(R.id.login_activity_edt_pwd);
        btnLogin = findViewById(R.id.login_activity_btn_login);
        btnRegister = findViewById(R.id.login_activity_btn_register);

        // login button click event
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userId = edtId.getText().toString();
                String userPwd = edtPwd.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObj = new JSONObject(response);
                            boolean isSuccess = jsonObj.getBoolean("success");

                            // 로그인 성공
                            if (isSuccess) {
                                // JSON으로부터 값 가져오기
                                String userId = jsonObj.getString("userID");
                                String userPwd = jsonObj.getString("userPassword");

                                Toast.makeText(getApplicationContext(), "로그인 성공하였습니다.", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                intent.putExtra("userId", userId);
                                Log.e("userPassword : ", userPwd);
                                intent.putExtra("userPwd", userPwd);
                                startActivity(intent);
                            }
                            // 로그인 실패
                            else {
                                Toast.makeText(getApplicationContext(), "로그인 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                LoginRequest loginRequest = new LoginRequest(userId, userPwd, responseListener);
                RequestQueue reqQue = Volley.newRequestQueue(LoginActivity.this);
                reqQue.add(loginRequest);

            }
        });

        // register button click event
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }
}