package com.ctm.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class Tem extends AppCompatActivity {
    ImageView baseimg;
    TextView basetitle,basewriter,txtcounter;
    RatingBar starscore;
    Spinner spin;
    String[] oldNew;
    ListView listview2;
    Button temExp,btnreview;
    RelativeLayout RLticket;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tem);
        btnreview=(Button)findViewById(R.id.btnreview);
        temExp = (Button)findViewById(R.id.Explanation);
        txtcounter = (TextView)findViewById(R.id.txtcounter);
        RLticket = (RelativeLayout)findViewById(R.id.RLticket);
        RLticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GoTicket = new Intent(getApplicationContext(),Ticket.class);
                startActivity(GoTicket);
            }
        });
        btnreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GoReview = new Intent(getApplicationContext(),review.class);
                startActivity(GoReview);
            }
        });

        oldNew = new String[]{"최신편부터","첫편부터"};

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("작품홈");
        actionBar.setDisplayHomeAsUpEnabled(true);

        final TextView score = (TextView)findViewById(R.id.score);
        starscore = (RatingBar)findViewById(R.id.starscore);
        spin = (Spinner)findViewById(R.id.spin);
        ArrayAdapter<String> sadpater = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,oldNew);
        spin.setAdapter(sadpater);

        listview2 = (ListView)findViewById(R.id.listview2);
        final HomeLIstAdapter adapter;
        adapter = new HomeLIstAdapter();

        listview2.setAdapter(adapter);
        adapter.addinven(ContextCompat.getDrawable(this, R.drawable.novelimg1), "템빨 1화", "2019.08.11 2.9MB");
        adapter.addinven(ContextCompat.getDrawable(this, R.drawable.novelimg1), "템빨 2화", "2019.08.11 1.6MB");
        adapter.addinven(ContextCompat.getDrawable(this, R.drawable.novelimg1), "템빨 3화", "2019.08.11 1.6MB");
        adapter.addinven(ContextCompat.getDrawable(this, R.drawable.novelimg1), "템빨 4화", "2019.08.11 2.4MB");
        adapter.addinven(ContextCompat.getDrawable(this, R.drawable.novelimg1), "템빨 5화", "2019.08.18 1.8MB");
        adapter.addinven(ContextCompat.getDrawable(this, R.drawable.novelimg1), "템빨 6화", "2019.08.25 1.5MB");
        adapter.addinven(ContextCompat.getDrawable(this, R.drawable.novelimg1), "템빨 7화", "2019.09.01 1.6MB");

        int i = adapter.getCount();
        txtcounter.setText("전체("+i+")");
        starscore.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                score.setText("평점 : "+ rating);
            }
        });

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        temExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ExpIntent = new Intent(Tem.this,TemExp.class);
                startActivity(ExpIntent);

            }
        });

    }





}

