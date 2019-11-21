package com.ctm.project;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

public class whogungExp extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.whogungexplanation);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("작품 소개");
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}
