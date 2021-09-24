package com.example.localcommunity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.localcommunity.R;

public class WriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        // 액션바 설정
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setTitle("게시글 작성");
        supportActionBar.setDisplayHomeAsUpEnabled(true);
    }
}