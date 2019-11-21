package com.ctm.project;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.view.*;


public class DailyFreeNovel extends AppCompatActivity {
    Button gen,fan,rom,ori;
    LinearLayout Allgenre,nRomance,nFantazy;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dailyfreenovel);

        gen = (Button)findViewById(R.id.allgenre);
        fan = (Button)findViewById(R.id.fantazy);
        rom = (Button)findViewById(R.id.romance);
        ori = (Button)findViewById(R.id.oriental);
        Allgenre = (LinearLayout)findViewById(R.id.allnovelgenre);
        nRomance = (LinearLayout)findViewById(R.id.nRomance);
        nFantazy = (LinearLayout)findViewById(R.id.nfantazy);

        ListView listview,listview2,listview3;
        ListViewAdapter adapter,adapter2,adapter3;


        adapter = new ListViewAdapter();

        listview = (ListView) findViewById(R.id.listview);
        listview.setAdapter(adapter);
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.novelimg1), "템빨", "물약도 스킬도 필요없다!", "박새날");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.novelimg2), "디버프 마스터", "두방은 멋없잖아?", "담화공");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.novelimg3), "죽지않는 엑스트라", "이제 그만 죽고싶어!", "토이카");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.novelimg4), "외과의사 엘리제", "악녀 황후, 의사가 되어 돌아오다", "유인");

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0 :
                        Intent TemIntent = new Intent(DailyFreeNovel.this,Tem.class);
                        startActivity(TemIntent);
                }
            }
        });

        adapter2 = new ListViewAdapter();


        listview2 = (ListView)findViewById(R.id.listview2);
        listview2.setAdapter(adapter2);
        adapter2.addItem(ContextCompat.getDrawable(this, R.drawable.novelimg4), "외과의사 엘리제", "악녀 황후, 의사가 되어 돌아오다", "유인");

        adapter3 = new ListViewAdapter();


        listview3 = (ListView)findViewById(R.id.listview3);
        listview3.setAdapter(adapter3);
        adapter3.addItem(ContextCompat.getDrawable(this, R.drawable.novelimg1), "템빨", "물약도 스킬도 필요없다!", "박새날");
        adapter3.addItem(ContextCompat.getDrawable(this, R.drawable.novelimg2), "디버프 마스터", "두방은 멋없잖아?", "담화공");
        adapter3.addItem(ContextCompat.getDrawable(this, R.drawable.novelimg3), "죽지않는 엑스트라", "이제 그만 죽고싶어!", "토이카");

        listview3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0 :
                        Intent TemIntent = new Intent(DailyFreeNovel.this,Tem.class);
                        startActivity(TemIntent);
                }
            }
        });
    }

    public void nOnClick (View v) {
        switch (v.getId()){
            case R.id.allgenre:
                Allgenre.setVisibility(View.VISIBLE);
                nRomance.setVisibility(View.INVISIBLE);
                nFantazy.setVisibility(View.INVISIBLE);
                gen.setBackgroundColor(Color.GRAY);
                fan.setBackgroundColor(Color.WHITE);
                rom.setBackgroundColor(Color.WHITE);
                ori.setBackgroundColor(Color.WHITE);
                break;

            case R.id.fantazy:
                nFantazy.setVisibility(View.VISIBLE);
                Allgenre.setVisibility(View.INVISIBLE);
                nRomance.setVisibility(View.INVISIBLE);
                gen.setBackgroundColor(Color.WHITE);
                fan.setBackgroundColor(Color.GRAY);
                rom.setBackgroundColor(Color.WHITE);
                ori.setBackgroundColor(Color.WHITE);
                break;

            case R.id.romance:
                nFantazy.setVisibility(View.INVISIBLE);
                gen.setBackgroundColor(Color.WHITE);
                fan.setBackgroundColor(Color.WHITE);
                rom.setBackgroundColor(Color.GRAY);
                ori.setBackgroundColor(Color.WHITE);
                Allgenre.setVisibility(View.INVISIBLE);
                nRomance.setVisibility(View.VISIBLE);
                break;

            case R.id.oriental:
                nFantazy.setVisibility(View.INVISIBLE);
                gen.setBackgroundColor(Color.WHITE);
                fan.setBackgroundColor(Color.WHITE);
                rom.setBackgroundColor(Color.WHITE);
                ori.setBackgroundColor(Color.GRAY);
                Allgenre.setVisibility(View.INVISIBLE);
                nRomance.setVisibility(View.INVISIBLE);
                break;



        }
    }
}
