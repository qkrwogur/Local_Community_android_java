package com.example.localcommunity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class my_page extends AppCompatActivity {

    Button logout,gpsChange;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);

        logout=findViewById(R.id.myPage_logout);
        gpsChange=findViewById(R.id.gpsChange);

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
    }
}