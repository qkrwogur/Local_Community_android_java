package com.example.localcommunity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Update extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        getSupportActionBar().setTitle("게시글 수정");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼 https://dreamaz.tistory.com/109
    }
}