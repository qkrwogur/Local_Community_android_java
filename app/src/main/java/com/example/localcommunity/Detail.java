package com.example.localcommunity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.localcommunity.R;

public class Detail extends AppCompatActivity {

    ListView listView;
    String list[] = {"익명1", "감사합니다."};
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // 액션바 설정
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setTitle("카드 잃어버리신 분"); // DB값
        supportActionBar.setDisplayHomeAsUpEnabled(true);

        // 리스트뷰 설정
        listView = (ListView) findViewById(R.id.detail_listView);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
    }
}