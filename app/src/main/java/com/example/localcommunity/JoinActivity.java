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

public class JoinActivity extends AppCompatActivity {

    EditText editJoinId, editJoinPwd, editJoinPwdConfirm, editJoinPhone;
    private static final String TAG = "JOIN";
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        // 액션바 설정
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        editJoinId = findViewById(R.id.join_edit_id);
        editJoinPwd  = findViewById(R.id.join_edit_password);
        editJoinPwdConfirm = findViewById(R.id.join_edit_password_confirm);
        editJoinPhone = findViewById(R.id.join_edit_phone);

        requestQueue = Volley.newRequestQueue(this);
    }

    public void join(View view) {
        String url = "http://192.168.0.62:8080/member/join";

        String id = editJoinId.getText().toString();
        String pwd = editJoinPwd.getText().toString();
        String pwdConfirm = editJoinPwdConfirm.getText().toString();
        String phone = editJoinPhone.getText().toString();

        if (id.length() == 0 || pwd.length() == 0 || pwdConfirm.length() == 0 || phone.length() == 0) {
            Toast.makeText(getApplicationContext(), "입력하지 않은 값이 있습니다", Toast.LENGTH_SHORT).show();
        } else {
            if (pwd.equals(pwdConfirm)) {
                Map<String, String> postParam= new HashMap<>();
                postParam.put("memberId", editJoinId.getText().toString());
                postParam.put("memberPassword", editJoinPwd.getText().toString());
                postParam.put("memberPhone", editJoinPhone.getText().toString());

                JsonObjectRequest jsObjRequest = new JsonObjectRequest
                        (Request.Method.POST, url, new JSONObject(postParam), new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    String result = response.getString("result");
                                    if (result.equals("success")) {
                                        Toast.makeText(getApplicationContext(), "회원가입을 성공했습니다", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                        finish();
                                        startActivity(intent);
                                    } else if (result.equals("duplicate")){
                                        Toast.makeText(getApplicationContext(), "이미 존재하는 회원 아이디입니다", Toast.LENGTH_SHORT).show();
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
            } else {
                Toast.makeText(getApplicationContext(), "비밀번호와 비밀번호 확인이 일치하지 않습니다", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void cancel(View view) {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
        finish();
    }
}