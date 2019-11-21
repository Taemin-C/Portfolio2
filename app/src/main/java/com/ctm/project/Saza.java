package com.ctm.project;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Saza extends AppCompatActivity {
    TextView txtMovieExp;
    TextView txtmoreReading;
    Button btnMoreReading,btnstopReading;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saza);

        txtMovieExp = (TextView)findViewById(R.id.txtMovieExp);
        txtmoreReading = (TextView)findViewById(R.id.txtmoreReading);
        btnMoreReading = (Button)findViewById(R.id.btnmoreReading);
        btnstopReading = (Button)findViewById(R.id.btnstopReading);

        txtMovieExp.setText("어릴 적 아버지를 잃은 뒤 세상에 대한 불신만 남은 격투기 챔피언" +
                "'용후'(박서준). 어느날 원인을 알 수 없는 깊은 상처가 손바닥에 생긴" +
                "것을 발견하고, 도움을 줄 누군가가 있다는 장소로 향한다....");
        txtmoreReading.setText("그곳에서 바티칸에서 온 구마사제 '안신부'(안성기)를 만나 자신의" +
                "상처 난 손에 특별한 힘이 있음을 깨닫게 되는 '용후', 이를 통해 세상을 혼란에 빠뜨리는" +
                "악의 존재를 알게 되고, 강력한 배후이자 악을 퍼뜨리는 검은주교 '지신'(우도환)을 찾아나선" +
                "'안신부'와 함께 하게 되는데...! 악의 편에 설 것인가 악에 맞설 것인가 " +
                "2019년 여름, 신의 사자가 온다!");


        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("사자");
        actionBar.setDisplayHomeAsUpEnabled(true);

        btnMoreReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtmoreReading.setVisibility(View.VISIBLE);
                btnMoreReading.setVisibility(View.GONE);
                btnstopReading.setVisibility(View.VISIBLE);
            }
        });

        btnstopReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtmoreReading.setVisibility(View.GONE);
                btnMoreReading.setVisibility(View.VISIBLE);
                btnstopReading.setVisibility(View.GONE);
            }
        });
    }
}
