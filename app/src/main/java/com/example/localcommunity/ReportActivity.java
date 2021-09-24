package com.example.localcommunity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.localcommunity.R;

public class ReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        // 액션바 설정
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setTitle("신고");
        supportActionBar.setDisplayHomeAsUpEnabled(true);

        // Spinner 설정 (https://kkgram.tistory.com/14)
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.report, android.R.layout.simple_spinner_dropdown_item);
        Spinner reportSpinner = (Spinner) findViewById(R.id.report_spinner);
        reportSpinner.setAdapter(adapter);
    }
}