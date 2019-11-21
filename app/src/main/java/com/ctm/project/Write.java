package com.ctm.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;

public class Write extends AppCompatActivity {

    EditText titleEdit, contentEdit;
    DbHelper dbHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("글쓰기");
        titleEdit = (EditText)findViewById(R.id.TitleEdit_write);
        contentEdit = (EditText)findViewById(R.id.ContentEdit_write);

        Button btnOk = (Button)findViewById(R.id.OkBtn_write);
        Button btnCancle = (Button)findViewById(R.id.CancelBtn_write);

        dbHelper = new DbHelper(getApplicationContext());

        final Intent intent = getIntent();
        final boolean type = intent.getBooleanExtra("updateType",false);

        if(type == true){
            String title = review.post.title;
            String content = review.post.content;

            btnOk.setText("수정");
            actionBar.setTitle("수정하기");
            titleEdit.setText(title);
            contentEdit.setText(content);
        }

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleEdit.getText().toString();
                String content = contentEdit.getText().toString();
                SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
                String date = format.format(System.currentTimeMillis());

                String writer = intent.getStringExtra("id");
                Intent writercheck = new Intent(getApplicationContext(),Content.class);
                writercheck.putExtra("writer",writer);

                //입력한 값, 날짜, 로그인 정보를 이용하여 write table insert
                if(type){
                    int num = review.post.num;
                    dbHelper.updatePost(num, title, content);
                    Intent intent1 = new Intent(getApplicationContext(),review.class);
                    intent1.addFlags(FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent1);
                }else {
                    dbHelper.insertPost(title, content, date, writer);
                    finish();
                }
/*
                if(type){
                    dbHelper.insert(title,content,sDate);
                    finish();
                }else{
                    dbHelper.update(num,title,content,sDate);
                    Intent intent1 = new Intent(getApplicationContext(),MainActivity.class);
                    intent1.addFlags(FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent1);
                }
                */
            }
        });

        btnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titleEdit.setText("");
                contentEdit.setText("");
                finish();
            }
        });
    }
}