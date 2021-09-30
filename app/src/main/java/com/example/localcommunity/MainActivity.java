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

public class MainActivity extends AppCompatActivity {

    Button main,popular,report,my_page;
    ImageButton refresh,search;
    TextView main_title;

    String city;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //지역 체크 지역 값 가져 오기
        checkCitySession();

        //액선바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //버튼
        main = findViewById(R.id.main_page_button1);
        popular = findViewById(R.id.popular_page_button1);
        report =  findViewById(R.id.report_page_button1);
        my_page =  findViewById(R.id.my_page_button1);

        //이미지 버튼
        refresh = findViewById(R.id.main_refresh);
        search = findViewById(R.id.main_search);

        //테스트 뷰
        main_title = findViewById(R.id.main_title);
        main_title.setText(city);

        System.out.println(city);
        System.out.println("hello");
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


        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
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


        //리스트 처리 커스터 리스트 사용
        final ArrayList boardList = new ArrayList();

        CustomAdapter adapter = new CustomAdapter(this,R.layout.main_list,boardList);
        ListView listView =(ListView)findViewById(R.id.main_list);
        listView.setAdapter(adapter);


        //테스트 데이터 입력

        boardList.add(new ListBord("돈까스 극장 고양이","돈까스 극장 주변에 고양이 몇마리 보이는데 혹시 밥주는곳이 따로 있나요?","9월24일13시",2,3));
        boardList.add(new ListBord("태전동 필라테스","태전동에 필라테스, 요가 괜찮은곳 추천좀 해주세요 애기낳고 운동하고 살 빼려구요","9월24일9시",2,2));
        boardList.add(new ListBord("카드 잃어버리신 분","gs25 앞에서 카드를 잃어버렸습니다.","9월23일22시",2,1));
        boardList.add(new ListBord("동네에 손목시계 배터리 교체","손목시계 베터리 저렴하게 교체 가능한곡 아시는분 알려주세요~","9월23일20시",2,1));
        boardList.add(new ListBord("닥터페퍼 판매하는 곳","닥터페퍼 오프라인으로 판매하는곳 알고 있스면 알려 주세요 ㅎㅎ","9월23일20시",0,1));
        boardList.add(new ListBord("코로나 조심해용","오늘 우리동네에서 코로나 확진자가 46나왔습니다. 다들 조심 하세요","9월23일20시",2,1));
        boardList.add(new ListBord("pc방 영업하는 곳 있나요?","주변에 pc방 영업하는고이 있으면 알려주세요","9월23일20시",0,1));
        boardList.add(new ListBord("좋은 카페를가 소개 합니다.","연수구에 이번  ","9월23일20시",2,1));




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

    private void checkCitySession(){
        SessionCity sessionCity = new SessionCity(MainActivity.this);
        city = sessionCity.getSession();

        if(city == ""){
            Intent intent = new Intent(MainActivity.this, gps.class);
            startActivity(intent);
            finish();
        }else{
            //do nothing
        }

    }

}