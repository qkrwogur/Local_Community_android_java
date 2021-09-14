package com.example.localcommunity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;

public class Search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //액선바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        EditText input = (EditText) findViewById(R.id.search_input);
        ImageButton back =(ImageButton)findViewById(R.id.arrow_back);


        //키보드 보이게 하는 부분
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
        input.requestFocus();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);


                finish();
            }
        });

    }

}