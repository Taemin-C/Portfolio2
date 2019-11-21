package com.ctm.project;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.View;

public class Helper extends AppCompatActivity {

TextView ViewText,DailyText,ReviewText,OriginalText;
Button q1,q2,q3,q4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.helper);

        q1= (Button) findViewById(R.id.q1);
        q2= (Button) findViewById(R.id.q2);
        q3= (Button) findViewById(R.id.q3);
        q4= (Button) findViewById(R.id.q4);

        ViewText = (TextView)findViewById(R.id.viewtxt);
        DailyText = (TextView)findViewById(R.id.dailyfreetxt);
        ReviewText = (TextView)findViewById(R.id.review);
        OriginalText = (TextView)findViewById(R.id.original);
        ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle("도움말");
        actionBar.setDisplayHomeAsUpEnabled(true);

    }
    public void hOnClick(View v){
        switch (v.getId()){

            case R.id.q1:
                ViewText.setVisibility(View.VISIBLE);
                break;

            case R.id.q2:
                DailyText.setVisibility(View.VISIBLE);
                break;

            case R.id.q3:
                ReviewText.setVisibility(View.VISIBLE);
                break;
            case R.id.q4:
                OriginalText.setVisibility(View.VISIBLE);
                break;
            case R.id.viewtxt:
                ViewText.setVisibility(View.GONE);
                break;
            case R.id. dailyfreetxt:
                DailyText.setVisibility(View.GONE);
                break;
            case R.id.review:
                ReviewText.setVisibility(View.GONE);
                break;
            case R.id.original:
                OriginalText.setVisibility(View.GONE);
                break;
        }
    }
}
