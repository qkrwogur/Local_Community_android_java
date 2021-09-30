package com.example.localcommunity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class my_write extends AppCompatActivity {

    ImageButton refresh,search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_write);


        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        refresh = findViewById(R.id.popular_refresh);
        search = findViewById(R.id.popular_search);

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), my_write.class);
                startActivity(intent);

                finish();
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Search.class);
                startActivity(intent);


            }
        });

        final ArrayList boardList = new ArrayList();

        CustomAdapter adapter = new CustomAdapter(this,R.layout.main_list,boardList);
        ListView listView =(ListView)findViewById(R.id.main_list);
        listView.setAdapter(adapter);

        boardList.add(new ListBord("인기글 1",".","9월12일13시",7,7));
    }

    class CustomAdapter extends ArrayAdapter<ListBord> {
        Activity context;
        ArrayList list;
        int layout;
        CustomAdapter(Activity context, int layout, ArrayList list){
            super(context, layout,list);
            this.context=context;
            this.list=list;
            this.layout = layout;
        }
        public int getCount(){
            return list.size();
        }
        public ListBord getItem(int pos){
            return (ListBord)list.get(pos);
        }
        public long getItemId(int pos){
            return pos;
        }

        public View getView(int pos, View convertView, ViewGroup parent){
            if(convertView == null){//스크롤이 넘어 갈때 재 사용 되는 view
                LayoutInflater inflater =context.getLayoutInflater();
                convertView = inflater.inflate(layout, null,true);
            }
            final ListBord list =  getItem(pos);
            TextView title = (TextView) convertView.findViewById(R.id.main_list_title);
            TextView content = (TextView) convertView.findViewById(R.id.main_list_content);
            TextView time = (TextView) convertView.findViewById(R.id.main_list_time);
            TextView like_number = (TextView) convertView.findViewById(R.id.main_list_like_number);
            TextView comment_number = (TextView) convertView.findViewById(R.id.list_comment_number);

            title.setText(list.title);
            content.setText(list.content);
            time.setText(list.time);
            like_number.setText(list.like+"");
            comment_number.setText(list.comment+"");


            return convertView;
        }

    }

    class ListBord {
        ListBord(String title,String content,String time,int like,int comment){
            this.title=title;
            this.content=content;
            this.time=time;
            this.like=like;
            this.comment=comment;
        }
        String title;
        String content;
        String time;
        int like;
        int comment;
    }
}