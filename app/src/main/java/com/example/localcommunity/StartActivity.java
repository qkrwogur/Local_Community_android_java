package com.example.localcommunity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        // 액션바 설정
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    public void moveLoginForm(View view) {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }

    public void moveJoinForm(View view) {
        Intent intent = new Intent(getApplicationContext(), JoinActivity.class);
        startActivity(intent);
    }
}