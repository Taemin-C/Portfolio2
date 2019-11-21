package com.ctm.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Content extends AppCompatActivity {
    DbHelper dbHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        TextView titleTv = (TextView)findViewById(R.id.TitleTv_content);
        TextView contentTv = (TextView)findViewById(R.id.ContentTv_content);
        TextView dateTv = (TextView)findViewById(R.id.DateTv_content);
        TextView writerTv = (TextView)findViewById(R.id.WriterTv_content);
        Button updateBtn = (Button)findViewById(R.id.UpdateBtn_content);
        Button delBtn = (Button)findViewById(R.id.DeleteBtn_content);
        dbHelper = new DbHelper(this);

        titleTv.setText(review.post.title);
        contentTv.setText(review.post.content);
        dateTv.setText(review.post.date);
        writerTv.setText("작성자");

        Intent intent = getIntent();
        String i = intent.getStringExtra("writer");


            updateBtn.setEnabled(true);
            delBtn.setEnabled(true);


        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean updateType = true;
                Intent intent = new Intent(getApplicationContext(), Write.class);
                intent.putExtra("updateType",updateType);
                startActivity(intent);
            }
        });

        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = review.post.num;
                dbHelper.deletePost(num);
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return false;
    }
}
