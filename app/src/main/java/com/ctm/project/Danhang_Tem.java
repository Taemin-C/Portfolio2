package com.ctm.project;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

public class Danhang_Tem extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.danhang_tem);
        ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle("단행본");
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}
