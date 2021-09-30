package com.example.localcommunity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class my_page extends AppCompatActivity {

    Button main,popular,report,my_page;
    Button logout,gpsChange,myPageGo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);

        logout=findViewById(R.id.myPage_logout);
        gpsChange=findViewById(R.id.gpsChange);
        myPageGo = findViewById(R.id.my_page_go);

        main = findViewById(R.id.main_page_button3);
        popular = findViewById(R.id.popular_page_button3);
        report =  findViewById(R.id.report_page_button3);
        my_page =  findViewById(R.id.my_page_button3);

        //액선바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SessionID sessionID = new SessionID(my_page.this);
                sessionID.removeSession();

                SessionCity sessionCity = new SessionCity(my_page.this);
                sessionCity.removeSession();


                Intent intent=new Intent(getApplicationContext(), LoginActivity.class);

                startActivity(intent);
                finish();

            }
        });

        gpsChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SessionCity sessionCity = new SessionCity(my_page.this);
                sessionCity.removeSession();

                Intent intent=new Intent(getApplicationContext(),gps.class);

                startActivity(intent);
                finish();

            }
        });

        myPageGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),my_write.class);

                startActivity(intent);

            }
        });

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
                Intent intent = new Intent(getApplicationContext(), WriteActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);


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