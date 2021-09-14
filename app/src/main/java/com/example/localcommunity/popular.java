package com.example.localcommunity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class popular extends AppCompatActivity {

    Button main,popular,report,my_page;
    ImageButton refresh,search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular);

        //액선바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        //버튼
        main = findViewById(R.id.main_page_button2);
        popular = findViewById(R.id.popular_page_button2);
        report =  findViewById(R.id.report_page_button2);
        my_page =  findViewById(R.id.my_page_button2);

        //이미지 버튼
        refresh = findViewById(R.id.popular_refresh);
        search = findViewById(R.id.popular_search);

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

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), popular.class);
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


        //리스트 처리 하기 인기글
        final ArrayList boardList = new ArrayList();

        CustomAdapter adapter = new CustomAdapter(this,R.layout.main_list,boardList);
        ListView listView =(ListView)findViewById(R.id.main_list);
        listView.setAdapter(adapter);


        //테스트 데이터 입력
        for(int i=0;i<10;i++){
            boardList.add(new ListBord("무한","좋아했다.","9월12일13시",7,7));
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {


                //ListAlarm listAlarm = (ListAlarm)alarmList.get(pos);

                //Toast toast = Toast.makeText(getApplicationContext(),listAlarm.time,Toast.LENGTH_LONG);
                //toast.show();
                Intent intent = new Intent(getApplicationContext(), Detail.class);
                // intent.putExtra("i",listAlarm.i);
                startActivity(intent);



            }
        });

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

    /*
     *제목
     *내용
     *시간
     *좋아요 갯수
     *댓글 갯수
     * */
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