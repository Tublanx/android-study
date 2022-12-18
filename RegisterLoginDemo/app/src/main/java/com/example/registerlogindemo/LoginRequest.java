package com.example.registerlogindemo;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {

    // 서버 URL 설정 (php 파일 연동)
    private final static String URL = "http://tublanx.ivyro.net/Login.php";
    private Map<String, String> map;

    public LoginRequest(String userID, String userPwd, Response.Listener<String> listener) {

        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("userID", userID);
        map.put("userPassword", userPwd);

    }

    @Nullable
    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
