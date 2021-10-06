package com.example.localcommunity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.widget.EditText;

import com.example.localcommunity.R;

public class UpdateActivity extends AppCompatActivity {

    EditText title, content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        // 액션바 설정
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setTitle("게시글 수정");
        supportActionBar.setDisplayHomeAsUpEnabled(true);

        title = findViewById(R.id.update_edit_title);
        content = findViewById(R.id.update_edit_content);

        title.setText("카드 잃어버리신 분");
        content.setText("카드를 주었습니다.\n\n동네 마트 앞에 있었어요.\n\n 마트에 맡겼어요.");
    }
}