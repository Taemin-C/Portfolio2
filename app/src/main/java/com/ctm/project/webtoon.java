package com.ctm.project;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

public class webtoon extends AppCompatActivity {
    Button btnmon, btntue, btnwed, btnthu, btnfri, btnsat, btnsun, btnallweek;
    LinearLayout monday;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webtoon);
        btnmon = (Button) findViewById(R.id.btnmon);
        btntue = (Button) findViewById(R.id.btntue);
        btnwed = (Button) findViewById(R.id.btnwed);
        btnthu = (Button) findViewById(R.id.btnthu);
        btnfri = (Button) findViewById(R.id.btnfri);
        btnsat = (Button) findViewById(R.id.btnsat);
        btnsun = (Button) findViewById(R.id.btnsun);
        btnallweek = (Button) findViewById(R.id.btnallweek);
        monday = (LinearLayout)findViewById(R.id.monday);

        ListView listview;
        ListViewAdapter adapter;

        adapter = new ListViewAdapter();

        listview = (ListView) findViewById(R.id.listview1);
        listview.setAdapter(adapter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.webtoonimg1), "후궁계약", "후궁으로 입궁해다오. 그게 내 의뢰다.", "밥꾹,붉은마녀,레죵");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.webtoonimg2), "창공의 크로이스", "여신이고 나발이고 난 모르겠다구!", "이린다");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.webtoonimg3), "트레이스-라스트", "각자의 생존을 위한 싸움이 시작된다!", "고영훈");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.webtoonimg4), "학사재생", "천하 제일의 사내, 금수저 물고 환생?", "소유현, 윰짝짝");

        ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle("웹툰");
        actionBar.setDisplayHomeAsUpEnabled(true);

listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0 :
                Intent whogungIntent2 = new Intent(webtoon.this,Whogung.class);
                startActivity(whogungIntent2);
        }
    }
});
            }




    public void mOnClick(View v) {
        switch (v.getId()) {

            case R.id.btnmon:
                monday.setVisibility(View.VISIBLE);
                btnmon.setBackgroundColor(Color.GRAY);
                btntue.setBackgroundColor(Color.WHITE);
                btnwed.setBackgroundColor(Color.WHITE);
                btnthu.setBackgroundColor(Color.WHITE);
                btnfri.setBackgroundColor(Color.WHITE);
                btnsat.setBackgroundColor(Color.WHITE);
                btnsun.setBackgroundColor(Color.WHITE);
                btnallweek.setBackgroundColor(Color.WHITE);
                break;
            case R.id.btntue:
                monday.setVisibility(View.INVISIBLE);
                btnmon.setBackgroundColor(Color.WHITE);
                btntue.setBackgroundColor(Color.GRAY);
                btnwed.setBackgroundColor(Color.WHITE);
                btnthu.setBackgroundColor(Color.WHITE);
                btnfri.setBackgroundColor(Color.WHITE);
                btnsat.setBackgroundColor(Color.WHITE);
                btnsun.setBackgroundColor(Color.WHITE);
                btnallweek.setBackgroundColor(Color.WHITE);
                break;
            case R.id.btnwed:
                monday.setVisibility(View.INVISIBLE);
                btnmon.setBackgroundColor(Color.WHITE);
                btntue.setBackgroundColor(Color.WHITE);
                btnwed.setBackgroundColor(Color.GRAY);
                btnthu.setBackgroundColor(Color.WHITE);
                btnfri.setBackgroundColor(Color.WHITE);
                btnsat.setBackgroundColor(Color.WHITE);
                btnsun.setBackgroundColor(Color.WHITE);
                btnallweek.setBackgroundColor(Color.WHITE);
                break;
            case R.id.btnthu:
                monday.setVisibility(View.INVISIBLE);
                btnmon.setBackgroundColor(Color.WHITE);
                btntue.setBackgroundColor(Color.WHITE);
                btnwed.setBackgroundColor(Color.WHITE);
                btnthu.setBackgroundColor(Color.GRAY);
                btnfri.setBackgroundColor(Color.WHITE);
                btnsat.setBackgroundColor(Color.WHITE);
                btnsun.setBackgroundColor(Color.WHITE);
                btnallweek.setBackgroundColor(Color.WHITE);
                break;
            case R.id.btnfri:
                monday.setVisibility(View.INVISIBLE);
                btnmon.setBackgroundColor(Color.WHITE);
                btntue.setBackgroundColor(Color.WHITE);
                btnwed.setBackgroundColor(Color.WHITE);
                btnthu.setBackgroundColor(Color.WHITE);
                btnfri.setBackgroundColor(Color.GRAY);
                btnsat.setBackgroundColor(Color.WHITE);
                btnsun.setBackgroundColor(Color.WHITE);
                btnallweek.setBackgroundColor(Color.WHITE);
                break;
            case R.id.btnsat:
                monday.setVisibility(View.INVISIBLE);
                btnmon.setBackgroundColor(Color.WHITE);
                btntue.setBackgroundColor(Color.WHITE);
                btnwed.setBackgroundColor(Color.WHITE);
                btnthu.setBackgroundColor(Color.WHITE);
                btnfri.setBackgroundColor(Color.WHITE);
                btnsat.setBackgroundColor(Color.GRAY);
                btnsun.setBackgroundColor(Color.WHITE);
                btnallweek.setBackgroundColor(Color.WHITE);
                break;
            case R.id.btnsun:
                monday.setVisibility(View.INVISIBLE);
                btnmon.setBackgroundColor(Color.WHITE);
                btntue.setBackgroundColor(Color.WHITE);
                btnwed.setBackgroundColor(Color.WHITE);
                btnthu.setBackgroundColor(Color.WHITE);
                btnfri.setBackgroundColor(Color.WHITE);
                btnsat.setBackgroundColor(Color.WHITE);
                btnsun.setBackgroundColor(Color.GRAY);
                btnallweek.setBackgroundColor(Color.WHITE);
                break;
            case R.id.btnallweek:
                btnmon.setBackgroundColor(Color.WHITE);
                btntue.setBackgroundColor(Color.WHITE);
                btnwed.setBackgroundColor(Color.WHITE);
                btnthu.setBackgroundColor(Color.WHITE);
                btnfri.setBackgroundColor(Color.WHITE);
                btnsat.setBackgroundColor(Color.WHITE);
                btnsun.setBackgroundColor(Color.WHITE);
                btnallweek.setBackgroundColor(Color.GRAY);
                break;


        }
    }
}

