package com.example.localcommunity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class PolicyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy);

        // 액션바 설정
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setTitle("운영정책");
        supportActionBar.setDisplayHomeAsUpEnabled(true);
    }
}