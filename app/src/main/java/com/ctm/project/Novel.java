package com.ctm.project;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class Novel extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.novel);


        TabHost tab_host = getTabHost();
        TabHost.TabSpec spec;
        Intent intent;

        intent = new Intent().setClass(this, DailyFreeNovel.class);
        spec = tab_host.newTabSpec("Daily");
        spec.setIndicator("매일 무료");
        spec.setContent(intent);
        tab_host.addTab(spec);


        intent = new Intent().setClass(this,nOriginal.class);

        spec = tab_host.newTabSpec("origin");
        spec.setIndicator("오리지널");
        spec.setContent(intent);
        tab_host.addTab(spec);

        intent = new Intent().setClass(this, Fantazy.class);

        spec = tab_host.newTabSpec("fan");
        spec.setIndicator("판타지");
        spec.setContent(intent);
        tab_host.addTab(spec);

        intent = new Intent().setClass(this, Romance.class);

        spec = tab_host.newTabSpec("rom");
        spec.setIndicator("로맨스");
        spec.setContent(intent);
        tab_host.addTab(spec);

        intent = new Intent().setClass(this, Oriental.class);

        spec = tab_host.newTabSpec("ori");
        spec.setIndicator("무협");
        spec.setContent(intent);
        tab_host.addTab(spec);

        tab_host.setCurrentTab(0);


    }


}