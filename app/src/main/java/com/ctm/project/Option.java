package com.ctm.project;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class Option extends AppCompatActivity {
ListView optionlistview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.option);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("설정");
        actionBar.setDisplayHomeAsUpEnabled(true);

        optionlistview = (ListView)findViewById(R.id.optionlistview);
        OptionListViewAdapter adapter;
        adapter = new OptionListViewAdapter();

        optionlistview.setAdapter(adapter);

        adapter.addoption("이벤트 소식","이용권 및 무료 콘텐츠 알림을 받습니다.");
        adapter.addoption("야간 선물 받기","저녁8시~자정에 이용권, 뽑기권 선물 등을 받습니다.");
        adapter.addoption("댓글 좋아요","알림을 받습니다.");
        adapter.addoption("댓글의 댓글","알림을 받습니다.");
        adapter.addoption("3G/LTE에서 미리 다운로드 허용","데이터 네트워크 허용시 요금이 부과될 수 있습니다.");
        adapter.addoption("Wifi환경에서 영상 자동 재생","이벤트,프로모션 영상을 자동으로 재생합니다.");
        adapter.addoption("Wifi환경에서 광고 영상 자동 재생","광고 영상을 자동으로 재생합니다.");
    }
}
