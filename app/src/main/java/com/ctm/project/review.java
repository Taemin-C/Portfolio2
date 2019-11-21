package com.ctm.project;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class review extends AppCompatActivity {
    ArrayList<ListItem> arItem;
    ListItemAdapter listAdapter;
    DbHelper dbHelper;
    static ListItem post;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review);
        arItem = new ArrayList<ListItem>();
        listAdapter = new ListItemAdapter(this, R.layout.review_item, arItem);
        ListView list;
        list = (ListView)findViewById(R.id.ListView_list);
        list.setAdapter(listAdapter);
        getSupportActionBar().setTitle("리뷰");
        dbHelper = new DbHelper(this);
        Cursor c = dbHelper.searchPost();
        showData(c);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String title = arItem.get(position).title;
                String content = arItem.get(position).content;
                String date = arItem.get(position).date;
                String writer = "작성자";
                int num = arItem.get(position).num;

                post = new ListItem(num,title,content,date,writer);

                Intent intent = new Intent(getApplicationContext(), Content.class);
                startActivity(intent);
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.write_menu:
                Intent intent = new Intent(getApplicationContext(),Write.class);
                startActivity(intent);
                return true;

        }
        return false;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.list_menu,menu);
        return true;
    }
    public void showData(Cursor c){

        arItem.clear();
        while (c.moveToNext()){
            int num = c.getInt(c.getColumnIndex("_num"));
            String title = c.getString(c.getColumnIndex("title"));
            String content = c.getString(c.getColumnIndex("content"));
            String date = c.getString(c.getColumnIndex("date"));
            String writer = "작성자";
            ListItem item = new ListItem(num, title, content, date, writer);
            arItem.add(item);
        }
        listAdapter.notifyDataSetChanged();
    }
}
