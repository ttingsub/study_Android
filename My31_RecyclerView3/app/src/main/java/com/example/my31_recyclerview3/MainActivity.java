package com.example.my31_recyclerview3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SoccerAdapter adapter;
    ArrayList<SoccerDto> dtos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 반드시 생성해서 어댑터에 넘겨야 함
        dtos = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerView);

        // 리사이클러뷰에서 반드시 초기화 시켜야함
        LinearLayoutManager layoutManager = new LinearLayoutManager(
               this, RecyclerView.VERTICAL, false
        );
        recyclerView.setLayoutManager(layoutManager);

        // 어댑터 객체를 생성한다
        adapter = new SoccerAdapter(dtos, com.example.my31_recyclerview3.MainActivity.this);

        // 어댑터에 있는 ArrayList에 dto를 5개 추가한다
        adapter.addDto(new SoccerDto("손흥민", "토트넘 홋스퍼",
                "https://www.tottenhamhotspur.com/kr/",25, R.drawable.son));
        adapter.addDto(new SoccerDto("이강인", "발렌시아 CF",
                "https://www.valenciacf.com/en ", 27, R.drawable.lee));
        adapter.addDto(new SoccerDto("황희찬", "RB 라이프치히",
                "https://www.dierotenbullen.com/", 22,R.drawable.hwang));
        adapter.addDto(new SoccerDto("황의조", "지롱댕 드 보르도",
                "https://www.girondins.com/en", 30,R.drawable.hwang2));
        adapter.addDto(new SoccerDto("기성용", "FC 서울",
                "https://www.fcseoul.com/", 28,R.drawable.ki));
        // 만든 어댑터를 리스트뷰에 붙인다
        recyclerView.setAdapter(adapter);

        //어댑터에 있는 클릭리스너를 이용해 클릭한 위치의 dto를 가져온다
        adapter.setOnItemClickListener(new com.example.my31_recyclerview3.OnSingerItemClickListener() {
            @Override
            public void onItemClick(SoccerAdapter.ViewHolder holderm, View view, int position) {
                // 클릭하면 어댑터에게 받은 클릭위치를 이용해 dto 가져온다.
                SoccerDto dto = adapter.getItem(position);

                Toast.makeText(com.example.my31_recyclerview3.MainActivity.this, dto.getSite(), Toast.LENGTH_SHORT).show();

                 Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(dto.getSite()));
                startActivity(intent);
            }
        });

    }
}