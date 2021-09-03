package com.example.localcommunity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Report extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        getSupportActionBar().setTitle("신고");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼 https://dreamaz.tistory.com/109

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.report, android.R.layout.simple_spinner_dropdown_item);

        Spinner reportSpinner = (Spinner) findViewById(R.id.report_spinner); // https://kkgram.tistory.com/14
        reportSpinner.setAdapter(adapter);
    }
}