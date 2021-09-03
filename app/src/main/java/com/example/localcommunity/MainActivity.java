package com.example.localcommunity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button main,popular,report,my_page;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main = findViewById(R.id.main_page_button1);
        popular = findViewById(R.id.popular_page_button1);
        report =  findViewById(R.id.report_page_button1);
        my_page =  findViewById(R.id.my_page_button1);
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);

                finish();
            }
        });

        popular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), popular.class);
                startActivity(intent);
                overridePendingTransition(0, 0);

                finish();
            }
        });

        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Report.class);
                startActivity(intent);
                overridePendingTransition(0, 0);

                finish();
            }
        });

        my_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), my_page.class);
                startActivity(intent);
                overridePendingTransition(0, 0);

                finish();
            }
        });
    }
}