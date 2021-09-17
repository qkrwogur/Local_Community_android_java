package com.example.localcommunity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {

    private static final String TAG = "LOGIN";
    EditText editLogId, editLogPw;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editLogId = findViewById(R.id.edit_log_id);
        editLogPw = findViewById(R.id.edit_log_pw);
    }

    public void login(View view) {
        String url = "http://192.168.0.25:8080/member/login";

        requestQueue = Volley.newRequestQueue(this);

        Map<String, String> postParam= new HashMap<String, String>();
        postParam.put("memberId", editLogId.getText().toString());
        postParam.put("memberPassword", editLogPw.getText().toString());

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.POST, url, new JSONObject(postParam), new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            String result = response.getString("result");

                            if (result.equals("success")) {
                                Toast.makeText(getApplicationContext(), "로그인을 성공했습니다", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(getApplicationContext(), "아아디 또는 비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

//                        String boardId = null;
//                        try {
//                            boardId = response.getString("boardId");
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // 자동으로 생성되는 메소드의 부분
                        Log.d(TAG, error.toString());
                    }
                });

        requestQueue.add(jsObjRequest);

    }
}