package com.example.localcommunity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.localcommunity.R;

import java.util.ArrayList;

public class Detail extends AppCompatActivity {

    ListView listView;


    ImageButton like;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // 액션바 설정
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setTitle("카드 잃어버리신 분"); // DB값
        supportActionBar.setDisplayHomeAsUpEnabled(true);

        // 리스트뷰 설정
        listView = (ListView) findViewById(R.id.detail_listView);

        like = findViewById(R.id.imageButton);


        //좋아요 누를때
        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        final ArrayList commentList = new ArrayList();

        CustomAdapter adapter = new CustomAdapter(this,R.layout.detail_list,commentList);
        ListView listView =(ListView)findViewById(R.id.detail_listView);
        listView.setAdapter(adapter);


        commentList.add(new commentBord("익명1 : ","정말 감사 합니다. 잃어버려서 걱정 많이 했는데 정말 감사합니다."));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public void moveUpdateForm(View view) {
        Intent intent = new Intent(getApplicationContext(), UpdateActivity.class);
        startActivity(intent);
    }

    public void delete(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("삭제").setMessage("마지막으로 확인해주세요.");
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "삭제되었습니다", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    class CustomAdapter extends ArrayAdapter<commentBord> {
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
        public commentBord getItem(int pos){
            return (commentBord)list.get(pos);
        }
        public long getItemId(int pos){
            return pos;
        }

        public View getView(int pos, View convertView, ViewGroup parent){
            if(convertView == null){//스크롤이 넘어 갈때 재 사용 되는 view
                LayoutInflater inflater =context.getLayoutInflater();
                convertView = inflater.inflate(layout, null,true);
            }
            final commentBord list =  getItem(pos);
            TextView title = (TextView) convertView.findViewById(R.id.detail_text_id);
            TextView content = (TextView) convertView.findViewById(R.id.detail_text_comment);

            title.setText(list.title);
            content.setText(list.comment);



            return convertView;
        }

    }

    class commentBord {
        commentBord(String title,String comment){
            this.title=title;
            this.comment=comment;
        }
        String title;
        String comment;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_report:
                Intent intent = new Intent(getApplicationContext(), ReportActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}