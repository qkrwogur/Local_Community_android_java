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
                Intent intent = new Intent(getApplicationContext(), ReportActivity.class);
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

        boardList.add(new ListBord("인기글 1",".","9월12일13시",7,7));
        boardList.add(new ListBord("인기글 2",".","9월12일13시",7,7));
        boardList.add(new ListBord("인기글 3",".","9월12일13시",7,7));
        boardList.add(new ListBord("인기글 4",".","9월12일13시",7,7));
        boardList.add(new ListBord(" ",".","9월12일13시",7,7));
        boardList.add(new ListBord("저희집 막내 덕구 한 번 보고 가세요",".","9월14일15시",80,89));
        boardList.add(new ListBord("마린pc방 돈안내고 간 학생 찾습니다.","9월 12일 저녁 5시에 마린pc 방에서 후불로 하고 돈아내고 도망간  초등학생 찾습니다.","9월13일9시",25,45));
        boardList.add(new ListBord("브라질리언 왁싱은 브라질 사람만 할 수 있는 거임?","미안 점심 메뉴 추천좀","9월12일14시",31,34));
        boardList.add(new ListBord("코로나 의심되면 검사 받자","코로나 걸린거 같고 의심 증상 있으면 주저하지 말고 보건소 갑시다.","9월10일13시",10,10));




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