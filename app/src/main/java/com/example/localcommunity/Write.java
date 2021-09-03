package com.example.localcommunity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Write extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        getSupportActionBar().setTitle("게시글 작성");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼 https://dreamaz.tistory.com/109
    }
}