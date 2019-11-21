package com.ctm.project;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class myinven extends AppCompatActivity {
    ListView InvenList;
    Button Allbtn,buybtn,downbtn;
    TextView buytext,downtext;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myinven);

        Allbtn = (Button)findViewById(R.id.Allbtn);
        buybtn = (Button)findViewById(R.id.buybtn);
        downbtn = (Button)findViewById(R.id.downbtn);
        buytext = (TextView)findViewById(R.id.buytext);
        downtext = (TextView)findViewById(R.id.downtext);

        InvenList = (ListView) findViewById(R.id.invenlist);
        ListAdapter adapter;
        adapter = new ListAdapter(getApplicationContext());

        InvenList.setAdapter(adapter);

        adapter.addinven(ContextCompat.getDrawable(this, R.drawable.webtoonimg1), "후궁계약", "2019.08.26 업데이트");
        adapter.addinven(ContextCompat.getDrawable(this, R.drawable.webtoonimg2), "창공의 크로이스", "2017.12.26 업데이트");
        adapter.addinven(ContextCompat.getDrawable(this, R.drawable.webtoonimg3), "트레이스-라스트", "2019.03.26 업데이트");
        adapter.addinven(ContextCompat.getDrawable(this, R.drawable.webtoonimg4), "학사재생", "2019.06.08 업데이트");

InvenList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0 :
                Intent whogungIntent = new Intent(myinven.this,Whogung.class);
                startActivity(whogungIntent);
                break;
        }

    }
});



    }
    public void IOnClick (View v){
        switch(v.getId()){
            case R.id.Allbtn:
                InvenList.setVisibility(View.VISIBLE);
                buytext.setVisibility(View.INVISIBLE);
                downtext.setVisibility(View.INVISIBLE);
                Allbtn.setTextColor(Color.BLACK);
                buybtn.setTextColor(Color.GRAY);
                downbtn.setTextColor(Color.GRAY);
                break;

            case R.id.buybtn:
                InvenList.setVisibility(View.INVISIBLE);
                buytext.setVisibility(View.VISIBLE);
                downtext.setVisibility(View.INVISIBLE);
                Allbtn.setTextColor(Color.GRAY);
                buybtn.setTextColor(Color.BLACK);
                downbtn.setTextColor(Color.GRAY);
                break;

            case R.id.downbtn:
                InvenList.setVisibility(View.INVISIBLE);
                buytext.setVisibility(View.INVISIBLE);
                downtext.setVisibility(View.VISIBLE);
                Allbtn.setTextColor(Color.GRAY);
                buybtn.setTextColor(Color.GRAY);
                downbtn.setTextColor(Color.BLACK);
                break;







        }

    }

}
