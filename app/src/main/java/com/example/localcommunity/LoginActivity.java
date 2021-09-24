package com.example.localcommunity;

import androidx.appcompat.app.ActionBar;
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

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LOGIN";
    EditText editLogId, editLogPwd;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        checkSession();
        // 액션바 설정
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        editLogId = findViewById(R.id.login_edit_id);
        editLogPwd = findViewById(R.id.login_edit_password);

        requestQueue = Volley.newRequestQueue(this);
    }

    public void login(View view) {
        String url = "http://172.30.1.59:8080/member/login";

        Map<String, String> postParam= new HashMap<>();
        postParam.put("memberId", editLogId.getText().toString());
        postParam.put("memberPassword", editLogPwd.getText().toString());

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.POST, url, new JSONObject(postParam), new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String result = response.getString("result");

                            if (result.equals("success")) {
                                Toast.makeText(getApplicationContext(), "로그인을 성공했습니다", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), gps.class);

                                User user = new User(editLogId.getText().toString());
                                SessionID sessionID = new SessionID(LoginActivity.this);
                                sessionID.saveSession(user);

                                finish();
                                startActivity(intent);
                            } else {
                                Toast.makeText(getApplicationContext(), "아아디 또는 비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            Log.d(TAG, e.toString());
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, error.toString());
                    }
                });
        requestQueue.add(jsObjRequest);
    }

    public void moveJoinForm(View view) {
        Intent intent = new Intent(getApplicationContext(), JoinActivity.class);
        startActivity(intent);
    }

    private void checkSession() {
        //check if user is logged in
        //if user is logged in --> move to mainActivity

        SessionID sessionID = new SessionID(LoginActivity.this);

        String userID = sessionID.getSession();



        if(userID != ""){
            //user id logged in and so move to mainActivity
            moveToMainActivity();
            finish();
        }
        else{
            //do nothing
        }
    }
    private void moveToMainActivity() {
        Intent intent = new Intent(LoginActivity.this, gps.class);
        //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}