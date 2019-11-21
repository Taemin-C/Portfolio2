package com.ctm.project;

import android.app.ActionBar;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;

public class Inventory extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventory);


                TabHost tab_host = getTabHost();
                TabHost.TabSpec spec;
                Intent intent;

                intent = new Intent().setClass(this, myinven.class);
                spec = tab_host.newTabSpec("my inven");
                spec.setIndicator("내 작품");
                spec.setContent(intent);
                tab_host.addTab(spec);


                intent = new Intent().setClass(this, Gift.class);

                spec = tab_host.newTabSpec("gift");
                spec.setIndicator("선물함");
                spec.setContent(intent);
                tab_host.addTab(spec);

                intent = new Intent().setClass(this, Notice.class);

                spec = tab_host.newTabSpec("notice");
                spec.setIndicator("알림");
                spec.setContent(intent);
                tab_host.addTab(spec);
                intent = new Intent().setClass(this, Like.class);

                spec = tab_host.newTabSpec("like");
                spec.setIndicator("좋아요");
                spec.setContent(intent);
                tab_host.addTab(spec);

                tab_host.setCurrentTab(0);


            }
/*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.gotohome) {
            Intent gotohome = new Intent(Inventory.this,MainActivity.class);
            startActivity(gotohome);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

        }

