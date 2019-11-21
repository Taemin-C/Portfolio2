package com.ctm.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Service_center extends AppCompatActivity {
    Button helpbtn,questionbtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.servicecenter);
        ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle("고객센터");
        actionBar.setDisplayHomeAsUpEnabled(true);
        helpbtn = (Button)findViewById(R.id.helpbtn);
        questionbtn = (Button)findViewById(R.id.questionbtn);


        questionbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent questionIntent = new Intent(Service_center.this,Question.class);
                startActivity(questionIntent);
            }
        });

        helpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent helperIntent = new Intent(Service_center.this,Helper.class);
                startActivity(helperIntent);
            }
        });

    }
}
